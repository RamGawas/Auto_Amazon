package libraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility extends BaseClass
{

	 static Workbook wbf;
	 
	 public static String testData(int rowValue, int cellValue) throws InvalidFormatException, IOException
	 {
		 String filePath="C:\\Users\\Shubhangi\\eclipse-workspace\\automate\\TestData\\TestData.xlsx";
		FileInputStream file = new FileInputStream(filePath);
		
		wbf = WorkbookFactory.create(file);
		
		String testValue = wbf.getSheet("Sheet1").getRow(rowValue).getCell(cellValue).getStringCellValue();
		
		return testValue;
	 }
	 
	 public static void screenshot(WebDriver driver ,int ssid) throws IOException
	 {
		 File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 File destination= new File("C:\\Users\\Shubhangi\\eclipse-workspace\\automate\\Screenshots\\snap"+ssid+".jpg");
		 FileHandler.copy(source, destination);
	 }
//	 public static void clickOn(WebDriver driver, WebElement element, int timeout)
//	 {
//		 new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
//		 element.click();
//	 }
	 
}
