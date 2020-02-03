package com.trainings.restws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {

		WebClient webClient = WebClient.create("http://localhost:8080/services/fileService/upload");
		webClient.type("multipart/form-data");
		ContentDisposition ct = new ContentDisposition("attachment;filename=01.jpg");

		Attachment attachment = new Attachment("root",
				new FileInputStream(new File("/Users/kamalshantharam/Downloads/01.jpg")), ct);
		webClient.post(attachment);
	}

}
