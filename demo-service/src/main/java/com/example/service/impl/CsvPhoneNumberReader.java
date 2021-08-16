package com.example.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.PhoneNumber;
import com.example.service.PhoneNumberReader;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;

@Service("CsvPhoneNumberReader")
public class CsvPhoneNumberReader implements PhoneNumberReader {
	
	private final Integer SKIP_LINES = 2;
	private final Character separator = ';';

	@Override
	public List<PhoneNumber> readPhoneNumbers(File f) throws FileNotFoundException, IOException {
		
		List<PhoneNumber> result = new ArrayList<>();
		Reader reader = new FileReader(f);
		final CSVParser parser = new CSVParserBuilder().withSeparator(separator).build(); 
		final CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(SKIP_LINES).withCSVParser(parser).build();
		
		String[] nextRecord;
        while ((nextRecord = csvReader.readNext()) != null) {
        	Long id = Long.parseLong(nextRecord[0]);
        	String phoneNumber = nextRecord[1];
        	result.add(new PhoneNumber(id, phoneNumber));

        }
		return result;
	}
}
