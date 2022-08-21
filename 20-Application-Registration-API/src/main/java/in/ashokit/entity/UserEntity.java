package in.ashokit.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name = "APPLICATION_REG")
public class UserEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Integer userId;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "EMAIL_ID")
	private String emailId;
	
	@Column(name = "MOBILE_NUMBER")
	private Double mobileNumber;
	
	@Column(name = "GENDER")
	private String gender;
	
	@Column(name = "USER_DOB")
	private Date userDob;
	
	@Column(name = "USER_SSN")
	private Integer userSsn;

}
