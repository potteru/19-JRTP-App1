package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.LoginRequest;
import in.ashokit.services.LoginService;

@RestController
public class LoginRestController {
	
	@Autowired
	private LoginService service;
	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return service.login(request);
	}
	
}
