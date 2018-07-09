package com.store.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.store.constants.CommonConstants;
import com.store.mapper.ISysZuulRouteMapper;
import com.store.model.SysZuulRoute;
import com.store.user.service.ISysZuulRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 动态路由配置表 服务实现类
 * </p>
 *
 * @author lengleng
 * @since 2018-05-15
 */
@Service
public class SysZuulRouteServiceImpl extends ServiceImpl<ISysZuulRouteMapper, SysZuulRoute> implements ISysZuulRouteService {

    @Autowired
    private RedisTemplate redisTemplate;

//    @Autowired
//    private RabbitTemplate rabbitTemplate;

    /**
     * 立即生效配置
     *
     * @return
     */
    @Override
    public Boolean applyZuulRoute() {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.eq(CommonConstants.DEL_FLAG, CommonConstants.STATUS_NORMAL);
        List<SysZuulRoute> routeList=selectList(wrapper);
        redisTemplate.opsForValue().set(CommonConstants.ROUTE_KEY, routeList);
//        rabbitTemplate.convertAndSend(MqQueueConstant.ROUTE_CONFIG_CHANGE, 1);
        return Boolean.TRUE;
    }

}