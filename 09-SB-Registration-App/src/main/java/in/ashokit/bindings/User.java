package in.ashokit.bindings;

import java.time.LocalDate;


import lombok.Data;
@Data
public class User {
	
	private Integer userId;
	private String userFirstName;
	private String userLastName;
	private String userEmail;
	private String userPhone;
	private LocalDate userDob;	
	private String userGender;	 
	private String userCountry;  
	private String userState;		
	private String userCity;	
	private String userPwd;		
	private String userAccStatus;	
	private LocalDate userCreatedDate;	
	private LocalDate userUpdatedDate;	

}
