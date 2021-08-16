package com.example.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.example.model.PhoneNumber;

public interface PhoneNumberReader {
	List<PhoneNumber> readPhoneNumbers(File f) throws FileNotFoundException, IOException;
}
