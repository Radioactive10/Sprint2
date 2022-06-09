package langauage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import SaveImages.SignInPage;

public class langauageTest {
	private static XSSFWorkbook workbook;
	WebDriver driver;
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void langauge() throws InterruptedException, IOException {
		FileInputStream fiss = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\testngimagedown.xlsx");
		workbook = new XSSFWorkbook(fiss);
		XSSFSheet ws = workbook.getSheetAt(0);
		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell email;
		XSSFCell pass;
		email= ws.getRow(1).getCell(0);
		pass= ws.getRow(1).getCell(1);
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SignInPage s = new SignInPage(driver);
		s.setLogin(email.toString(),pass.toString());
		homelangua h = new homelangua(driver);
	
		WebElement mouseMore = h.moveMouseToMore();

		Actions a = new Actions(driver);
		a.moveToElement(mouseMore).perform();
		org.testng.Assert.assertEquals("Home - Fotor", driver.getTitle());
		WebElement langClick = h.ClickOnlang();
		langClick.click();
		WebElement Click = h.ClickOnjapne();
		Click.click();
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
