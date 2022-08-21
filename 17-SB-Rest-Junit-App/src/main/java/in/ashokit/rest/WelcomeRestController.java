package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.service.WelcomeService;

@RestController
public class WelcomeRestController {
	@Autowired
	private WelcomeService service;
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome(){
		String welcomeMsg = service.getWelcomeMsg();
		return new ResponseEntity<>(welcomeMsg,HttpStatus.OK);
	}

}
