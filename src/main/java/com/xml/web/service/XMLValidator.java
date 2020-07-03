package com.xml.web.service;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.SAXException;

import com.xml.web.exception.XMLException;

@Service
public class XMLValidator {

	@Autowired
	XMLException xmlException;
	
	public boolean validateXMLSchema(String xsdPath, String xmlPath) {
		try {
			SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = factory.newSchema(new File(xsdPath));
			Validator validator = schema.newValidator();
			validator.validate(new StreamSource(new File(xmlPath)));
		} catch (IOException e) {
			System.out.println("Exception: " + e.getMessage());
			return false;
		} catch (SAXException e1) {
			System.out.println("SAX Exception: " + e1.getMessage());
			xmlException.setExcpMessage(e1.getMessage());
			throw xmlException;
			// if (e1.getMessage().contains("ageRestrict")) {
			// System.out.println("Please specify valid age");
			// }
			// return false;
		}
		return true;
	}
	
	public boolean validateVijay(int age)
	{
		if(age<18) {
			xmlException.setExcpMessage("age exception");
			
			System.out.println("======"+xmlException);
			
			throw xmlException;
		}
		return true;
	}
	
	
}
