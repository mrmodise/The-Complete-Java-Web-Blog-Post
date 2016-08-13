package com.mrmodise.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		super.addViewControllers(registry);
		registry.addViewController("/login").setViewName("login/login");
		registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
		/*registry.addViewController("/").setViewName("index");
		registry.addViewController("/admin/").setViewName("admin/admin");
		registry.addViewController("/author").setViewName("author/staff-writer");
		registry.addViewController("/our-team").setViewName("teams/team");*/
	}

}
