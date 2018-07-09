package com.store.service;

import com.netflix.zuul.context.RequestContext;

/**
 * @author chenyouhong
 * @date 2018/06/22
 */
public interface LogSendService {
    /**
     * 往消息通道发消息
     *
     * @param requestContext requestContext
     */
    void send(RequestContext requestContext);

}
