//package com.store.user.config;
//
//import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
//import com.github.pig.common.bean.interceptor.DataScopeInterceptor;
//import org.mybatis.spring.annotation.MapperScan;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author lengleng
// * @date 2017/10/29
// */
//@Configuration
//@MapperScan("com.github.pig.admin.mapper")
//public class MybatisPlusConfig {
//    /**
//     * 分页插件
//     *
//     * @return PaginationInterceptor
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        return new PaginationInterceptor();
//    }
//
//    /**
//     * 数据权限插件
//     *
//     * @return DataScopeInterceptor
//     */
//    @Bean
//    public DataScopeInterceptor dataScopeInterceptor() {
//        return new DataScopeInterceptor();
//    }
//}