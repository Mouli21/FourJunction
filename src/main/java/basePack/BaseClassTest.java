package basePack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassTest {
	
	public static WebDriver driver;
	
	public BaseClassTest browserSetUp(String browser) {
		
		try {
		
		if(browser.equalsIgnoreCase("chrome"))
		{
		    WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver","D:\\Selenium\\New version\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		}
		catch (Exception e) {
			System.err.print(e);
		}
		
		return this;

	}
	
	public BaseClassTest browserTeardown() {
		driver.close();
		
		return this;
	}

}
