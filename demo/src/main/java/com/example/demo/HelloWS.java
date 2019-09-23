package com.example.demo;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.apache.cxf.feature.Features;

@Features(features="org.apache.cxf.feature.LoggingFeature")
@WebService
public class HelloWS {

	@WebMethod
	public String hello() {
		return "Hello WS";
	}
}
