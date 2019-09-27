package com.wsdlfirst.trainings.ws.soapclient;

import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.example.webservice.CustomerWSImplService;
import com.wsdlfirst.ws.trainings.CustomerOrdersPortType;
import com.wsdlfirst.ws.trainings.GetOrdersRequest;
import com.wsdlfirst.ws.trainings.GetOrdersResponse;
import com.wsdlfirst.ws.trainings.Order;

public class SoapClientApp {

	public static void main(String[] args) throws MalformedURLException {
		CustomerWSImplService service = new CustomerWSImplService(new URL("http://localhost:8080/customerservice/order?wsdl"));
		CustomerOrdersPortType customerWSImplPort = service.getCustomerWSImplPort();
		GetOrdersRequest request = new GetOrdersRequest();
		request.setCustomerId(BigInteger.valueOf(1));
		GetOrdersResponse response = customerWSImplPort.getOrders(request);
		List<Order> order = response.getOrder();
		System.out.println("Order size is " + order.size());

	}

}
