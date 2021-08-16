package com.example;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.controller.DemoController;
import com.example.model.PhoneNumberValidation;
import com.example.service.PhoneNumberValidationService;

@WebMvcTest(DemoController.class)
public class DemoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private PhoneNumberValidationService service;

	@Test
	public void getAllNumbersShouldReturn() throws Exception {
		
		PhoneNumberValidation v = new PhoneNumberValidation();
		v.setId(123L);
		v.setOriginalPhoneNumber("27831234567");
		v.setStatus(PhoneNumberValidation.STATUS_OK);
		
		PhoneNumberValidation v2 = new PhoneNumberValidation();
		v2.setId(123L);
		v2.setOriginalPhoneNumber("27831234567");
		v.setStatus(PhoneNumberValidation.STATUS_OK);
		
    	List<PhoneNumberValidation> list = Lists.newArrayList(v, v2);
		when(service.getAll()).thenReturn(list);
		
		this.mockMvc.perform(get("/numbers")).andDo(print()).andExpect(status().isOk());
	}
	
	@Test
	public void getNumbersByStatusShouldReturn() throws Exception {
		
		PhoneNumberValidation v = new PhoneNumberValidation();
		v.setId(123L);
		v.setOriginalPhoneNumber("27831234567");
		v.setStatus(PhoneNumberValidation.STATUS_OK);
		
		PhoneNumberValidation v2 = new PhoneNumberValidation();
		v2.setId(123L);
		v2.setOriginalPhoneNumber("27831234567");
		v.setStatus(PhoneNumberValidation.STATUS_OK);
		
    	List<PhoneNumberValidation> list = Lists.newArrayList(v, v2);
		when(service.getAll()).thenReturn(list);
		
		this.mockMvc.perform(get("/numbers/status/1")).andDo(print()).andExpect(status().isOk());
	}
}