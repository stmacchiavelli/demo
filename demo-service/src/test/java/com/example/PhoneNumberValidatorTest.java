package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.example.model.PhoneNumber;
import com.example.model.PhoneNumberValidation;
import com.example.service.PhoneNumberValidator;
import com.example.service.impl.PhoneNumberValidatorImpl;

public class PhoneNumberValidatorTest {
		
	private PhoneNumberValidator validator = new PhoneNumberValidatorImpl();

    @Test
    public void invalidPhoneNumberLength() {
    	PhoneNumber pn = new PhoneNumber(1L, "222222");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_KO));
    }
    
    @Test
    public void invalidCharactersInPhoneNumber() {
    	PhoneNumber pn = new PhoneNumber(1L, "27733398529_DELETED_1488176172");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_KO));
    }
    
    @Test
    public void invalidPhoneNumber() {
    	PhoneNumber pn = new PhoneNumber(1L, "DELETED_1488176172");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_KO));
    }
        
    @Test
    public void invalidPhoneNumber2() {
    	PhoneNumber pn = new PhoneNumber(1L, "_DELETED_1488263234");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_KO));
    }
    
    
    @Test
    public void validPhoneNumber() {
    	PhoneNumber pn = new PhoneNumber(1L, "27733398529");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_OK));
    }
    
    @Test
    public void invalidPhoneNumberPrefix() {
    	PhoneNumber pn = new PhoneNumber(1L, "44733398529");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_KO));
    }
    
    @Test
    public void addPhoneNumberPrefix() {
    	PhoneNumber pn = new PhoneNumber(1L, "733398529");
    	PhoneNumberValidation validate = validator.validate(pn);
    	assertTrue(validate.getStatus().equals(PhoneNumberValidation.STATUS_CHANGED));
    	assertTrue(validate.getValidatedPhoneNumber().equals("27733398529"));
    }
}
