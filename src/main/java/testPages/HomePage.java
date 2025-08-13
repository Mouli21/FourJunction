package testPages;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import basePack.BaseClassTest;

public class HomePage extends BaseClassTest{
	
	public HomePage webUrl(String url) {
		driver.get(url);
		return this;
	}
	
	public HomePage selectProduct(String product) throws Exception {
		try {
			try {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-fill-search")));
			}catch(Exception e){
				throw new TimeoutException();
			}
		driver.findElement(By.cssSelector("#twotabsearchtextbox")).sendKeys(product);
		driver.findElement(By.id("nav-search-submit-button")).click();
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
		return new SearchResultPage();

	}
	
	public  HomePage selectInvalidProduct(String prod) throws Exception 
	{

		selectProduct(prod);
		String result = driver.getTitle();
			if(result!=""&&result.contains("Online Shopping"))
			{
				Assert.assertTrue(true);
			}
			else {
				Assert.assertFalse(true,"Not Returned to home page");
			}
        return this;
	}

}
