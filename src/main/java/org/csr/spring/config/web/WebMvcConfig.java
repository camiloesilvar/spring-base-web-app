package org.csr.spring.config.web;

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

	/**
	 * Configure TilesConfigurer.
	 */
	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer tilesConfigurer = new TilesConfigurer();
		tilesConfigurer.setDefinitions(new String[] { "/WEB-INF/views/**/tiles.xml" });
		tilesConfigurer.setCheckRefresh(true);
		return tilesConfigurer;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("/static/");
		registry.addResourceHandler("/css/**").addResourceLocations("/static/css/").setCachePeriod(0);
		registry.addResourceHandler("/js/**").addResourceLocations("/static/js/").setCachePeriod(0);
		registry.addResourceHandler("/img/**").addResourceLocations("/static/img/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("forward:/inicio.html");
	}

	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.tiles();
		registry.jsp().prefix("/WEB-INF/views/").suffix(".jsp");

//		TilesViewResolver viewResolver = new TilesViewResolver();
//		registry.viewResolver(viewResolver);
	}
//	@Override
//	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
//		configurer.enable();
//	}
//
//	@Bean
//	public ContentNegotiatingViewResolver viewResolver(ContentNegotiationManager cnManager) {
//		ContentNegotiatingViewResolver cnvResolver = new ContentNegotiatingViewResolver();
//		cnvResolver.setContentNegotiationManager(cnManager);
//		List<ViewResolver> resolvers = new ArrayList<>();
//
//		InternalResourceViewResolver bean = new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
//
//		resolvers.add(bean);
//
//		cnvResolver.setViewResolvers(resolvers);
//		return cnvResolver;
//	}
}
