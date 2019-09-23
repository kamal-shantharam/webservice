package com.example.webservice;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.feature.Features;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class WSConfig {
	
	@Autowired
	Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerWSImpl());
		endpoint.publish("/order");
		return endpoint;
	}

}
