package pomClasses;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import libraryFiles.BaseClass;
import libraryFiles.Utility;

public class ProductPage extends BaseClass{
 
   
	@FindBy (xpath="//input[@id='add-to-cart-button']") private WebElement addToCart;
	@FindBy (xpath="(//*[contains(text(),'Skip')])[5]") private WebElement skipbutton;
	
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void	ClickOnAddToCart()
	{
		addToCart.click();
	}
	
	public void ClickOnSkipButton()
	{
		new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(skipbutton));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click()", skipbutton);
//		 skipbutton.click();
		
	}
}
