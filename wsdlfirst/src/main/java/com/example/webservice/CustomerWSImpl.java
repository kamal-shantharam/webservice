package com.example.webservice;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.wsdlfirst.ws.trainings.CreateOrdersRequest;
import com.wsdlfirst.ws.trainings.CreateOrdersResponse;
import com.wsdlfirst.ws.trainings.CustomerOrdersPortType;
import com.wsdlfirst.ws.trainings.GetOrdersRequest;
import com.wsdlfirst.ws.trainings.GetOrdersResponse;
import com.wsdlfirst.ws.trainings.Order;
import com.wsdlfirst.ws.trainings.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerWSImpl implements CustomerOrdersPortType {

	Map<BigInteger, List<Order>> customersOrder = new HashMap<>();
	int currentId;
	
	
	public CustomerWSImpl() {
		super();
		init();
	}

	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		List<Order> orders = customersOrder.get(customerId);
		
		GetOrdersResponse response = new GetOrdersResponse();
		response.getOrder().addAll(orders);
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId = request.getCustomerId();
		
		Order order = request.getOrder();
		
		List<Order> orders = customersOrder.get(customerId);
		orders.add(order);
		
		CreateOrdersResponse response = new CreateOrdersResponse();
		response.setResult(true);
		
		return response;
	}
	
	public void init() {
		List<Order> orders = new ArrayList<>();
		Order order = new Order();
		order.setId(BigInteger.valueOf(1));
		
		Product product = new Product();
		product.setId("1");
		product.setDescription("iPhone");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		
		orders.add(order);
		customersOrder.put(order.getId(), orders);
	}

}
