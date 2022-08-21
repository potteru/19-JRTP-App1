package in.ashokit.rest.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import in.ashokit.rest.WelcomeRestController;
import in.ashokit.service.WelcomeService;

@WebMvcTest(value = WelcomeRestController.class)
public class WelcomeRestControllerTest {
	
	@MockBean
	private WelcomeService welcomeService;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void welcomeTest() throws Exception {
		when(welcomeService.getWelcomeMsg()).thenReturn("Welcome to Ashokit");
		
		MockHttpServletRequestBuilder RequestBuilder = MockMvcRequestBuilders.get("/welcome");
		MvcResult mvcResult = mockMvc.perform(RequestBuilder).andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		int status = response.getStatus();
		assertEquals(200, status);
		
	}

}
