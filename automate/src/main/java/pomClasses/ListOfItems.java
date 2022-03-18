package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListOfItems {
	
	@FindBy (xpath="(//div[@class='s-main-slot s-result-list s-search-results sg-row']//h2/a/span)[3]") private WebElement ThirdItem;
	
	public ListOfItems(WebDriver driver)
	{
		PageFactory.initElements(driver , this);
	}

	public void ClickOn3rdItem()
	{
		ThirdItem.click();
	}
}
