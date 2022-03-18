package pomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonHomePage {

	public static void main(String[] args) throws InterruptedException {
		
		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubhangi\\eclipse-workspace\\automate\\browsers\\chromedriver.exe");
	
	      WebDriver driver = new ChromeDriver();
	      
	      driver.manage().window().maximize();
	      
	      driver.get("https://www.amazon.in");
	      
	      driver.findElement(By.xpath("//a[@id='nav-cart']")).click();
	     
	      Thread.sleep(2000);
	      
	      WebElement isEmpty = driver.findElement(By.xpath("//h2[contains(text(),'Your Amazon Basket is empty')]"));
	
	      String expStmt = "Your Amazon Cart is empty";
	      
	      String actStmt= isEmpty.getText();
	      
	      if(actStmt.equals(expStmt))
	      {
	    	  System.out.println("Verified text is displayed");
	      }
	      else
	      {
	    	  System.out.println("Text not showing as expected");
	      }
	}
}
