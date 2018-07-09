package com.store.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * <br/>主要是关于验证数据存储的相关配置
 * <br/>Created by Mr.Yangxiufeng on 2017/12/28.
 * <br/>update by zhikai.chen on 2018/04/XX.
 */
//@Configuration
//@Order(Integer.MIN_VALUE)
//@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
////        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
////        clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENTDEFAULT_SELECT_STATEMENT);
////        clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
////        clients.withClientDetails(clientDetailsService);
//
//        clients.withClientDetails(clientDetails());
//    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //token增强配置
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(
//                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

        endpoints
                .tokenStore(redisTokenStore())
                .tokenEnhancer(tokenEnhancerChain)
                .authenticationManager(authenticationManager)
                .reuseRefreshTokens(false)
                .userDetailsService(userDetailsService);
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security
                .allowFormAuthenticationForClients()
                .tokenKeyAccess("isAuthenticated()")
                .checkTokenAccess("permitAll()");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        PigJwtAccessTokenConverter jwtAccessTokenConverter = new PigJwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey(CommonConstant.SIGN_KEY);
//        return jwtAccessTokenConverter;
//    }

    /**
     * tokenstore 定制化处理
     *
     * @return TokenStore
     * 1. 如果使用的 redis-cluster 模式请使用 PigRedisTokenStore
     * PigRedisTokenStore tokenStore = new PigRedisTokenStore();
     * tokenStore.setRedisTemplate(redisTemplate);
     */
//    @Bean
//    public TokenStore redisTokenStore() {
//        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
//        tokenStore.setPrefix(SecurityConstants.PIG_PREFIX);
//        return tokenStore;
//    }

    @Bean
    RedisTokenStore redisTokenStore(){
        return new RedisTokenStore(redisConnectionFactory);
    }

    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
//    @Bean
//    public TokenEnhancer tokenEnhancer() {
//        return (accessToken, authentication) -> {
//            final Map<String, Object> additionalInfo = new HashMap<>(1);
//            additionalInfo.put("license", SecurityConstants.PIG_LICENSE);
//            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
//            return accessToken;
//        };
//    }

}
