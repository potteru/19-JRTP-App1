package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.bindings.UnlockAccRequest;
import in.ashokit.services.UnlockAccountService;

@RestController
public class UnlockAccountRestController {
	
	@Autowired
	private UnlockAccountService service;
	
	@GetMapping("/unlockaccount")
	public String unlockAccount(@RequestBody UnlockAccRequest request) {
		return service.unlockAccount(request);
	}
	
}
