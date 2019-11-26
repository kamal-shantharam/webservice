package com.rest.trainings.restclient;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PatientWSClient {
	
	private final static String PATH = "http://localhost:8080/services/patientservice";
	private final static String PATH2 = "http://localhost:8080/services/patientservice/patients/1";

	public static void main(String[] args) {
		
		Client client = ClientBuilder.newClient();
		
		//WebTarget target = client.target(PATH).path("/patients").path("/{id}").resolveTemplate("id", 123);
		
		WebTarget target = client.target(PATH2);
				
		Builder request = target.request();
		
		//Response response = request.get();
		
		//System.out.println(response.getStatus());
		
		Patient patient = request.get(Patient.class);
		
		System.out.println(patient.toString());
		
		patient.setName("Updated Patient Name");
		
		WebTarget updateTarget = client.target(PATH + "/patients");
		
		Response updateResponse = updateTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		
		updateResponse.close();
		
		System.out.print(updateResponse.getStatus());
		
		Patient newPatient = new Patient();
		newPatient.setName("Kamal");
		
		Patient createdPatient = updateTarget.request().post(Entity.entity(newPatient, MediaType.APPLICATION_XML), Patient.class);
		
		System.out.println("Created patient id -> " + createdPatient.getId());
		
		Response deleteResponse = target.request().delete();
		
		System.out.print(deleteResponse.getStatus());
		
		client.close();
		
	}

}
