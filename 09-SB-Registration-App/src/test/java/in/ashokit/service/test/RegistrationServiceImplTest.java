package in.ashokit.service.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import in.ashokit.entity.UserEntity;
import in.ashokit.properties.AppProperties;
import in.ashokit.repository.CityRepository;
import in.ashokit.repository.CountryRepository;
import in.ashokit.repository.StateRepository;
import in.ashokit.repository.UserRepository;
import in.ashokit.services.RegistrationServiceImpl;
import in.ashokit.utils.EmailUtils;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class RegistrationServiceImplTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private CountryRepository countryRepository;
	
	@MockBean
	private StateRepository stateRepository;
	
	@MockBean
	private CityRepository cityRepository;
	
	@MockBean
	private EmailUtils emailUtils;
	
	@MockBean
	private AppProperties appProperties;
	
	@InjectMocks
	private RegistrationServiceImpl service;
	
	
	
	@Test
	public void uniqueMailTest() {
		when(userRepository.findByUserEmail("aadi@gmail.com")).thenReturn(new UserEntity());
		boolean uniqueEmail = service.uniqueEmail("aadi@gmail.com");
		//assertTrue(uniqueEmail);// for null input
		assertFalse(uniqueEmail);
	}

}
