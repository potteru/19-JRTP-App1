package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.UnlockAccRequest;
import in.ashokit.constants.AppConstants;
import in.ashokit.entity.UserEntity;
import in.ashokit.properties.AppProperties;
import in.ashokit.repository.UserRepository;
@Service
public class UnlockAccountServiceImpl implements UnlockAccountService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AppProperties appProperties;
	
	@Override
	public String unlockAccount(UnlockAccRequest request) {

	UserEntity user = userRepository.findByUserEmailAndUserPwd(request.getEmail(), request.getTemppwd());
	if(user != null){
	user.setUserPwd(request.getNewPwd());
	user.setUserAccStatus(AppConstants.UNLOCKED);
	userRepository.save(user);
		return appProperties.getMessages().get(AppConstants.ACC_UNLOCK_SUCCESS);
	}
	return appProperties.getMessages().get(AppConstants.INVALID_TEMP_PWD);
	}
	
	
	
}