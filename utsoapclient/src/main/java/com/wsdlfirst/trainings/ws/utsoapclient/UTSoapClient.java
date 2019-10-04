package com.wsdlfirst.trainings.ws.utsoapclient;

import java.util.HashMap;
import java.util.Map;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import com.javafirstws.ws.soap.PaymentProcessor;
import com.javafirstws.ws.soap.PaymentProcessorImplService;
import com.javafirstws.ws.soap.PaymentProcessorRequest;
import com.javafirstws.ws.soap.PaymentProcessorResponse;

public class UTSoapClient {

	public static void main(String[] args) {
		
		PaymentProcessorImplService service = new PaymentProcessorImplService();
		PaymentProcessor port = service.getPaymentProcessorImplPort();
		
		// Start of USER_NAME TOKEN security block
		Client client = ClientProxy.getClient(port);
		Endpoint endpoint = client.getEndpoint();

		Map<String, Object> props = new HashMap<>();
		props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
		props.put(WSHandlerConstants.USER, "cxf");
		props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
		props.put(WSHandlerConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
		
		WSS4JOutInterceptor wssout = new WSS4JOutInterceptor(props);
		endpoint.getOutInterceptors().add(wssout);
		// end
		
		PaymentProcessorResponse response = port.processPayment(new PaymentProcessorRequest());
		System.out.println(response.isResult());

	}

}
