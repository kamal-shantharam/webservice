package com.trainings.restasync;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.ws.rs.BadRequestException;
import javax.ws.rs.client.AsyncInvoker;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class AsyncClient {

	public static void main(String[] args) {

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/services/checkservice/check");
		AsyncInvoker async = target.request().async();

		Future<Boolean> response = async.post(Entity.entity(new CheckList(), MediaType.APPLICATION_XML), Boolean.class);

		try {
			System.out.println(response.get());
		} catch (InterruptedException | ExecutionException e) {

			if (e.getCause() instanceof BadRequestException) {
				System.out.println("Invalid check object passed!!!");
			}
		}
	}

}
