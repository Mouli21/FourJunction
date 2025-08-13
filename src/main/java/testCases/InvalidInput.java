package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testPages.HomePage;

public class InvalidInput extends HomePage {
	
	@Parameters("browser")
	@Test (priority = 1)
	public void login_Product(String browser) throws Exception 
	{
		new HomePage();
        browserSetUp(browser);
        webUrl("https://www.amazon.in/").selectInvalidProduct("");	
	}

}
