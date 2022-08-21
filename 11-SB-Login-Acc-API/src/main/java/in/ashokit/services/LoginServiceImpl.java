package in.ashokit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.bindings.LoginRequest;
import in.ashokit.constants.AppConstants;
import in.ashokit.entity.UserEntity;
import in.ashokit.properties.AppProperties;
import in.ashokit.repository.UserRepository;
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private AppProperties properties;

	@Override
	public String login(LoginRequest request) {
		UserEntity user = userrepo.findByUserEmailAndUserPwd(request.getEmail(), request.getPwd());
		if(null == user) {
			return properties.getMessages().get(AppConstants.INVALID_CREDENTIALS);
		}
		if(user.getUserAccStatus().equals(properties.getMessages().get(AppConstants.LOCKED))){
			return properties.getMessages().get(AppConstants.YOUR_ACCOUNT_IS_LOCKED);
		}
		return properties.getMessages().get(AppConstants.SUCCESS);
	 }
}
