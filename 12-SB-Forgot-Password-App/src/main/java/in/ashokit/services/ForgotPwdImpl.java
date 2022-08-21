package in.ashokit.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.constants.AppConstants;
import in.ashokit.entity.UserEntity;
import in.ashokit.properties.AppProperties;
import in.ashokit.repository.UserRepository;
import in.ashokit.utils.EmailUtils;

@Service
public class ForgotPwdImpl implements ForgotPwdService {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private EmailUtils emailUtils;
	
	@Autowired
	private AppProperties props;
	
	@Override
	public String forgotPwd(String email) {
		UserEntity user = userRepo.findByUserEmail(email);
		if(user == null) {
			return props.getMessages().get(AppConstants.NO_RECORD);
		}
		
		boolean isSent = sendForgotPwdEmail(user);
		if(isSent) {
			return props.getMessages().get(AppConstants.PWD_SENT);
		}
		return props.getMessages().get(AppConstants.ERROR);
	}
	
	public boolean sendForgotPwdEmail(UserEntity user) {
		
		String fname = user.getUserFirstName();
		String to = user.getUserEmail();
		String pwd = user.getUserPwd();
		
		String subject = props.getMessages().get(AppConstants.FORGOT_PASSWORD_MAIL_SUBJECT);
		String bodyFileName = props.getMessages().get(AppConstants.FORGOT_PASSWORD_MAIL_BODY_TEMPLATE_FILE);
		String body = readMailBody(bodyFileName, user);
		
		return emailUtils.sendEmail(subject, body, to);
	}
	
public String readMailBody(String fileName,UserEntity user) {
		
		String mailBody = null;
		StringBuffer buffer = new StringBuffer();
		Path path = Paths.get(fileName);
		
		try(Stream<String> stream = Files.lines(path)){
			stream.forEach(line -> {
				buffer.append(line);
			});
			mailBody = buffer.toString();
			mailBody = mailBody.replace(AppConstants.FNAME, user.getUserFirstName());
			mailBody = mailBody.replace(AppConstants.PWD, user.getUserPwd());
			
		}catch (IOException e) {
			e.printStackTrace();
		}
		return mailBody;
	}

}
