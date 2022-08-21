package in.ashokit.services;

import java.util.Map;

import in.ashokit.bindings.User;


public interface RegistrationService {
	
	//public String getUserDetails(User user);
	
	//public String saveUser(User saveuser);
	
	//public void editUser(User userId);
	
	//public String deleteUser(User userId);
	
	public boolean uniqueEmail(String email);
	
	public Map<Integer,String> getCountries();
	
	public Map<Integer,String> getStates(Integer countryId);
	
	public Map<Integer,String> getCities(Integer stateId);
	
	public boolean registerUser(User user);

}
