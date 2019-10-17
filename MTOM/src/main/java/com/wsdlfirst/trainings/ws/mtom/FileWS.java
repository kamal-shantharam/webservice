package com.wsdlfirst.trainings.ws.mtom;

import javax.activation.DataHandler;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService
public interface FileWS {

	void upload(@WebParam(name = "file") DataHandler dataHandler);
	
	DataHandler download();
}
