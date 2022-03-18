package libraryFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {

	public static WebDriver driver;
	
	public static void browserOpen() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Shubhangi\\eclipse-workspace\\automate\\browsers\\chromedriver.exe");
	
	   driver = new ChromeDriver();
	   
	   driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	   driver.manage().window().maximize();
	   
	   driver.get("https://www.amazon.in");
	   
	   
	
	}
	
}
