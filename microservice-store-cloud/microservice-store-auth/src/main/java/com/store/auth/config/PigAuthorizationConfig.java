package com.store.auth.config;

import com.store.constants.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lengleng
 * @date 2017/10/27
 * 认证服务器逻辑实现
 */

@Configuration
@Order(Integer.MIN_VALUE)
@EnableAuthorizationServer
public class PigAuthorizationConfig extends AuthorizationServerConfigurerAdapter {

//    @Autowired
//    private AuthServerConfig authServerConfig;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private RedisConnectionFactory redisConnectionFactory;

    @Autowired
    private DataSource dataSource;

//    @Bean
//    public ClientDetailsService clientDetails() {
//        return new JdbcClientDetailsService(dataSource);
//    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
        clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
        clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
        clients.withClientDetails(clientDetailsService);
    }

//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        String finalSecret = new BCryptPasswordEncoder().encode(authServerConfig.getClientSecret());
//
//        clients.inMemory()
//                .withClient(authServerConfig.getClientId())
////                .secret(authServerConfig.getClientSecret())
//                .secret(finalSecret)
//                .authorizedGrantTypes(SecurityConstants.REFRESH_TOKEN, SecurityConstants.PASSWORD, SecurityConstants.AUTHORIZATION_CODE)
//                .scopes(authServerConfig.getScope())
//                .autoApprove(true);
////        clients.withClientDetails(clientDetails());
//
//    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        //token增强配置
        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));

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

    @Bean
    public JwtAccessTokenConverter jwtAccessTokenConverter() {
        PigJwtAccessTokenConverter jwtAccessTokenConverter = new PigJwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey(CommonConstants.SIGN_KEY);

        jwtAccessTokenConverter.setSigningKey(SecurityConstants.PRIVATE_KEY_SIGNING_KEY);
        jwtAccessTokenConverter.setVerifierKey(SecurityConstants.PUBLIC_VERIFY_KEY);
//        JWTTokenUtil.Singleton().generateToken();
        return jwtAccessTokenConverter;
    }

    /**
     * tokenstore 定制化处理
     *
     * @return TokenStore
     * 1. 如果使用的 redis-cluster 模式请使用 PigRedisTokenStore
     * PigRedisTokenStore tokenStore = new PigRedisTokenStore();
     * tokenStore.setRedisTemplate(redisTemplate);
     */
    @Bean
    public TokenStore redisTokenStore() {
        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
        tokenStore.setPrefix(SecurityConstants.PIG_PREFIX);
        return tokenStore;
    }

    /**
     * jwt 生成token 定制化处理
     *
     * @return TokenEnhancer
     */
    @Bean
    public TokenEnhancer tokenEnhancer() {
        return (accessToken, authentication) -> {
            final Map<String, Object> additionalInfo = new HashMap<>(1);
            additionalInfo.put("license", SecurityConstants.PIG_LICENSE);
            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
            return accessToken;
        };
    }





    ///////////////
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        JdbcClientDetailsService clientDetailsService = new JdbcClientDetailsService(dataSource);
//        clientDetailsService.setSelectClientDetailsSql(SecurityConstants.DEFAULT_SELECT_STATEMENT);
//        clientDetailsService.setFindClientDetailsSql(SecurityConstants.DEFAULT_FIND_STATEMENT);
//        clients.withClientDetails(clientDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
//        //token增强配置
//        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
//        tokenEnhancerChain.setTokenEnhancers(
//                Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));
//
//        endpoints
//                .tokenStore(redisTokenStore())
//                .tokenEnhancer(tokenEnhancerChain)
//                .authenticationManager(authenticationManager)
//                .reuseRefreshTokens(false)
//                .userDetailsService(userDetailsService);
//    }
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security
//                .allowFormAuthenticationForClients()
//                .tokenKeyAccess("isAuthenticated()")
//                .checkTokenAccess("permitAll()");
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        PigJwtAccessTokenConverter jwtAccessTokenConverter = new PigJwtAccessTokenConverter();
//        jwtAccessTokenConverter.setSigningKey(CommonConstants.SIGN_KEY);
//        return jwtAccessTokenConverter;
//    }
//
//    /**
//     * tokenstore 定制化处理
//     *
//     * @return TokenStore
//     * 1. 如果使用的 redis-cluster 模式请使用 PigRedisTokenStore
//     * PigRedisTokenStore tokenStore = new PigRedisTokenStore();
//     * tokenStore.setRedisTemplate(redisTemplate);
//     */
//    @Bean
//    public TokenStore redisTokenStore() {
//        RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
//        tokenStore.setPrefix(SecurityConstants.PIG_PREFIX);
//        return tokenStore;
//    }
//
//    /**
//     * jwt 生成token 定制化处理
//     *
//     * @return TokenEnhancer
//     */
//    @Bean
//    public TokenEnhancer tokenEnhancer() {
//        return (accessToken, authentication) -> {
//            final Map<String, Object> additionalInfo = new HashMap<>(1);
//            additionalInfo.put("license", SecurityConstants.PIG_LICENSE);
//            ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
//            return accessToken;
//        };
//    }


    //PRIVATE KEY
    private String privateKeySigningKey1 = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIEogIBAAKCAQEA5aP/2VEGL/ZneHWof9prZTLbrS6WVAyLsADq4HE6Jzhpdvqi\n" +
            "JRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m8nUWKVN3C2/gFKIud9NMsYZh5FGP\n" +
            "ftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW9Um2FnA3OZ2O1t83r8OEk2Ks9wjR\n" +
            "YoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9takH9XJJR44eopbaTPD/JpmysnzS\n" +
            "vj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKMlHzJgatsD4mLEc5VvbR+GqZ4zc1n\n" +
            "ilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8iwIDAQABAoIBAA/dtN+e6X6G179K\n" +
            "4clzndfwG51ripdkBoKyjYfUSuBK1X6S8oD9RKz3Sr71FPKkwI5kYQW6KqwG1TZ2\n" +
            "DuoGPSKjVFSmn6L6p9DFI9DDmJjrX/gWaoOokKtNAKaktm84YVTYKzfc/XFtTBOa\n" +
            "/mcy2Xc5EIucVTR13liaM47BQ3erSCYQJvqxf0TZA1uqjJD9JHbtgijoEcE8IqqC\n" +
            "WN4NRVIugj/qJqwIvjhOzXNGbuumNKkA78xoJLIAuLrYh7HoS0jvNAp7BQXqnY6G\n" +
            "HW/cwatom/UpXpCn+cFLhQ5U7b+ulnQ0n20lP1C4sSfrwQdNhFRz5srxIe86E8yl\n" +
            "devOHoECgYEA9e8oKJbkjvkIQSC8sXpQUhGHO7z/m1ZU3khsjtBAdrtsMzhPVZqE\n" +
            "B4rqF7DHN5JyoYCsX0FDBGV6b7jR8WKIGacXPFEdWI2m1j8OCtVhza12udU54ql1\n" +
            "LxFp6uvBxogIesTIAH/wm8B1ctP/UIxnRNVeODyNFEWbYh0v8ZAhH4UCgYEA7wof\n" +
            "PlhAmelaOq5h0Ia9/AtYKnid28OeVI/8TGuQNV5uVUe+K2k6W8g9K2znnsEXq+y/\n" +
            "q7kkejXHTvXwH1POqsx91D6F4Yk2TkxpIZkSWu99DRX60wI0VgzCIszcUubzlPHH\n" +
            "r07hs0HetYeVM7a4EF/ThxuJgJp3joKsBYhxgM8CgYB9L8/xWV3eqUVaYZ+rd+eK\n" +
            "3wFHl11FZRyuSY944ujth1n8eJ1ppc2vSTb/+CxwTUusiiM0GbRTeJRqalnz1YQS\n" +
            "Csv5GBEoEnLqfA5Z1WSDndjhn3hnuHq+Cs8vlfJ9bKFkXOax2m5P2hfu65r7FX07\n" +
            "vKDJX4kw2H3P46uT+xnhQQKBgESsV8WFfSm6jJ2HM7rAuxwJ9k5dUJyuWnJY21bp\n" +
            "IAj1FCWT8uJt3MI5iLlNFE3bk31lCru++OfTQ2s/5LhbT2hqT0wGmlftH5jnAt0Q\n" +
            "KOHPI9H6mpC8dWSzTaLJ0BJRH3GO9Js8wkLJjb4BMbAlskOiBBcwphQ4TFi42crN\n" +
            "JC6pAoGAAe3I4OFaJOmQgDkf8NZ8n0bk8shSDNeWXtRudoTGHuf7brdyX3RxS7ui\n" +
            "jhUiwj0ENEBtHuxpxdP1rR95Ti5m80folqKuUKZmfwcQx8Eh16mQeg8x5OziDDaz\n" +
            "4egrrINBkb62RaS32VyT+becVqzGB0dJaLVDdYGwoqAYYNL+nZU=\n" +
            "-----END RSA PRIVATE KEY-----\n";

    private String publicVerifyKey1 = "-----BEGIN PUBLIC KEY-----\n" +
            "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5aP/2VEGL/ZneHWof9pr\n" +
            "ZTLbrS6WVAyLsADq4HE6JzhpdvqiJRNRFmMJZjWXgQAuT+IdhLQJZWZKBhCWKs6m\n" +
            "8nUWKVN3C2/gFKIud9NMsYZh5FGPftE0r1wKKBr4/FCKPvQ+azTENRLa9nL/OCfW\n" +
            "9Um2FnA3OZ2O1t83r8OEk2Ks9wjRYoH90pH8hqIjrJKvImlpSTCctzrhzr4UPuA9\n" +
            "takH9XJJR44eopbaTPD/JpmysnzSvj7Zo7RUmDbmyVW0PP67LBRF5uZikujsixKM\n" +
            "lHzJgatsD4mLEc5VvbR+GqZ4zc1nilYt4GgqM5pzP2v59IdqPzUpP7xFIb1arD/8\n" +
            "iwIDAQAB\n" +
            "-----END PUBLIC KEY-----";

    private String publicVerifyKey = "-----BEGIN PUBLIC KEY-----\n" +
            "MIICIjANBgkqhkiG9w0BAQEFAAOCAg8AMIICCgKCAgEAv1VEeQpMcs6shMp6GGWV\n" +
            "eIvDkOr7cH3ePIStPvRmK3yXazgek4mPQlsxH4dxUmnYT4sryc1gVdIfVkTPPkqW\n" +
            "Bph7n4mc/uQwfzYWzHOBxshexQEDez5rKEp33+qCYCZV229F5d+AofhLtmGXKqtu\n" +
            "FjM2+oNBz1pOAAPupZTH/0S4MReJSnGX90YH3wHhXzLH9ei9gO/XtZ0JtraZlU6n\n" +
            "sHK4vc4S4v90Ws7H+CsjAlUa66ZUdPBSgtWT2GL6CatauzvEBcoQMDBIxLHbVQeh\n" +
            "2FGueshOs0mMit1dQ45R2U24udCPV8vxRbk5Y6nsjDPYkCnxUVspYJa6Be4gEYyN\n" +
            "rv7aLfOp7soKMomUYR4PxB5gkwmsgDEC+B2Gm/wHgdxHYh43cn90of81aoq/5as/\n" +
            "iGQOAc5BoD9Pn+er63hL5yK7TmNsWyVHK5b3tp3c2uCoZKazDzGfOwbhIjvy5ldc\n" +
            "NOHBW62FvcqxRdTHRODjQxlwDDCNl5rx4WJwVFd8y/lcz1EE1WXSu2gsgHpXrgpv\n" +
            "lZ8AL6U4MtGv7QuA5Bj2uuoqvKy3qo+VsY7mjTkfII5Mb+WxHJOtMfoTWkl2m5A7\n" +
            "FTV4pOuJAgpqDSVcK79Koj8InKoyH5+6IGhEqxrLefvyC+H4Pm/q5ZVdqJL+eVXV\n" +
            "T9GdeoQ/IF+utQbWcgdUC9kCAwEAAQ==\n" +
            "-----END PUBLIC KEY-----\n";

    private String privateKeySigningKey = "-----BEGIN RSA PRIVATE KEY-----\n" +
            "MIIJKAIBAAKCAgEAv1VEeQpMcs6shMp6GGWVeIvDkOr7cH3ePIStPvRmK3yXazge\n" +
            "k4mPQlsxH4dxUmnYT4sryc1gVdIfVkTPPkqWBph7n4mc/uQwfzYWzHOBxshexQED\n" +
            "ez5rKEp33+qCYCZV229F5d+AofhLtmGXKqtuFjM2+oNBz1pOAAPupZTH/0S4MReJ\n" +
            "SnGX90YH3wHhXzLH9ei9gO/XtZ0JtraZlU6nsHK4vc4S4v90Ws7H+CsjAlUa66ZU\n" +
            "dPBSgtWT2GL6CatauzvEBcoQMDBIxLHbVQeh2FGueshOs0mMit1dQ45R2U24udCP\n" +
            "V8vxRbk5Y6nsjDPYkCnxUVspYJa6Be4gEYyNrv7aLfOp7soKMomUYR4PxB5gkwms\n" +
            "gDEC+B2Gm/wHgdxHYh43cn90of81aoq/5as/iGQOAc5BoD9Pn+er63hL5yK7TmNs\n" +
            "WyVHK5b3tp3c2uCoZKazDzGfOwbhIjvy5ldcNOHBW62FvcqxRdTHRODjQxlwDDCN\n" +
            "l5rx4WJwVFd8y/lcz1EE1WXSu2gsgHpXrgpvlZ8AL6U4MtGv7QuA5Bj2uuoqvKy3\n" +
            "qo+VsY7mjTkfII5Mb+WxHJOtMfoTWkl2m5A7FTV4pOuJAgpqDSVcK79Koj8InKoy\n" +
            "H5+6IGhEqxrLefvyC+H4Pm/q5ZVdqJL+eVXVT9GdeoQ/IF+utQbWcgdUC9kCAwEA\n" +
            "AQKCAgEAlknNzR2vywZYML4yhXNVoyh1ZyGMe2IC7Jpy0t56WnI1Jf0g11bX9pFW\n" +
            "1qM2+js1s9Vngc4We5LfFo5aE13W1jtz727SqMxo46OC6PlZ2OCOwEP5jhcLaMyF\n" +
            "uJal7gxuqDyRNO0IRzGXlxy09slNYZa8+q2bRdpzJkPwcpOZPQOngrgwGQ99BLg3\n" +
            "eo4pjvN+acR1BhBe6cL+XEy1+rebtFeIkV6LK07pAGMoY+DOUQi0aqFt+aTDyw0k\n" +
            "YnXsXSgBzsw1Py7m5FMo9YeW9wVVtWsDmGI6n02IXZNfrK7fz8bi8OHHlnkVfWTu\n" +
            "lUBmFAKtex/W88adi8cZO4s+GUrEBnEVG9paXs98J8x/ILUET7paVtGGybTsf16r\n" +
            "rLw966w0TF0wyHmhJRo8ZG8j4tzBb5oNshoDU/lZoGI8H4+gKmzADhWDtesM+EDK\n" +
            "jjFg7bStAEgF5UjTCOmcoX5yOYqKyIZoflFJoeOZrPtbNsXMHfUfjYAaRyeR+0WS\n" +
            "24tP4I6vjQuAuS9StHvOt4PyCIZWaHBBm52FzupkhVsZmve9q94TUVKvfZt5IMAs\n" +
            "iSRcTDS2dWmrkhpn/koKJlsBBRkMQrISXw4et6pxfR80WdD7mY92k7fHdpcu9Ajv\n" +
            "c558e9O1/1dPFl9qO3zHCJLJeVeNACjll8KH9Q4YazMwqm3zg+ECggEBAPiNmJwN\n" +
            "RY1VW8O9SQdP6HXGEY1xA4XG77DaIebW8d6CpzsRnwX2qDtXZoHNpsx4q2mrA8i5\n" +
            "j+jHKrGnZWvfnnkXNNtczVWssGDHcjkx0hkIL/GUcNeDPYsWPpoOhmZhxTdayfjD\n" +
            "v/wHoMt5Zqm3eZww6t/2SzYvTseuGOsfpuwmZEI3hxGxpABDp9mrswn3CNneT0X+\n" +
            "5t3AXZnWZ6+FEZi7cLxXuGj6oI62VMRot6ZQoi1Y0F9d8JcaW2HDIG1B65NiTmU9\n" +
            "97fcLzGKPeAnpwWSRzi/g3TAP178M2eIF55z164pFg1/v+RggKmt1t7JdAUY8hvN\n" +
            "phg2649M7OE8PD0CggEBAMUQyxfTwZDVtD88hv72qCKSKkyh/oZ2kEp78YE4R+6S\n" +
            "NiP/+Shslh6HC21ZeZ43Qtj2MTcQveRssyzdZafZtZ3SogXE7AkYyfmnN2Tmtv7u\n" +
            "leUJ3V3CB6pAp3vM4eRTSdXHsC6EVJHstSdXEUNmcyRSZwIUExr8JVcLtSQ9BRKL\n" +
            "B7ZDjO2yLLUqAXuEC4KmP3TeL0SXX6oy743Wk4UKe8vp7wsYe4KaP+3uWgJdv5Sc\n" +
            "6wzZ5SdrSis0CH9Kh8SHgEVlLJ6h0fj+ownxSzVKsWjxmTu5Nv51x7v0nDFCMvi4\n" +
            "lOknBbNEO+fbvZbumzMIrWQyBIDpba1lqK/Xlo+o+80CggEAVeqsPBUiW66L3+eI\n" +
            "XOy0UDG9U4UjUJTpudpNKbxXMzE6mWKH88nFcW3O00PBSqDTr90bm8D5C9/81Bgn\n" +
            "KNjNsNHixYkYuWrONUX8J+Ue2ORJnlpPf0+wcGmqDhrDPpTBVVcexcz0iiwg2vUG\n" +
            "FdiEQwdtySkb6okD1GZL2srAKpVCxtjm6ajcJfM9DDMb2m/4MUd1Y56vMywRruG8\n" +
            "SaHX6VGxsIkqB6/K3EoOly4TfXwV81LmBHE2fyTvPaXziZDl27Z5numCvZ1w+tDs\n" +
            "fpV2WKit0eHxkOP7g9vt8PXMJEuq3Fr7coMcU9c/4mdjBPPiFPkAh7fYmDozxv8y\n" +
            "StFFiQKCAQAk8jwRcIsG23oarP9mR9pH+P1jNq/gh9QPkuM5ZdLeoJzz7ObKtGkE\n" +
            "ui7jRnYtupCW2rlpaIMhk1uYWr3XVVLejwH/cOcL4ZDkdHxHN5Yxf4us0Eenb1w+\n" +
            "iDaeWFA1nYPnR7P5VKgCX82q3YEIEOofci+LzTWzxng9tJ02eRY9XsGIY2vFmLUX\n" +
            "FhQHEz+RNBgLkihshLDT2Q7emc84jzmchnRhsSpe1wqLUjef3/GuLClJVITI+i2C\n" +
            "ohPBwbhomTrsR8awywfx1dO9ZnbCPAm88ibXcqcj1/MlgvvRpGaoCPsqJz3DWVSd\n" +
            "6K3H4V5JmCPh+BquDJWaf8e7iADbWEQ1AoIBAHpEyYZqm5ZVx/Ud0b+LTFs3NPcu\n" +
            "zkHEO6TbdOFMv2GLaQI7s0LMsy+7WxMnURpG0NFgKCdnz9z9ADLwU4/O4+FWwrAG\n" +
            "5Qnmurrkio6iBO3ifYvuNLWqlRWgy/JUkFgKF9iNJ09oNOv5qjQyeCP+jNMpDMrk\n" +
            "0pzlqnqhdqDmJ4mlnM2hlRkPnDtYpfeQ4eeOZF8vztt0AMtqYHxayEVFt8uRExCE\n" +
            "oPxMr0YMsjA6uO5q7Rro2xyDV89r2CMAKcGPlVaj1of/uMHLKDUjCw0RrZ0NHn86\n" +
            "1N9C5d/NBImnM5VY+ndVpD3meZCuRUjMpFvXovHHY/ynXDQ1SgWxm0+liRg=\n" +
            "-----END RSA PRIVATE KEY-----\n";

}
