package in.ashokit.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import in.ashokit.UserDao;
import in.ashokit.service.UserService;

public class UserServiceTest {
	@Test
	public void getNameTest() {
		UserDao userDaoMock = PowerMockito.mock(UserDao.class);
		PowerMockito.when(userDaoMock.findNameById(101)).thenReturn("Raju");
		
		UserService service = new UserService(userDaoMock);
		String actualname = service.getName(101);
		String expectedname = "Raju";
		assertEquals(expectedname, actualname);
	}
	@Test
	public void loginTest() {
		UserDao userDaoMock = PowerMockito.mock(UserDao.class);
		PowerMockito.when(userDaoMock.findByEmailAndPwd("admin@gmail.com","admin")).thenReturn(true);
		
		UserService service = new UserService(userDaoMock);
		String actualStatus = service.login("admin@gmail.com", "admin");
		String expectedStatus = "success";
		
		assertEquals(expectedStatus, actualStatus);
	}

}
