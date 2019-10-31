package com.rest.trainings.rs.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.rest.trainings.rs.model.Patient;

@Service
public class PatientServiceImpl implements PatientService {
	
	Map<Long, Patient> patients = new HashMap<>();
	Long initialId = 1L;
	public PatientServiceImpl() {
		init();
	}
	
	void init() {
		Patient patient = new Patient();
		patient.setId(initialId);
		patient.setName("Raj");
		patients.put(patient.getId(), patient);
		Patient patient2 = new Patient();
		patient2.setId(++initialId);
		patient2.setName("Krishna");
		patients.put(patient2.getId(), patient2);
	}

	@Override
	public List<Patient> getPatients() {
		Collection<Patient> values = patients.values();
		return new ArrayList<>(values);
	}

	@Override
	public Patient getPatient(Long patientId) {
		Patient patient = patients.get(patientId);
		return patient;
	}

	@Override
	public Response createPatient(Patient patient) {
		patient.setId(++initialId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response updatePatient(Patient patient) {
		Patient patient2 = patients.get(patient.getId());
		Response response;
		if (patient2 != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok(patient).build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response deletePatient(Long patientId) {
		Patient patient = patients.get(patientId);
		Response response;
		if (patient != null) {
			patients.remove(patientId);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
