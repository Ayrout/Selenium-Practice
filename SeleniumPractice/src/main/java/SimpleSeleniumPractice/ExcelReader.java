package SimpleSeleniumPractice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExcelReader 
{
	WebDriver driver;
	@BeforeTest
	void launchGoogle()
	{
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	///huhu
	@Test
	void test1() throws Exception
	{
		FileInputStream fis=new FileInputStream(new File(".\\Data\\ExcelPractice.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fis);		
		Sheet s=workbook.getSheet("Details");
		Row r=s.getRow(1);
		Cell c=r.getCell(1);
		String input=c.getStringCellValue();
		
		driver.findElement(By.name("q")).sendKeys(input);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("q")).sendKeys(Keys.TAB);
	}
	
	@AfterTest
	void closeWindow()
	{
		driver.close();
	}
}
