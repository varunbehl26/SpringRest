package com.varunbehl.spring.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.varunbehl.spring.service.MyDataService;
import com.varunbehl.spring.service.MyDataServiceImpl;
import com.varunbehl.spring.service.UserDataServiceImpl;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// MDC.put("environment", System.getenv("APP_ENV") != null ?
		// System.getenv("APP_ENV") : "dev");
		return new Class<?>[] { AppConfig.class, DataConfig.class, MyDataService.class,
				MyDataServiceImpl.class, UserDataServiceImpl.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

}
