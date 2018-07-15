package com.store.auth.config;

import com.store.auth.props.FilterUrlsPropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * @author lengleng
 * @date 2018/3/10
 */
@Order(SecurityProperties.BASIC_AUTH_ORDER - 1)
@Configuration
@EnableWebSecurity
public class PigSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

    @Autowired
    private FilterUrlsPropertiesConfig filterUrlsPropertiesConfig;

//    @Autowired
//    private MobileSecurityConfigurer mobileSecurityConfigurer;

//    @Autowired
//    private UserDetailsServiceImpl userDetailsService;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    @Bean
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }
//
    //不定义没有password grant_type
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService)
//            .passwordEncoder(passwordEncoder());
//    }

//    @Autowired//注意这个方"/authentication/require"法是注入的
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService());
//    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry =
                http
//                        .requestMatchers().anyRequest()
//                        .and()
//                        .formLogin().loginPage("/authentication/require")
//                        OAUTH_CLIENT_DETAILS.loginProcessingUrl("/authentication/form")
//                        .and()
                        .authorizeRequests();
        for (String url : filterUrlsPropertiesConfig.getAnon()) {
            registry.antMatchers(url).permitAll();
        }
        registry.anyRequest().authenticated()
                .and()
                .csrf().disable();
//        http.apply(mobileSecurityConfigurer);

//        http.authorizeRequests().antMatchers(HttpMethod.OPTIONS).permitAll().anyRequest().authenticated().and()
//                .httpBasic().and().csrf().disable();
    }


}
