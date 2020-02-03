package com.trainings.restws;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;

@Path("/fileService")
public interface FileService {
	
	@POST
	@Path("/upload")
	void upload(List<Attachment> attachments) throws FileNotFoundException, IOException;

	@GET
	@Path("/download")
	Response download();
}
