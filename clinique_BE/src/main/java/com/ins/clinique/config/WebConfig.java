package com.ins.clinique.config;

import org.hibernate.Interceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new Interceptor())
        //        .addPathPatterns("/*"); // Ajoute les chemins où l'interceptor doit être appliqué
    }
}

