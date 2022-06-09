package Neagavtive;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class testSignin {
	private static XSSFWorkbook workbook;
	@Test
	public void Sigineag() throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\testngneagtive.xlsx");
		workbook = new XSSFWorkbook(fis);
		XSSFSheet ws = workbook.getSheetAt(0);
		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println(colnum);
		System.out.println(rownum);
		XSSFCell email;
		XSSFCell pass;
		
		siginin signin = new siginin(driver); 
		email= ws.getRow(1).getCell(0);
		pass= ws.getRow(1).getCell(1);
		signin.setLogin(email.toString(),pass.toString());
		
		 WebElement error = signin.error();
		
		
		if(error.isDisplayed()==true) {
			org.testng.Assert.assertEquals("Account or password is invalid",error.getText());
			System.out.println("This error is displayed "+error.getText());
		}
	}

}
