package com.example.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Service;

import com.example.model.PhoneNumber;
import com.example.service.PhoneNumberReader;

@Service("XlsxPhoneNumberReader")
public class XlsxPhoneNumberReader implements PhoneNumberReader {

	@Override
	public List<PhoneNumber> readPhoneNumbers(File f) throws FileNotFoundException, IOException {
		// TODO 
		throw new NotImplementedException();
	}

}
