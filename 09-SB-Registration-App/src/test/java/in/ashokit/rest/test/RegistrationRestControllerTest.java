package in.ashokit.rest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.HashMap;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import in.ashokit.bindings.User;
import in.ashokit.constants.AppConstants;
import in.ashokit.rest.RegistrationRestController;
import in.ashokit.services.RegistrationService;

@WebMvcTest(value = RegistrationRestController.class)
public class RegistrationRestControllerTest {
	@MockBean
	private RegistrationService regService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	private void emailCheckTest() throws Exception {
		
		when(regService.uniqueEmail("aadi@gmail.com")).thenReturn(true);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emailcheck/{aadi@gmail.com}");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String responseBody = response.getContentAsString();
		//System.out.println("content :: "+ responseBody);
		assertEquals(AppConstants.UNIQUE, responseBody);
	}
	
	@Test
	private void emailCheckTest2() throws Exception {
		
		when(regService.uniqueEmail("di@gmail.com")).thenReturn(false);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/emailcheck/{di@gmail.com}");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String responseBody = response.getContentAsString();
		//System.out.println("content :: "+ responseBody);
		assertEquals(AppConstants.DUPLICATE, responseBody);
	}
	
	@Test
	private void countriesTest() throws Exception {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "India");
		map.put(2, "USA");
		
		when(regService.getCountries()).thenReturn(map);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/countries");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200,status);
	}
	
	@Test
	private void statesTest() throws Exception {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Ap");
		map.put(2, "TS");
		
		when(regService.getStates(1)).thenReturn(map);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/states/1");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200,status);
	}
	
	@Test
	private void citiesTest() throws Exception {
		
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "ATP");
		map.put(2, "Guntur");
		
		when(regService.getCities(1)).thenReturn(map);
		
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/cities/1");
		MvcResult mvcResult = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200,status);
	}
	/*
	@Test
	public void saveUserTest1() throws Exception {
		User user =new User();
		user.setUserFirstName("aadi");
		user.setUserLastName("murthy");
		user.setUserEmail("aadi@gmail.com");
	
		
		when(regService.registerUser(user)).thenReturn(true);
		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(mapper);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/saveuser")
							  .contentType("application/json")
							  .content(userJson);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		String resBody = result.getResponse().getContentAsString();
		
		assertEquals(AppConstants.SUCCESS, resBody);
	}
	
	@Test
	public void saveUserTest2() throws Exception {
		User user =new User();
		user.setUserFirstName("aadi");
		user.setUserLastName("murthy");
		user.setUserEmail("aadi@gmail.com");
		//
		when(regService.registerUser(user)).thenReturn(false);
		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = mapper.writeValueAsString(mapper);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/saveuser")
							  .contentType("application/json")
							  .content(userJson);
		
		MvcResult result = mockMvc.perform(request).andReturn();
		String resBody = result.getResponse().getContentAsString();
		
		assertEquals(AppConstants.FAIL, resBody);
	}
	*/
}
