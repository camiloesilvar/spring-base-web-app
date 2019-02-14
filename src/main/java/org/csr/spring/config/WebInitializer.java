package org.csr.spring.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.csr.spring.config.web.WebMvcConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebInitializer implements WebApplicationInitializer {

	private Logger logger = LogManager.getLogger("SPRING_BASE_WEB_APP_LOGGER");

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		logger.debug(String.format("onStartup: inicio %s", container.getInitParameterNames()));
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(WebMvcConfig.class);
		ctx.scan("org.csr.spring.config.data");

		container.addListener(new ContextLoaderListener(ctx));

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");

		logger.debug(String.format("onStartup: fin %d", container.getSessionTimeout()));
	}
}
