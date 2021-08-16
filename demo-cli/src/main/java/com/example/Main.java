package com.example;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.PhoneNumber;
import com.example.service.PhoneNumberReader;
import com.example.service.PhoneNumberValidationService;

@SpringBootApplication
public class Main implements ApplicationRunner {

	private final String FILE_PATH = "filepath";
	Logger logger = LoggerFactory.getLogger(Main.class);

	@Autowired
	@Qualifier("CsvPhoneNumberReader")
	private PhoneNumberReader pnReader;
	
	@Autowired
	private PhoneNumberValidationService pnService;
	
	public static void main(String[] args) {
		
		SpringApplication.run(Main.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		if(! args.containsOption(FILE_PATH)) {
			System.err.println("ERROR : no file provided !");
			System.exit(1);
		}
		
		List<String> optionValues = args.getOptionValues(FILE_PATH);
		
		File f = new File(optionValues.get(0));
		if(! f.exists()) {
			System.err.println("ERROR : file not found");
			System.exit(1);
		}
		
		//new File("/Users/macchiavellis/Downloads/Pre-selezione. South_African_Mobile_Numbers.csv")
		
		logger.info(String.format("Validating numbers in file %s", f.getAbsolutePath()));
		List<PhoneNumber> n = pnReader.readPhoneNumbers(f);
		
		
		logger.info(String.format("Validating %d numbers", n.size()));
		pnService.deleteAll();
		pnService.validateAndSave(n);
		
		logger.info("End :-)");
	}
}
