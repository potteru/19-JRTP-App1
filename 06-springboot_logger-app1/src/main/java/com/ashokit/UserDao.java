package com.ashokit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	
	Logger logger = LoggerFactory.getLogger(UserDao.class);
	
	public void save() {
		logger.debug("***save method execution started ***");
		// logic to save record in DB
		logger.info("*** Record inserted into DB ***");
		logger.debug("***save method execution completed ***");
	}
}
