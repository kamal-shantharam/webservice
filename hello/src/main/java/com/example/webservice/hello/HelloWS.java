package com.example.webservice.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@WebService
@Features(features="org.apache.cxf.feature.LoggingFeature")
public class HelloWS {

	public HelloWS() {
	}
	
	@WebMethod
	public String hello() {
		return "Hello WS";
	}

}
