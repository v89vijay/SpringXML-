package com.xml.web.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.xml.web.xmlmodel.Worker;

//@Service
public class CSVReaderWriter {
	public static Worker readCsv() {

		Worker worker = null;
		String fileName = "f:\\worker.csv";
		Path myPath = Paths.get(fileName);

		try {
			BufferedReader br = Files.newBufferedReader(myPath, StandardCharsets.UTF_8);

			HeaderColumnNameMappingStrategy<Worker> strategy = new HeaderColumnNameMappingStrategy<>();
			strategy.setType(Worker.class);

			CsvToBean csvToBean = new CsvToBeanBuilder(br).withType(Worker.class).withMappingStrategy(strategy)
					.withIgnoreLeadingWhiteSpace(true).build();

			List<Worker> workerList = csvToBean.parse();

			// workerList.stream().forEach(w->{
			worker = workerList.get(1);
			
			
			
			
//			System.out.println(worker);
			
			// });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return worker;
	}

	public static void writeCsv(Worker ww) {
		try {
			
			
			String header="Name,Position,Office,Age,Start Date,Salary";
			
			String file = "f:\\ss.csv";
			
			Path myPath2 = Paths.get(file);
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			
			
			
			BufferedWriter writer = new BufferedWriter(osw);
//					Files.newBufferedWriter(myPath2, StandardCharsets.UTF_8);
			
			StatefulBeanToCsv<Worker> beanToCsv = new StatefulBeanToCsvBuilder(writer)
					// .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
					.build();
			writer.write(header);
			writer.newLine();
			writer.write(ww.toString());
			writer.close();
			fos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		System.out.println("***********************");
		Worker worker = readCsv();
//		Tiger Nixon	System Architect	Edinburgh	61	24-04-2011	320800

		System.out.println(worker);
//		Worker worker = new Worker("Tiger Nixon", "System Architect", "Edinburgh", "61", "24-04-2011", "320800");
		
		System.out.println("\n\n\n\n\n\n\n***********************");
		writeCsv(worker);
	}
}
