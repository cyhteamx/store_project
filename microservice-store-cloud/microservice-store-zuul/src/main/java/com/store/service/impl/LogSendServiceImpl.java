package com.store.service.impl;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;
import com.netflix.zuul.context.RequestContext;
import com.store.constants.CommonConstants;
import com.store.model.SysLog;
import com.store.service.LogSendService;
import com.store.vo.LogVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author chenyouhong
 * @date 2018/06/22
 *
 * 消息发往消息队列工具类
 */
@Component
@Slf4j
public class LogSendServiceImpl implements LogSendService {

    private static final String SERVICE_ID = "serviceId";

//    @Autowired
//    private AmqpTemplate rabbitTemplate;

    /**
     * 1. 获取 requestContext 中的请求信息
     * 2. 如果返回状态不是OK，则获取返回信息中的错误信息
     * 3. 发送到MQ
     *
     * @param requestContext 上下文对象
     */
    @Override
    public void send(RequestContext requestContext) {
        HttpServletRequest request = requestContext.getRequest();
        String requestUri = request.getRequestURI();
        String method = request.getMethod();
        SysLog sysLog = new SysLog();
        sysLog.setType(CommonConstants.STATUS_NORMAL);
        sysLog.setRemoteAddr(HttpUtil.getClientIP(request));
        sysLog.setRequestUri(URLUtil.getPath(requestUri));
        sysLog.setMethod(method);
        sysLog.setUserAgent(request.getHeader("user-agent"));
        sysLog.setParams(HttpUtil.toParams(request.getParameterMap()));
        Long startTime = (Long) requestContext.get("startTime");
        sysLog.setTime(System.currentTimeMillis() - startTime);
        if (requestContext.get(SERVICE_ID) != null) {
            sysLog.setServiceId(requestContext.get(SERVICE_ID).toString());
        }

        //正常发送服务异常解析
        if (requestContext.getResponseStatusCode() == HttpStatus.SC_INTERNAL_SERVER_ERROR
                && requestContext.getResponseDataStream() != null) {
            InputStream inputStream = requestContext.getResponseDataStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            InputStream stream1 = null;
            InputStream stream2;
            byte[] buffer = IoUtil.readBytes(inputStream);
            try {
                baos.write(buffer);
                baos.flush();
                stream1 = new ByteArrayInputStream(baos.toByteArray());
                stream2 = new ByteArrayInputStream(baos.toByteArray());
                String resp = IoUtil.read(stream1, CommonConstants.UTF8);
                sysLog.setType(CommonConstants.STATUS_LOCK);
                sysLog.setException(resp);
                requestContext.setResponseDataStream(stream2);
            } catch (IOException e) {
                log.error("响应流解析异常：", e);
                throw new RuntimeException(e);
            } finally {
                IoUtil.close(stream1);
                IoUtil.close(baos);
                IoUtil.close(inputStream);
            }
        }

        //网关内部异常
        Throwable throwable = requestContext.getThrowable();
        if (throwable != null) {
            log.error("网关异常", throwable);
            sysLog.setException(throwable.getMessage());
        }

        //保存发往MQ（只保存授权）
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && StrUtil.isNotBlank(authentication.getName())) {
            LogVO logVo = new LogVO();
            sysLog.setCreateBy(authentication.getName());
            logVo.setSysLog(sysLog);
            logVo.setUsername(authentication.getName());
//            rabbitTemplate.convertAndSend(IMqQueueConstant.LOG_QUEUE, logVo);
        }
    }
}
