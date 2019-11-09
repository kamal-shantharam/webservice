package com.rest.trainings.rs.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import com.rest.trainings.rs.model.Patient;

@Consumes("application/xml,application/json")
@Produces("application/xml,application/json")
//@Consumes(MediaType.APPLICATION_JSON)
//@Produces(MediaType.APPLICATION_JSON)
@Path("/patientservice")
public interface PatientService {
	
	@Path("/patients")
	@GET
	public List<Patient> getPatients();
	
	@Path("/patients/{id}")
	@GET
	public Patient getPatient(@PathParam("id") Long patientId);
	
	@Path("/patients")
	@POST
	public Response createPatient(Patient patient);
	
	@Path("/patients")
	@PUT
	public Response updatePatient(Patient patient);
	
	@Path("/patients/{id}")
	@DELETE
	public Response deletePatient(@PathParam("id") Long patientId);
}
