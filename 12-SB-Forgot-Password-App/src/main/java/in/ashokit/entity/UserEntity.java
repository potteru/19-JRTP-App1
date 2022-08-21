package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "USER_DTLS")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "USER_FIRST_NAME")
	private String userFirstName;
	
	@Column(name = "USER_LAST_NAME")
	private String userLastName;
	
	@Column(name = "USER_EMAIL",unique = true)
	private String userEmail;
	
	@Column(name = "USER_PHNO")
	private String userPhone;
	
	@Column(name = "USER_DOB")
	private LocalDate userDob;	
	
	@Column(name = "USER_GENDER")
	private String userGender;	 
	
	@Column(name = "USER_COUNTRY")
	private String userCountry;  
	
	@Column(name = "USER_STATE")
	private String userState;		
	
	@Column(name = "USER_CITY")
	private String userCity;	
	
	@Column(name = "USER_PWD")
	private String userPwd;		
	
	@Column(name = "USER_ACC_STATUS")
	private String userAccStatus;	
	
	@Column(name = "USER_CREATED_DATE")
	private LocalDate userCreatedDate;	
	
	@Column(name = "USER_UPDATED_DATE")
	private LocalDate userUpdatedDate;	

}
