package in.ashokit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PalindromeTest {
	@ParameterizedTest
	@ValueSource(strings = {"racecar","liril","madam","aadi"})
	//@Test
	public void isPalindromeTest(String str) {
	
		PalindromeCheck pc = new PalindromeCheck();
		boolean actual = pc.isPalindrome(str);
		//boolean expected = true;
		assertTrue(actual);
		//assertFalse(actual);
		//assertEquals(actual,expected);
		
	}
}
