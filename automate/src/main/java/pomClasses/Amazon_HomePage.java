package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazon_HomePage {

	@FindBy (xpath="//a[@id='nav-cart']") private WebElement cartLogo;
	@FindBy (xpath="//input[@id='twotabsearchtextbox']") private WebElement searchBox;
	@FindBy (xpath="//input[@type='submit']") private WebElement searchIcon;
	
	public Amazon_HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void setSearchBoxInput(String searchText)
	{
		searchBox.sendKeys(searchText);
	}
	
	public void clickSearchIcon()
	{
		searchIcon.click();
	}
	
	public void ClickOnCartLogo()
	{
		cartLogo.click();
	}
	
	
}
