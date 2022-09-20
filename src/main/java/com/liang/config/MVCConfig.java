package com.liang.config;

import com.liang.interceptor.LoginInterceptor;
import com.liang.interceptor.RefreshTokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;

/**
 * @author Liang
 */
@Configuration
public class MVCConfig extends WebMvcConfigurationSupport {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    /***
     * addPathPatterns("/**"):拦截所有请求
     * excludePathPatterns： 不拦截的请求
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        //注册拦截器要声明拦截器对象和要拦截的请求
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/**/Tp/**",
                        "/**/Mail/**",
                        "/**/Talk/**",
                        "/**/nologin/**",
                        "/**/oss/**"
                )
                .excludePathPatterns("/swagger-resources/**","/error/**","/webjars/**", "/v2/**", "/swagger-ui.html/**").order(1);

        //token刷新拦截器
        registry.addInterceptor(new RefreshTokenInterceptor(stringRedisTemplate))
                .addPathPatterns("/**","/user/**")
                .excludePathPatterns("/swagger-resources/**","/error/**", "/webjars/**", "/v2/**"
                        , "/swagger-ui.html/**","/doc.html/**","/**/oss/**","/nologin/**")
                .order(0);
    }

    /***
     * 配置静态资源访问拦截
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowCredentials(true)
//                .allowedHeaders("*")
//                .allowedOrigins("*")
//                .allowedMethods("*")
//                .exposedHeaders("access-control-allow-headers",
//                        "access-control-allow-methods",
//                        "access-control-allow-origin",
//                        "access-control-max-age",
//                        "X-Frame-Options")
//                .allowCredentials(false).maxAge(3600);
//    }


}
