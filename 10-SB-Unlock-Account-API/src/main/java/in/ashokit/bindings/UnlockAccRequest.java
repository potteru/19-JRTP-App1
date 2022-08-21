package in.ashokit.bindings;

import lombok.Data;

@Data
public class UnlockAccRequest {
	
	private String email;
	private String temppwd;
	private String newPwd;
	private String conformPwd;

}
