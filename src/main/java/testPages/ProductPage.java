package testPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;



public class ProductPage extends SearchResultPage {
	
	public ProductPage cartButton() {
		WebElement cart_btn = driver.findElement(By.xpath("(//span[@id='submit.add-to-cart-announce'])[2]"));
		
		Assert.assertTrue(cart_btn.isDisplayed());
		
		return this;
	}
	
	public ProductPage productDescription() 
	{
	 WebElement desc = driver.findElement(By.cssSelector("#productTitle"));
	 Actions act = new Actions(driver);
	 act.scrollToElement(desc);
	 String lapDesc = desc.getText();
	 
	 if(lapDesc.toLowerCase().contains("laptop"))
	 {
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Assert.assertFalse(true);;
	 }
	 
	 return this;
	}
	
	public ProductPage imgFunctionality() 
	{
	 WebElement img = 	driver.findElement(By.xpath("//div[@id='imgTagWrapperId']/img"));
	 
     Assert.assertTrue(img.isDisplayed());
     
     return this;
	}

}
