package in.ashokit.Pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private int usrId;
	private String fname;
	private String lname;
	private Date dob;
	private String gender;
	private String email;
	
	public static void main(String[] args) {
		User user = new User();
		user.setUsrId(10);
		user.setFname("adi");
		user.getUsrId();
		user.getFname();
		//User user1 = new User(0, null, null, null, null, null);
		System.out.println(user.toString());
	}
}
