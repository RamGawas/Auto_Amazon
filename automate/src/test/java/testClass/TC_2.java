package testClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryFiles.BaseClass;
import libraryFiles.Utility;
import pomClasses.Amazon_HomePage;
import pomClasses.ListOfItems;
import pomClasses.ProductPage;
import pomClasses.Shopping_cart;

public class TC_2 extends BaseClass
{
	Amazon_HomePage HP;
	ListOfItems LI;
	ProductPage PP;
	Shopping_cart SC;
	
	@BeforeTest
    public void browserLaunch()
    {
    	browserOpen();
    	
    	HP= new Amazon_HomePage(driver);
    	LI= new ListOfItems(driver);
    	PP= new ProductPage(driver);
    	SC= new Shopping_cart(driver);
    }
	
	@BeforeClass
	public void searchItem() throws InterruptedException, InvalidFormatException, IOException
	{
		String searchText= Utility.testData(0, 1);
		HP.setSearchBoxInput(searchText);
		HP.clickSearchIcon();
		LI.ClickOn3rdItem();
		
		Set<String> allTabs = driver.getWindowHandles();
		
		ArrayList<String> al= new ArrayList<String>(allTabs);
		
		driver.switchTo().window(al.get(1));
		
		PP.ClickOnAddToCart();
		
		PP.ClickOnSkipButton();
		
	}
	@Test
	public void VerificationOfCartCount() throws InterruptedException
	{
		Thread.sleep(2000);
		String expCount= "1";
		String actCount = SC.verifyCartCount();
		Assert.assertEquals(actCount, expCount);
		
		
	}
	@Test( priority=1)
	public void verifyAddedCardItem() throws InterruptedException
	{
		Thread.sleep(2000);
		HP.ClickOnCartLogo();
		boolean cartItem = SC.verifyIteamDisplayed();
		Assert.assertTrue(cartItem);
	}
	@Test(priority=2)
	public void verifyAfterDeleteCartShowZero() throws InterruptedException
	{
		SC.clickDeleteBtn();
		Thread.sleep(2000);
		String expCount= "0";
		String actCount = SC.verifyCartCount();
		Assert.assertEquals(actCount, expCount);
		
	}
		
	@AfterTest
	public void closeBrowser() throws InterruptedException
	{
		 Thread.sleep(5000);
		 driver.quit();
	}
	

}
