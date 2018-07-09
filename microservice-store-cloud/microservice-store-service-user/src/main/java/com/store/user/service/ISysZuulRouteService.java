package com.store.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.store.model.SysZuulRoute;

/**
 * <p>
 * 动态路由配置表 服务类
 * </p>
 *
 * @author lengleng
 * @since 2018-05-15
 */
public interface ISysZuulRouteService extends IService<SysZuulRoute> {

    /**
     * 立即生效配置
     * @return
     */
    Boolean applyZuulRoute();
}
