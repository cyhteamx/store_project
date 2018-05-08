package com.store.filter;

import cn.hutool.core.exceptions.ValidateException;
import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import com.store.api.IOauth;
import com.store.constants.CommonConstants;
import com.store.exception.auth.ClientInvalidException;
import com.store.exception.auth.TokenErrorException;
import com.store.service.AccessService;
import com.store.service.IAuthService;
import com.store.utils.JWTTokenUtil;
import com.store.utils.jwt.IJWTInfo;
import com.store.vo.BaseResponse;
import com.store.vo.ObjectRestResponse;
import com.store.vo.ResultVO;
import io.jsonwebtoken.JwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import sun.security.util.SecurityConstants;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

/**
 * @describe 统一验证
 */
@Component
@Slf4j
public class PreRequestFilter extends ZuulFilter {

    private static final String X_TOKEN = "access_token";


    @Value("${spring.application.name}")
    private String appName;
    @Value("${client.secret}")
    private String secret;
//    @Value("${zuul.prefix}")
//    private String prefix;

    @Autowired
    private IOauth oauth;

    @Autowired
    private AccessService accessService;

    @Autowired
    @Lazy
    private IAuthService authService;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 5;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info("send {} request to {}",request.getMethod(),request.getRequestURL().toString());
        String sourcePath=request.getServletPath();
        log.info("sourcePath: "+sourcePath);

        String requestURI = request.getRequestURI();
        String token = null ;

        String s = request.getHeader("name");
        log.info("================, s=:{}", s);

        token = request.getHeader(CommonConstants.JWT_ACCESS_TOKEN);

//        Enumeration<String> el = request.getHeaderNames();
//        while(el.hasMoreElements()){
//            String headerName = el.nextElement();//透明称
//            Enumeration<String> headerValues = request.getHeaders(headerName);
//            while(headerValues.hasMoreElements()){
//                System.out.println(headerName+":"+headerValues.nextElement());
//            }
//        }

        RequestContext requestContext = RequestContext.getCurrentContext();
        requestContext.addZuulRequestHeader(CommonConstants.JWT_ACCESS_TOKEN, token);

	    try {
            // 请求路径白名单
            if (accessService.ignoreUri(requestURI)) {
                return null;
            }

            log.info("准备向鉴权服务发送请求获取客户端的client-token.");
            ResultVO<String> response = authService.authorize(appName, secret);
            if (response.getCode() == 200) {
//                ResultVO<String> clientToken = response;
                log.info("向鉴权服务发送请求获取客户端的client-token.成功，获取的client-token为：{}", response.getData());
                ctx.addZuulRequestHeader(CommonConstants.CLIENT_ACCESS_TOKEN, response.getData());
            } else {
                throw new ClientInvalidException();
            }

            token = request.getHeader(CommonConstants.JWT_ACCESS_TOKEN);

            // 检验登录token
            log.info("准备检验登录access-token:{}", token);
            IJWTInfo ijwtInfo = JWTTokenUtil.Singleton().getInfoFromToken(token);
            log.info("检验登录access-token成功，当前登录人员为：{}", ijwtInfo.getName());
        } catch (InvalidKeySpecException | NoSuchAlgorithmException | JwtException | ValidateException e) {
            log.error("检验登录token:{},校验失败！", token);
            log.error("异常信息为：{}", e.getMessage());
            ctx.setResponseBody(JSON.toJSONString(new TokenErrorException()));
        } catch (ClientInvalidException ex) {
            log.error("向鉴权服务发送请求获取客户端的client-token失败，appName:{}", appName);
            ctx.setResponseBody(JSON.toJSONString(new BaseResponse(ex.getStatus(), ex.getMessage())));
        } catch (Exception e) {
            log.error("异常信息为：{}", e.getMessage());
            ctx.setResponseBody(JSON.toJSONString(new TokenErrorException()));
        }



//
//	    // 先取Header中X-Token
//        String accessToken = request.getHeader(X_TOKEN);
//        // 如果令牌为空, 再取Cookie中X-Token
//        if (StringUtils.isBlank(accessToken)) {
//            Cookie[] cookies = request.getCookies();
//            if (cookies != null) {
//                for (Cookie cookie : cookies) {
//                    if (X_TOKEN.equals(cookie.getName())) {
//                        accessToken = cookie.getValue();
//                        break;
//                    }
//                }
//            }
//        }
//        // 如果令牌为空, 再取QueryString中X-Token
//        if (StringUtils.isBlank(accessToken)) {
//            accessToken = request.getParameter(X_TOKEN);
//        }
//
//        boolean ok=true;
//        String message = null;
//        if (StringUtils.isNotBlank(accessToken)) {
//            log.info("accessToken: "+accessToken);
//            //TODO 自己统一验证
//            try{
//            	Map<String,String> result=oauth.check(accessToken,sourcePath);
//            	int code=Integer.parseInt(result.get("code"));
//            	String info=result.get("info");
//                log.info("result: "+info);
//            	if(code!=0){
//            		ok=false;
//            		message=info;
//            	}
//    		}catch(Exception e){
//    			ok=false;
//    			message=e.getMessage();
//    			e.printStackTrace();
//    		}
//        }
//
//        if(ok){
//        	ctx.setSendZuulResponse(true); //对请求进行路由
//            ctx.setResponseStatusCode(200);
//            ctx.set("isSuccess", true);
//        }else {
//            ctx.setSendZuulResponse(false); //不对其进行路由
//            ctx.setResponseStatusCode(400);
//            ctx.setResponseBody(message);
//            ctx.set("isSuccess", false);
//        }
        return null;
    }
}
