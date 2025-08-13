package testPages;

import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends HomePage {
public	List<WebElement> p_name;
public List<WebElement> p_price;
public	List<WebElement> p_rating;
	
	
	public SearchResultPage productName() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")));
		
		 p_name = driver.findElements(By.xpath("//a/h2/span"));
		 
		return this;
	}
	
	public SearchResultPage productPrice() {
		p_price =  driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		return this;
	}
	
	public SearchResultPage productRating() {
		p_rating = driver.findElements(By.xpath("//div[@class='a-row a-size-small']/a/span"));
	
		return this;
	}
	
	public String productUrl() {
	   String page_url = driver.getCurrentUrl();
	
	return page_url;

	}
	
	public SearchResultPage productPage() {	
		driver.findElement(By.xpath("//span[contains(text(),'HP ')]")).click();
		
		return new ProductPage();	

	}
	
	public List<List<String>> getAllDetails() throws Exception {	
		List<List<String>> li = new ArrayList<>();
		
		if(p_name.size()!=0) 
		{
		
		for(int i=0 ; i<p_name.size()-1 ; i++)
		{
		 String name = 	p_name.get(i).getText().trim();
		 String price = p_price.get(i).getText().trim();
	     String rating = p_rating.get(i).getText().trim();
	     
	     li.add(Arrays.asList(name,price,rating));
		}
		
	 }
		else {
			throw new Exception("size of the list is : "+p_name.size()+" Kindly check the productName");
		}
		return li;
	}
	
	public int randomNum()
	{
		Random r = new Random(10);
		int num = r.nextInt();
		return num;
	}
	
	public void excelData() throws IOException {
		FileWriter fw = new FileWriter("AmazonProduct_"+randomNum()+".csv");
		fw.append("ProductName, Price, Ratings \n");
		
		for(int i=0 ; i<p_rating.size()-1 ; i++)
		{
			 String name = 	p_name.get(i).getText().replaceAll(",", " ").trim();
			 String price = p_price.get(i).getText().replaceAll(",", " ").trim();
		     String rating = p_rating.get(i).getText().replaceAll(",", " ").trim(); 
		     //System.out.println("name :->"+p_name.size()+" "+"price :->"+p_price.size()+" "+"rating :->"+p_rating.size());
		     fw.append(name).append(",").append(price).append(",").append(rating).append("\n");
		}
		fw.close();
		System.out.println("Data extrated to csv");

	}

}
