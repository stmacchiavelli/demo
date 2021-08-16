package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;
import com.example.service.PhoneNumberValidationService;

@RestController
public class DemoController {

	Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private PhoneNumberValidationService pnService;

	@GetMapping("/numbers")
	public ResponseEntity<List<PhoneNumberValidation>> getAllNumbers() {
		List<PhoneNumberValidation> list = pnService.getAll();		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/numbers/status/{status}")
	public ResponseEntity<List<PhoneNumberValidation>> getNumbersByStatus(@PathVariable Integer status) {
		List<PhoneNumberValidation> list = pnService.findByStatus(status);		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleError(HttpServletRequest req, Exception ex) {
		logger.error("Request: " + req.getRequestURL() + " raised " + ex);

		Map<String, String> result = new HashMap<>();
		result.put("error", ex.getMessage());
		result.put("url", req.getRequestURL().toString());
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
