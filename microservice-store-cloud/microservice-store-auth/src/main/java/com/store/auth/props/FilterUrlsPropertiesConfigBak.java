package com.store.auth.props;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lengleng
 * @date 2018/1/9
 */
@Component
@Configuration
//@ConditionalOnExpression("!'${urls}'.isEmpty()")
@ConfigurationProperties(prefix = "ignore")
public class FilterUrlsPropertiesConfigBak {
    private List<String> anon = new ArrayList<>();

    public List<String> getAnon() {
        return anon;
    }

    public void setAnon(List<String> anon) {
        this.anon = anon;
    }
}
