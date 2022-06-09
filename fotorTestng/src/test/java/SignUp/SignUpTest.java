package SignUp;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest {
	private static XSSFWorkbook workbook;
	WebDriver driver;
	@BeforeTest
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Test
	public void SignUpRunning() throws IOException {
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\testngimagedown.xlsx");
		workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);
		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell email;
		XSSFCell pass;
		SignUpPage signUp = new SignUpPage(driver);
		email= ws.getRow(1).getCell(0);
		pass= ws.getRow(1).getCell(1);
		signUp.setLogin(email.toString(),pass.toString());
		WebElement error = signUp.ErrorIsAppeared();
		if(error.isDisplayed()==true) {
			Assert.assertEquals("This email is already registed!",error.getText());
			System.out.println("This error is displayed :"+error.getText());
		}
	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
