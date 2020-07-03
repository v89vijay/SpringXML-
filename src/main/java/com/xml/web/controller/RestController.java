package com.xml.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import com.xml.web.service.ReadXSD;
import com.xml.web.service.XMLValidator;
import com.xml.web.utilityservice.XMLConvertor;
import com.xml.web.utilty.Response;
import com.xml.web.xmlmodel.Company;
import com.xml.web.xmlmodel.Employee;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	XMLValidator xmlValidator;

	@Autowired
	XMLConvertor xmlConvertor;

	@Autowired
	ReadXSD readXSD;

	@GetMapping("/storexml")
	public ResponseEntity<String> getXML() {

		String fileName = "sdd.xml";
		List<Employee> elist = new ArrayList<Employee>();

		Employee e1 = new Employee("1", "manu", "8855022031", "15000");

		Employee e2 = new Employee("2", "swapnil", "8888783648", "20000");

		Employee e3 = new Employee("3", "munni", "8855022012", "18000");

		elist.add(e1);
		elist.add(e2);
		elist.add(e3);

		Company company = new Company("infosys", "pune", elist);

		xmlConvertor.convetJavaToXML(company, fileName);
		xmlConvertor.convetXMLToJava("sdd.xml");
		return new ResponseEntity<String>("book stored successfully ", HttpStatus.OK);
	}

	@GetMapping("/validate")
	public ResponseEntity<Response> validateXML() {

		String xsdPath = "f:\\Student.xsd";
		String xmlPath = "f:\\Student.xml";

		xmlValidator.validateXMLSchema(xsdPath, xmlPath);
		Response response = new Response();
		response.setResponseMsg("good class");

		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@GetMapping("/read")
	public ResponseEntity<Response> readXSD() {

		readXSD.readXSD();
		
		Response resp = new Response();
		resp.setResponseMsg("good");
		return new ResponseEntity<Response>(resp, HttpStatus.OK);
	}
}
