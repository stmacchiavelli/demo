package com.example.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PhoneNumber {

	private Long id;
	private String phoneNumber;
	
	public PhoneNumber(Long id, String phoneNumber) {
		super();
		this.id = id;
		this.phoneNumber = phoneNumber;
	}
}
