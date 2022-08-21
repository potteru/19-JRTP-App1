package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.services.ForgotPwdService;

@RestController
public class ForgotPwdRestController {
	
	@Autowired
	private ForgotPwdService service;
	
	@PostMapping("/forgotpwd/{email}")
	public String forgotPwd(@PathVariable String email) {
		
		return service.forgotPwd(email); 
	}

}
