package com.store.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * Eureka事件监听
 *
 * @author yinjihuan
 * @create 2018-03-09 13:45
 **/
@Component
public class EurekaStateChangeListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(EurekaStateChangeListener.class);


    /*@EventListener
    public void listen(EurekaInstanceCanceledEvent event) {
        LOGGER.info("{}_{}_服务下线",event.getServerId(),event.getAppName());
    }

    @EventListener
    public void listen(EurekaInstanceRegisteredEvent event) {
        InstanceInfo instanceInfo = event.getInstanceInfo();
        LOGGER.info(instanceInfo.getAppName() + "进行注册");
    }*/

    @EventListener
    public void listen(EurekaInstanceRenewedEvent event) {
        LOGGER.info("{}_{}_服务续约",event.getServerId(),event.getAppName());

    }

    /*@EventListener
    public void listen(EurekaRegistryAvailableEvent event) {
        LOGGER.info("注册中心 启动");
    }

    @EventListener
    public void listen(EurekaServerStartedEvent event) {
        LOGGER.info("Eureka Server 启动");
    }*/

}
