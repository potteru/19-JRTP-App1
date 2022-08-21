package com.ashokit;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserDao dao;
	
	Logger logger = LoggerFactory.getLogger(UserService.class);
	public void saveUser() {
	logger.info("***save method started***");
	dao.save();
	logger.info("***save method ended***");
	}
}
