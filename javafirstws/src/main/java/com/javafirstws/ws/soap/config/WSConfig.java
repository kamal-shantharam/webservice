package com.javafirstws.ws.soap.config;

import java.util.HashMap;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.security.wss4j.WSS4JInInterceptor;
import org.apache.wss4j.common.ConfigurationConstants;
import org.apache.wss4j.dom.WSConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.javafirstws.ws.soap.PaymentProcessorImpl;

@Configuration
public class WSConfig {
	
	@Autowired
	Bus bus;
	
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, new PaymentProcessorImpl());
		endpoint.publish("/javafirstws");
		
		HashMap<String, Object> props = new HashMap<>();
		props.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
		props.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		WSS4JInInterceptor wssIn = new WSS4JInInterceptor(props);
		endpoint.getInInterceptors().add(wssIn);
		
		return endpoint;
	}

}
