package in.ashokit.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	private  JavaMailSender mailSender;
	
	public boolean sendEmail(String subject,String body,String to) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		 
        try {
 
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
 
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setText(body,true);
 
         //   mailSender.send(mimeMessageHelper.getMimeMessage());// I have 2 layer authentication so it will not work for my mail
            
            return true;
 
        } catch (Exception e) {
            e.printStackTrace();
        }
		
		return false;
	}

}
