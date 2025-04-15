package cn.howxu.server.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**@author HowXu
 *
 * 跨域请求的【配置
 *Spring 中的 @Configuration 注解详解
 * Configuration 是 Spring 框架中的一个核心注解，用于定义配置类，它是 Spring IoC 容器的核心组成部分之一。
 * 基本作用
 *     标识配置类：告诉 Spring 这个类是配置类，包含 Bean 的定义
 *     替代 XML 配置：可以用 Java 代码完全替代传统的 XML 配置方式
 *     Bean 定义中心：在类中通过 @Bean 注解的方法来定义 Spring 管理的对象
 */


@Configuration
public class Configure implements WebMvcConfigurer {
    // 实现这个接口表明这是一个前后端分离时的 web 配置

    @Override
    // 重写这个方法来添加跨域请求
    public void addCorsMappings(CorsRegistry registry) {
        // addMapping表示允许所有路由地址 allowedHeaders allowedMethods allowedOrigins设置跨域全允许
        registry.addMapping("/**")
                .allowedHeaders("*")
                .allowedMethods("*")
                .allowedOrigins("*");

    }
}
