package com.example.service;

import java.util.List;

import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;

public interface PhoneNumberValidationService {
	void validateAndSave(List<PhoneNumber> numbers);
	List<PhoneNumberValidation> findByStatus(Integer status);
	List<PhoneNumberValidation> getAll();
	void deleteAll();
}
