package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shopping_cart {

	@FindBy (xpath="//h2[contains(text(),'Your Amazon Basket is empty')]") private WebElement actCartMsg;
	@FindBy (xpath="//span[@id='nav-cart-count']") private WebElement cartCount;
	@FindBy (xpath="//div[@data-asin='B074ZF7PVZ']") private WebElement displayedItem;
	@FindBy (xpath="//input[@value='Delete']") private WebElement deleteBtn;
	public Shopping_cart(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifycartMsg()
	{
		return actCartMsg.getText();
	}
	
	public String verifyCartCount()
	{
		return cartCount.getText();
	}
	
	public boolean verifyIteamDisplayed()
	{
		return displayedItem.isDisplayed();
	}
	public void clickDeleteBtn()
	{
		deleteBtn.click();	
	}
}
