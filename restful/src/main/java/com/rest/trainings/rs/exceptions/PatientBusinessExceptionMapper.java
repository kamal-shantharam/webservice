package com.rest.trainings.rs.exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import ch.qos.logback.core.net.SocketConnector;
import ch.qos.logback.core.net.SocketConnector.ExceptionHandler;

@Provider
public class PatientBusinessExceptionMapper implements ExceptionMapper<PatientBusinessException>, ExceptionHandler {

	@Override
	public void connectionFailed(SocketConnector connector, Exception ex) {

	}

	@Override
	public Response toResponse(PatientBusinessException exception) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"status\": \"Not Found\"");
		sb.append(",");
		sb.append("\"exception\": \"Try again\"");
		sb.append("}");
		//return Response.status(404).build();
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_JSON).build();
	}

}
