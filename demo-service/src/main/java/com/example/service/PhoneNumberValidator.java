package com.example.service;

import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;

public interface PhoneNumberValidator {
	
	
	//void validate(PhoneNumber pn);
	
	PhoneNumberValidation validate(PhoneNumber pn);
}
