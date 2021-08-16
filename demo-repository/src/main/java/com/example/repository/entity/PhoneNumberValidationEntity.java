package com.example.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PHONE_NUMBER_VALIDATION")
public class PhoneNumberValidationEntity {

	@Id
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ORIGINAL_PHONE_NUMBER")
	private String originalPhoneNumber;
	
	@Column(name = "VALIDATED_PHONE_NUMBER")
	private String validatedPhoneNumber;
	
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "NOTE")
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOriginalPhoneNumber() {
		return originalPhoneNumber;
	}

	public void setOriginalPhoneNumber(String originalPhoneNumber) {
		this.originalPhoneNumber = originalPhoneNumber;
	}

	public String getValidatedPhoneNumber() {
		return validatedPhoneNumber;
	}

	public void setValidatedPhoneNumber(String validatedPhoneNumber) {
		this.validatedPhoneNumber = validatedPhoneNumber;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
