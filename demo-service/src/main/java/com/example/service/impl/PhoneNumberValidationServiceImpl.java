package com.example.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;
import com.example.repository.PhoneNumberValidationRepository;
import com.example.repository.entity.PhoneNumberValidationEntity;
import com.example.service.PhoneNumberValidationService;
import com.example.service.PhoneNumberValidator;

@Service
public class PhoneNumberValidationServiceImpl implements PhoneNumberValidationService {
	
	@Autowired
	private PhoneNumberValidationRepository repo;
	
	@Autowired
	private PhoneNumberValidator validator;
	
	@Override
	public List<PhoneNumberValidation> findByStatus(Integer status) {
		return toPhoneNumberValidationList(repo.findByStatus(status));
	}
	
	@Override
	public List<PhoneNumberValidation> getAll() {
		return toPhoneNumberValidationList(repo.findAll());
	}
	
	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
	
	@Override
	public void validateAndSave(List<PhoneNumber> numbers) {
		repo.deleteAll();
		for(PhoneNumber pn : numbers) {
			PhoneNumberValidation e = validator.validate(pn);
			repo.save(totoPhoneNumberValidationListEntity(e));
		}
	}
	
	private PhoneNumberValidationEntity totoPhoneNumberValidationListEntity(PhoneNumberValidation pn) {
		PhoneNumberValidationEntity e = new PhoneNumberValidationEntity();
		e.setId(pn.getId());
		e.setOriginalPhoneNumber(pn.getOriginalPhoneNumber());
		e.setValidatedPhoneNumber(pn.getValidatedPhoneNumber());
		e.setNote(pn.getNote());
		e.setStatus(pn.getStatus());
		return e;
	}
	
	private List<PhoneNumberValidation> toPhoneNumberValidationList(List<PhoneNumberValidationEntity> all) {
		List<PhoneNumberValidation> result = new ArrayList<>();
		for(PhoneNumberValidationEntity e : all) {
			result.add(toPhoneNumber(e));
		}
		return result;
	}
	
	private PhoneNumberValidation toPhoneNumber(PhoneNumberValidationEntity e) {
		PhoneNumberValidation n = new PhoneNumberValidation();
		n.setId(e.getId());
		n.setOriginalPhoneNumber(e.getOriginalPhoneNumber());
		n.setValidatedPhoneNumber(e.getValidatedPhoneNumber());
		n.setNote(e.getNote());
		n.setStatus(e.getStatus());
		return n;
	}
}
