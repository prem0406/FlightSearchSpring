package com.nagarro.flightsearch.importer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
public class CSVImporter implements FileImporter {
	private String filePath;
	private String delimiter;
	public CSVImporter(String filePath, String delimiter) {
		this.filePath = filePath;
		this.delimiter = delimiter;
	}

	@Override
	public List<String[]> extractFields() {
		List<String[]> resultList = new ArrayList<String[]>();;
		


				try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
					String line = "";
					br.readLine();

					while ((line = br.readLine()) != null) {

						String[] data = line.split("\\|");
						resultList.add(data);
					}
				} catch (Exception e) {
					System.out.println("Exception :" + e);
				}
		
		return resultList;
	}

}
