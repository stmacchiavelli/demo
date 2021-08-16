package com.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.PhoneNumberValidation;
import com.example.repository.PhoneNumberValidationRepository;
import com.example.repository.entity.PhoneNumberValidationEntity;
import com.example.service.PhoneNumberValidationService;
import com.example.service.impl.PhoneNumberValidationServiceImpl;

@ExtendWith(MockitoExtension.class)
public class PhoneNumberServiceTest {

	@Mock
	private PhoneNumberValidationRepository repo;
	
	@InjectMocks
	private PhoneNumberValidationService pnService = new PhoneNumberValidationServiceImpl();
	
    @Test
    public void getAllPhoneNumber_Success() {
    	
    	PhoneNumberValidationEntity pne = new PhoneNumberValidationEntity();
    	pne.setId(123L);
    	pne.setOriginalPhoneNumber("27831234567");
    	
    	PhoneNumberValidationEntity pne2 = new PhoneNumberValidationEntity();
    	pne2.setId(1234L);
    	pne2.setOriginalPhoneNumber("27831234568");
    	
    	List<PhoneNumberValidationEntity> list = Lists.newArrayList(pne, pne2);
    	when(repo.findAll()).thenReturn(list);

    	List<PhoneNumberValidation> savedn = pnService.getAll();
    	
    	assertTrue(savedn.size() == 2);
    }

   
}
