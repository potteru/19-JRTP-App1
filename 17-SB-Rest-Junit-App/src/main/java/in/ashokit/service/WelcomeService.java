package in.ashokit.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class WelcomeService {
	
	public String getWelcomeMsg() {
		return "Good morning ";
	}

}
