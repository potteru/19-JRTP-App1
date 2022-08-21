package in.ashokit.service;

import org.springframework.stereotype.Service;

import in.ashokit.request.CitizenData;
import in.ashokit.response.PlanInfo;

@Service
public class RuleService {
	
	public PlanInfo executeRules(CitizenData request) {
		
		PlanInfo response = new PlanInfo();
		// execute rules as per citizens applied plan
		
		String planName = request.getPlanName();
		Double income = request.getIncome();
		
		response.setPlanName(planName);
		response.setName(request.getName());
		response.setSsn(request.getSsn());
		
		if("SNAP".equals(planName)) {
			// SNAP Conditions
			if(income <=200) {
				response.setPlanStatus("Approved");
				response.setBenifitAmt(350.00);
				response.setStartDate("25-feb-2022");
				response.setEndDate("25-May-2022");
				
			}else {
				response.setPlanStatus("Denied");
				response.setDenialReason("High Income");
			}
		}
		else if("CCAP".equals(planName)) {
			//CCAP conditions
			String status = request.getKidsEligible();
			if(income <=200 && "YES".equals(status)) {
				response.setPlanStatus("Approved");
				response.setBenifitAmt(350.00);
				response.setStartDate("25-feb-2022");
				response.setEndDate("25-May-2022");
			}
			else {
				response.setPlanStatus("Denied");
				response.setDenialReason("High Income or Kids Age is more than 16 years");
			}
		}
		else if("Medicaid".equals(planName)){
			// Medicaid conditions
			if(income <=300) {
				response.setPlanStatus("Approved");
				response.setBenifitAmt(350.00);
				response.setStartDate("25-feb-2022");
				response.setEndDate("25-May-2022");	
			}
			else {
				response.setPlanStatus("Denied");
				response.setDenialReason("High Income");
			}
			
		}
		else if("Medicare".equals(planName)) {
			//Medicare Conditions
			if(request.getAge() >=65) {
				response.setPlanStatus("Approved");
				response.setBenifitAmt(350.00);
				response.setStartDate("25-feb-2022");
				response.setEndDate("25-May-2022");	
			}
			else {
				response.setPlanStatus("Denied");
				response.setDenialReason("High Income");
			}
			
		}
		else if("KW".equals(planName)) {
			//KW conditions
			if(request.getEmpStatus().equals("UNEMPLOYEE") ) {
				response.setPlanStatus("Approved");
				response.setBenifitAmt(350.00);
				response.setStartDate("25-feb-2022");
				response.setEndDate("25-May-2022");	
			}
			else {
				response.setPlanStatus("Denied");
				response.setDenialReason("Un-Employes can only apply");
			}
		}
		
		return response;
	}

}
