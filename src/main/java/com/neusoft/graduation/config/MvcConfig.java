package com.neusoft.graduation.config;

import com.neusoft.graduation.component.LocaleResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName MyMvcConfig
 * @Description TODO
 * @Author Alice丶Nakiri
 * @Date 2019/9/5 21:35
 * Version 1.0
 **/
//使用WebMvcConfigurer来扩展SpringMVC功能
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    ServerProperties serverProperties;

    //改变端口
//    @Bean
//    public WebServerFactoryCustomizer webServerFactoryCustomizer() {
//        return new WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>() {
//            @Override
//            public void customize(ConfigurableServletWebServerFactory factory) {
//                factory.setPort(8083);
//            }
//        };
//
//    }

    //映射地址路径
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index.html").setViewName("login");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
//                excludePathPatterns("/index.html", "/", "/user/login","/asserts/**");
    }

    //将配置类加载入容器
    @Bean
    //加载国际化配置
    public org.springframework.web.servlet.LocaleResolver localeResolver() {
        return new LocaleResolver();
    }

}
