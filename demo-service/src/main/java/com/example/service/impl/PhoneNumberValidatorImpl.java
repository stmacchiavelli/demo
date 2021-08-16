package com.example.service.impl;

import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;
import com.example.service.PhoneNumberValidator;

@Service
public class PhoneNumberValidatorImpl implements PhoneNumberValidator {

	private final String REGEXP = "^[0-9]{11}$";
	private final String REGEXP_NO_PREFIX = "^[0-9]{9}$";
	private final String SA_PREFIX = "27";

	@Override
	public PhoneNumberValidation validate(PhoneNumber pn) {
		
		String number = (pn != null) ? pn.getPhoneNumber() : ""; 
		
		if(isValid(number)) {
			return validNumber(pn);
		}
		
		PhoneNumberValidation result = new PhoneNumberValidation();
		result.setId(pn.getId());
		result.setOriginalPhoneNumber(number);
		
		if (Pattern.matches(REGEXP_NO_PREFIX, number)) {
			String newNum = SA_PREFIX + number;
			if(isValid(newNum)) {
				result.setValidatedPhoneNumber(newNum);
				result.setNote("Prefix Added");
				result.setStatus(PhoneNumberValidation.STATUS_CHANGED);
				return result;
			}
		}
		
		result.setStatus(PhoneNumberValidation.STATUS_KO);
		result.setNote("Invalid number");
		return result;
	}
	
	private PhoneNumberValidation validNumber(PhoneNumber pn) {
		PhoneNumberValidation result = new PhoneNumberValidation();
		result.setId(pn.getId());
		result.setOriginalPhoneNumber(pn.getPhoneNumber());
		result.setStatus(PhoneNumberValidation.STATUS_OK);
		return result;
	}
	
	private boolean isValid(String  phNumber) {
		
		if(StringUtils.isEmpty(phNumber)) {
			return false;
		}
		
		boolean allNums = Pattern.matches(REGEXP, phNumber);
		boolean prefixOk = phNumber.startsWith(SA_PREFIX);
		
		return prefixOk && allNums;
	}
}
