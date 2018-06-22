/**
 * 
 */
package com.izumi.product.kawaiizumiwebapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Data;

/**
 * @author vle28
 *
 */
@Configuration
@EnableConfigurationProperties
@Data
@PropertySource(value = { "classpath:application.yml" })
public class ApplicationConfiguration {
	
	@Value("${kawaiizumi.session.chicken-management.title}")
	private String chickenManagementTitle;
}
