package com.example.xjc.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.example.patient.Patient;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		try {
			JAXBContext context = JAXBContext.newInstance(Patient.class);
			Marshaller marshal = context.createMarshaller();
			Patient patient1 = new Patient();
			patient1.setAge(30);
			patient1.setName("Raman");
			StringWriter stringWriter = new StringWriter();
			marshal.marshal(patient1, stringWriter);
			System.out.println(stringWriter.toString());

			Unmarshaller unmarshal = context.createUnmarshaller();
			Patient patient2 = (Patient) unmarshal.unmarshal(new StringReader(stringWriter.toString()));
			System.out.println(patient2.getName() + "-" + patient2.getAge());

		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
}
