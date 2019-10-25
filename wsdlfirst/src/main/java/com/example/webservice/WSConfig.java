package com.example.webservice;

import java.util.ArrayList;

import javax.xml.ws.Binding;
import javax.xml.ws.Endpoint;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.soap.SOAPBinding;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WSConfig {

	@Autowired
	Bus bus;

	@Bean
	public Endpoint endpoint() {
		Endpoint endpoint = new EndpointImpl(bus, new CustomerWSImpl());
		endpoint.publish("/order");
		SOAPBinding binding = (SOAPBinding) endpoint.getBinding();

		ArrayList<Handler> chain = new ArrayList<>();
		chain.add(new SOAPMessageHandler());
		
		binding.setHandlerChain(chain);

		return endpoint;
	}

}
