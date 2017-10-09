/**
 * 
 */
package com.izumi.product.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author vle28
 *
 */
public class WebConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/*.js/**").addResourceLocations("/ui/static/");
		registry.addResourceHandler("/*.css/**").addResourceLocations("/ui/static/");
	}
}
