package com.wsdlfirst.trainings.ws.mtom;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;

public class FileWSImpl implements FileWS {

	@Override
	public void upload(DataHandler dataHandler) {
		
		InputStream inputStream = null;
		OutputStream outputStream = null;
		try {
			inputStream = dataHandler.getInputStream();
			outputStream = new FileOutputStream(new File(
					"/Users/kamalshantharam/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/MTOM/src/main/resources/Chandhini.JPG"), false);
			byte[] bytes = new byte[100000];
			int bytesRead = 0;
			while((bytesRead = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes);
			}
		} catch (IOException e) { 
			e.printStackTrace();
		} finally {
			try {
				outputStream.close();
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public DataHandler download() {
		return new DataHandler(new FileDataSource(new File("/Users/kamalshantharam/Documents/workspace-spring-tool-suite-4-4.4.0.RELEASE/MTOM/src/main/resources/Chandhini.JPG")));
	}

}
