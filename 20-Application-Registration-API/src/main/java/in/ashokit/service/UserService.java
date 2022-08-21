package in.ashokit.service;

import java.util.List;

import in.ashokit.bindings.User;

public interface UserService{
	
	public List<User> getUser(User user);
	
	public boolean checkSsn(User user);
	
	public String saveUser(User user);
	
	public List<User> getRegUser(List<User> user);

}
