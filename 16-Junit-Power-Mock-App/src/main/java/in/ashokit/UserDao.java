package in.ashokit;

public interface UserDao {
	
	public String findNameById(Integer id);
	
	public boolean findByEmailAndPwd(String string, String string2);

}
