package com.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PhoneNumberValidation {
	
	public final static Integer STATUS_OK = 1;
	public final static Integer STATUS_KO = 0;
	public final static Integer STATUS_CHANGED = 2;
	
	private Long id;
	private String validatedPhoneNumber;
	private String originalPhoneNumber;
	private String note;
	private Integer status;
}
