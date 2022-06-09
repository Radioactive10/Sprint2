package SaveImages;

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

public class SaveImagesTest {
	WebDriver driver;
	private static XSSFWorkbook workbook;
	@BeforeTest
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void RunsaveImages() throws IOException, InterruptedException {
		FileInputStream fiss = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\testngimagedown.xlsx");
		workbook = new XSSFWorkbook(fiss);
		XSSFSheet ws = workbook.getSheetAt(0);
		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell email;
		XSSFCell pass;
		SignInPage signin = new SignInPage(driver);
		email= ws.getRow(1).getCell(0);
		pass= ws.getRow(1).getCell(1);
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		signin.setLogin(email.toString(),pass.toString());
		HomePage home = new HomePage(driver);
		String parent = driver.getWindowHandle();
		WebElement mouseMore = home.moveMouseToMore();
		Actions a = new Actions(driver);
		a.moveToElement(mouseMore).perform();
		WebElement helpClick = home.ClickOnHelp();
		helpClick.click();
		Thread.sleep(3000);
		driver.switchTo().window(parent);
		org.testng.Assert.assertEquals("Home - Fotor",driver.getTitle());
		System.out.println(driver.getTitle());
		WebElement myproject = home.ClickOnMyproject();
		myproject.click();
		WebElement movemouseToimage = home.moveMouseToImage();
		Actions a1= new Actions(driver);
		a1.moveToElement(movemouseToimage).perform();
		WebElement dotsOnImage = home.ClickOnDotsOnImage();
		dotsOnImage.click();
		WebElement downloadButton = home.ClickOnDownloadButton();
		downloadButton.click();
		WebElement successDownloadButton = home.ClickOnSuccessDownload();
		successDownloadButton.click();
		Thread.sleep(3000);

	}
	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}
	

}
