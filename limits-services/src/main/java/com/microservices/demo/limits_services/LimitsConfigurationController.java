/**
 * 
 */
package com.microservices.demo.limits_services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.limits_services.bean.LimitConfiguration;

/**
 * @author ashishcommuri
 *
 */
@RestController
@RefreshScope
public class LimitsConfigurationController {
	
	@Autowired
	Configuration configuration;

	@GetMapping("/limits")
	public LimitConfiguration retriveLimitsFromConfiguartions()
	{
		return new LimitConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}
