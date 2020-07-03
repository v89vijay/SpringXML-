package com.xml.web.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;

import org.springframework.stereotype.Component;

@Component
public class FileConfig {
	public FileConfig() {
		try {
			File f = new File("Upload/xsd/sampleviju.txt");
			FileInputStream fis = new FileInputStream(f);

			byte arr[] = new byte[(int) f.length()];
			fis.read(arr);

			String str = new String(arr);
			System.out.println("=========" + str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("file created");
	}
}
