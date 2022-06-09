package com.timwang5.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.LocaleResolver;

import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





//加了@EnableWebMvc之后 导入一个类DelegatingWebMvcConfiguration 从容器中获取所有webmvcconfig
//加了之后这个MyMvcConfig 自动配置不生效了
//https://blog.csdn.net/zxc123e/article/details/84636521 解释了springmvc配置后resource资源访问不到的问题

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    //自己添加视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/").setViewName("index");
    }


    //自定义的国际化组件生效
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
