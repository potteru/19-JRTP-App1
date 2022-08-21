package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.request.CitizenData;
import in.ashokit.response.PlanInfo;
import in.ashokit.service.RuleService;

@RestController
public class EdRulesRestController {
	
	@Autowired
	private RuleService service;
	
	@GetMapping("/rules")
	public PlanInfo executeRules(@RequestBody CitizenData request) {
		
		return service.executeRules(request);
	}

}
