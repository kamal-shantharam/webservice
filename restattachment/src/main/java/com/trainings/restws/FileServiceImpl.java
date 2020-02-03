package com.trainings.restws;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.springframework.stereotype.Service;

@Service
public class FileServiceImpl implements FileService {

	private static final String FILE_PATH = "/Users/kamalshantharam/Downloads/photo.jpg";

	private void copyFile(InputStream inputStream) throws FileNotFoundException, IOException {
		OutputStream out = null;
		int read = 0;
		byte[] bytes = new byte[1024];

		out = new FileOutputStream(new File(FILE_PATH));
		while ((read = inputStream.read(bytes)) != -1) {
			out.write(bytes, 0, read);
		}
		out.flush();
		out.close();	
	}

	@Override
	public void upload(List<Attachment> attachments) throws FileNotFoundException, IOException {
		for (Attachment attachment : attachments) {
			copyFile(attachment.getDataHandler().getInputStream());
		}
		
	}

	@Override
	public Response download() {
		File file = new File(FILE_PATH);
		ResponseBuilder responseBuilder = Response.ok(file);
		responseBuilder.header("Content-Disposition", "attachment;filename=download.jpg");
		return responseBuilder.build();
	}

}