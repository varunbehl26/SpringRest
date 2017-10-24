package com.varunbehl.spring.config;

import com.varunbehl.spring.controller.UserControlller;
import com.varunbehl.spring.service.OwnerDataServiceImpl;
import com.varunbehl.spring.service.UserDataServiceImpl;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // MDC.put("environment", System.getenv("APP_ENV") != null ?
        // System.getenv("APP_ENV") : "dev");
        return new Class<?>[]{AppConfig.class, DataConfig.class, UserControlller.class,
                OwnerDataServiceImpl.class, UserDataServiceImpl.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

}
