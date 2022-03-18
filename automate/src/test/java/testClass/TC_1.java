package testClass;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import libraryFiles.BaseClass;
import libraryFiles.Utility;
import pomClasses.Amazon_HomePage;
import pomClasses.Shopping_cart;

public class TC_1 extends BaseClass
{      Workbook wbf;
	   Amazon_HomePage HP;
	   Shopping_cart SC;
	@BeforeTest
	public void browserLaunch()
	{
		browserOpen();
		
		HP= new Amazon_HomePage(driver);
		SC= new Shopping_cart(driver);
	}
	
	@BeforeMethod
	public void navigateToCart()
	{
		HP.ClickOnCartLogo();
		
	}
	
	  @Test
	  public void verificationOfCartMsg() throws InvalidFormatException, IOException
	  {
		 String ExpCartMsg = Utility.testData(1,1);
		 String actCartMsg = SC.verifycartMsg();
		 
		 Assert.assertEquals(actCartMsg,ExpCartMsg);
	  }
//Window close  
	  @AfterTest
		public void closeBrowser() throws InterruptedException
		{
			 Thread.sleep(5000);
			 driver.quit();
		}
}
