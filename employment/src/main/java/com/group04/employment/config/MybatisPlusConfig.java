package com.group04.employment.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@MapperScan("com/group04/employment/mapper")
public class MybatisPlusConfig {
//    @Bean
//    public MybatisPlusInterceptor mybatisPlusInterceptor(){
//        //分页插件
//        MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
//        mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor());
//        return mybatisPlusInterceptor;
//    }
}
