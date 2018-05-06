package com.store.auth.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * MyProps.class
 * Description:
 *
 * @author lupo
 * @date 2018/2/11 14:10
 */
@Component
@ConfigurationProperties(prefix="my-props") //接收application.yml中的myProps下面的属性
public class MyProps {

    private List<Map<String,String>> jwtWhiteList = new ArrayList<>();
    private List<Map<String,String>> clientWhiteList = new ArrayList<>();


    public List<Map<String, String>> getJwtWhiteList() {
        return jwtWhiteList;
    }

    public List<Map<String, String>> getClientWhiteList() {
        return clientWhiteList;
    }
}
