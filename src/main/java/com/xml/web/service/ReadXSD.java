package com.xml.web.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Service;

@Service
public class ReadXSD {

	public String readXSD() {
		ClassLoader classLoader = getClass().getClassLoader();
		
		String str="";
        	try {
				URL resource = classLoader.getResource("file");
				File file = new File(resource.getFile());
				FileInputStream fis = new FileInputStream(file);
				
				byte arr[] = new byte[(int)file.length()];
				fis.read(arr);
				
				str = new String(arr);
				System.out.println(str);
				
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	return str;
	}
	
	
	
}
