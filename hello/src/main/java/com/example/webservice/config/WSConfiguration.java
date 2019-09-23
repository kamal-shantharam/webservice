package com.example.webservice.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.webservice.hello.HelloWS;

@Configuration
public class WSConfiguration {

	@Autowired
	Bus bus;
	
	public WSConfiguration() {
	}
	
	@Bean
	public Endpoint endpoint() {
		Endpoint endPoint = new EndpointImpl(bus, new HelloWS());
		endPoint.publish("/hello");
		return endPoint;
		
	}

}
