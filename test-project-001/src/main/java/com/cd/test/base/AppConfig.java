package com.cd.test.base;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@ComponentScan(basePackages = "com.cd.test")
public class AppConfig implements WebMvcConfigurer {


    /***
     * 通过注解 @Bean 初始化视图解析器
     * @return ViewResolver 视图解析器
     */
    @Bean(name="internalResourceViewResolver")
    public ViewResolver initViewResolver() {
        InternalResourceViewResolver viewResolver =new InternalResourceViewResolver();
        viewResolver.setPrefix("/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * 初始化RequestMappingHandlerAdapter，并加载Http的Json转换器
     * @return  RequestMappingHandlerAdapter 对象
     */
    @Bean(name="requestMappingHandlerAdapter")
    public HandlerAdapter initRequestMappingHandlerAdapter() {
        //创建RequestMappingHandlerAdapter适配器
        RequestMappingHandlerAdapter rmhd = new RequestMappingHandlerAdapter();
        // HTTP JSON转换器
        MappingJackson2HttpMessageConverter jsonConverter
                = new MappingJackson2HttpMessageConverter();
        //MappingJackson2HttpMessageConverter接收JSON类型消息的转换
        MediaType mediaType = MediaType.APPLICATION_JSON_UTF8;
        List<MediaType> mediaTypes = new ArrayList<MediaType>();
        mediaTypes.add(mediaType);
        //加入转换器的支持类型
        jsonConverter.setSupportedMediaTypes(mediaTypes);
        //往适配器加入json转换器
        rmhd.getMessageConverters().add(jsonConverter);
        return rmhd;
    }

    /**
     * override WebMvcConfigurer.addRResourceHandlers to filter resources file
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/")
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    }
}
    