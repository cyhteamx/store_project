package com.store.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 白名单
 */
@Data
@Component
//@Bean
@ConfigurationProperties("while-list")
public class WhiteListConfig {

    // 请求白名单
    private List<String> uriWhiteList = new ArrayList<>();
//
//
//    public List<String> getUriWhiteList() {
//        return uriWhiteList;
//    }
//
//    public void setUriWhiteList(List<String> uriWhiteList) {
//        this.uriWhiteList = uriWhiteList;
//    }
}
