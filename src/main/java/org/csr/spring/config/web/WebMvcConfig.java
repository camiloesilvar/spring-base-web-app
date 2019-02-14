package org.csr.spring.config.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = { "org.csr.spring.front.controller" })
public class WebMvcConfig implements WebMvcConfigurer {

	private Logger logger = LogManager.getLogger("SPRING_BASE_WEB_APP_LOGGER");

	/**
	 * Configure TilesConfigurer.
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		logger.debug("tilesConfigurer...");
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		logger.debug("addResourceHandlers...");
		registry.addResourceHandler("/**").addResourceLocations("/static/");
		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(0);
		registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(0);
		registry.addResourceHandler("/img/**").addResourceLocations("/static/img/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		logger.debug("addViewControllers...");
		registry.addViewController("/").setViewName("forward:/inicio.html");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		logger.debug("configureViewResolvers...");
		registry.tiles();
		registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");

//		TilesViewResolver viewResolver = new TilesViewResolver();
//		registry.viewResolver(viewResolver);
	}
}
