package testCases;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import testPages.*;

public class ValidInput extends ProductPage {
	
	@Parameters("browser")
	@Test (priority = 1)
	public void login_Product(String browser) throws Exception 
	{
		new HomePage();
        browserSetUp(browser);
        webUrl("https://www.amazon.in/").selectProduct("laptop");
		
	}
	
	@Test (priority = 2)
	public void searchProduct() throws Exception {
		
		new SearchResultPage();
		productName().productPrice().productRating().productUrl();excelData();//.productPage();
		//System.out.println(getAllDetails());
		productPage();

	}
	
	@Test (priority = 3, dependsOnMethods = "searchProduct")
	public void productValidation() {
		
		new ProductPage();
		cartButton().imgFunctionality().productDescription();

	}
	
	

}
