package com.store.user.listener;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.store.constants.CommonConstants;
import com.store.model.SysZuulRoute;
import com.store.user.service.ISysZuulRouteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

//import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;

/**
 * @author lengleng
 * @date 2018/5/16
 */
@Slf4j
@Component
public class RouteConfigInitListener {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ISysZuulRouteService sysZuulRouteService;

    /**
     * Callback used to run the bean.
     * 初始化路由配置的数据，避免gateway 依赖业务模块
     *
     */
//    @EventListener(value = {EmbeddedServletContainerInitializedEvent.class})
    @EventListener(value = {ApplicationStartedEvent.class})
    public void init() {
        log.info("开始初始化路由配置数据");
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq(CommonConstants.DEL_FLAG, CommonConstants.STATUS_NORMAL);
        List<SysZuulRoute> routeList = sysZuulRouteService.selectList(wrapper);
        if (CollUtil.isNotEmpty(routeList)) {
            redisTemplate.opsForValue().set(CommonConstants.ROUTE_KEY, routeList);
            log.info("更新Redis中路由配置数据：{}条", routeList.size());
        }
        log.info("初始化路由配置数据完毕");
    }
}