package com.example.demo.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.HelloWS;

@Configuration
public class WSConfiguration {
	
	@Autowired
	Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		Endpoint ep = new EndpointImpl(bus, new HelloWS());
		ep.publish("/hello");
		return ep;
	}

}
