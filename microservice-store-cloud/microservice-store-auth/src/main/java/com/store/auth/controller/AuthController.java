package com.store.auth.controller;

import com.store.auth.service.IAuthService;
import com.store.auth.vo.JwtAuthenticationVo;
import com.store.utils.ClientTokenUtil;
import com.store.utils.JWTTokenUtil;
import com.store.utils.ResultVOUtil;
import com.store.utils.jwt.IJWTInfo;
import com.store.vo.ObjectRestResponse;
import com.store.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * ClientRest.class
 * Description: jwt授权
 *
 */
@RestController
@Slf4j
public class AuthController {

    @Autowired
    private IAuthService authService;

    @RequestMapping(value = "/client/token",method = RequestMethod.POST)
    public ResultVO<String> authorize(@RequestParam("si") String serviceId, @RequestParam("st") String secret) throws Exception {
        log.info("si:{},st:{}",serviceId,secret);
        IJWTInfo ijwtInfo = authService.authByService(serviceId, secret);
        ResultVO resultVO = ResultVOUtil.success(ClientTokenUtil.Singleton().generateToken(ijwtInfo));
        return resultVO;
    }

    @PostMapping("/jwt/token")
    public ResultVO<String> authorize(@RequestBody JwtAuthenticationVo jwtAuthenticationVo) throws Exception {
        log.info("nm:{},pd:{}", jwtAuthenticationVo.getLoginname(), jwtAuthenticationVo.getPassword());
        IJWTInfo info = authService.authByLogin(jwtAuthenticationVo.getLoginname(), jwtAuthenticationVo.getPassword());
        ResultVO resultVO = ResultVOUtil.success(JWTTokenUtil.Singleton().generateToken(info));
        return resultVO;
    }

}
