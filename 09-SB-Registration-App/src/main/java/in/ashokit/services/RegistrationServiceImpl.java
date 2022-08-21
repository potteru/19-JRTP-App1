package in.ashokit.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.User;
import in.ashokit.constants.AppConstants;
import in.ashokit.entity.CityEntity;
import in.ashokit.entity.CountryEntity;
import in.ashokit.entity.StateEntity;
import in.ashokit.entity.UserEntity;
import in.ashokit.exceptions.RegAppException;
import in.ashokit.properties.AppProperties;
import in.ashokit.repository.CityRepository;
import in.ashokit.repository.CountryRepository;
import in.ashokit.repository.StateRepository;
import in.ashokit.repository.UserRepository;
import in.ashokit.utils.EmailUtils;
@Service
public class RegistrationServiceImpl implements RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private AppProperties appProperties;
	
	@Override
	public boolean uniqueEmail(String email) {
		UserEntity userEntity = userRepository.findByUserEmail(email);
		//return userEntity == null;//or below code
		if(userEntity!=null) {
			return false;// 
		}else {
			return true;
		}
	}

	@Override
	public Map<Integer, String> getCountries() {
		List<CountryEntity> findAll = countryRepository.findAll();
		
		Map<Integer,String> countryMap = new HashMap<>();
		for(CountryEntity entity  : findAll) {
			countryMap.put(entity.getCountryId(), entity.getCountryName());
		}
		return countryMap;
	}

	@Override
	public Map<Integer, String> getStates(Integer countryId) {
		List<StateEntity> statesList = stateRepository.findByCountryId(countryId);
		
		Map<Integer,String> statesMap = new HashMap<>();
		
		for(StateEntity state : statesList) {
			statesMap.put(state.getStateId(), state.getStateName());
		}
		return statesMap;
	}

	@Override
	public Map<Integer, String> getCities(Integer stateId) {
		List<CityEntity> citiesList = cityRepository.findByStateId(stateId);
		Map<Integer,String> cityMap = new HashMap<>();
		
		for(CityEntity city : citiesList) {
			cityMap.put(city.getCityId(), city.getCityName());
		}
		return cityMap;
	}

	@Override
	public boolean registerUser(User user) {
		
		user.setUserPwd(generateTempPwd());
		user.setUserAccStatus(AppConstants.LOCKED);
		
		UserEntity entity = new UserEntity();
		BeanUtils.copyProperties(user, entity);
		
		UserEntity save = userRepository.save(entity);
		if(null != save.getUserId()) {
			return sendRegEmail(user);
		}

		return false;
	}
	
	private String generateTempPwd() {
		String tempPwd = null;
		
		int leftLimit = 48; // letter 'a'
	    int rightLimit = 122; // letter 'z'
	    int targetStringLength = 6;
	    Random random = new Random();
	    StringBuilder buffer = new StringBuilder(targetStringLength);
	    for (int i = 0; i < targetStringLength; i++) {
	        int randomLimitedInt = leftLimit + (int) 
	          (random.nextFloat() * (rightLimit - leftLimit + 1));
	        buffer.append((char) randomLimitedInt);
	    }
	   // String generatedString = buffer.toString();

	   // System.out.println(generatedString);
		
		return buffer.toString();
	}
	
	private boolean sendRegEmail(User user) {
		boolean emailSent = false;
		
		//String subject = "User Registration success";
		//String body = readMailBody("UNLOCK-ACC-EMAIL-BODY-TEMPLATE.txt",user);
		try {
		Map<String,String> messages = appProperties.getMessages();// reading properties from properties file through AppPropertis class
		String subject = messages.get(AppConstants.REG_MAIL_SUBJECT);
		String bodyFileName = messages.get(AppConstants.REG_MAIL_BODY_TEMPLATE_FILE);
		String body = readMailBody(bodyFileName, user);
		emailUtils.sendEmail(subject, body, user.getUserEmail());
		emailSent = true;
		}
		catch (Exception e) {
			throw new RegAppException(e.getMessage());
		}
		return emailSent;
	}
	
	public String readMailBody(String fileName,User user) {
		
		String mailBody = null;
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(fileName);
		
		try(Stream<String> stream = Files.lines(path)){
			stream.forEach(line -> {
				buffer.append(line);
			});
			mailBody = buffer.toString();
			mailBody = mailBody.replace(AppConstants.FNAME, user.getUserFirstName());
			mailBody = mailBody.replace(AppConstants.EMAIL, user.getUserEmail());
			mailBody = mailBody.replace(AppConstants.TEMP_PWD, user.getUserPwd());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return mailBody;
	}

}
