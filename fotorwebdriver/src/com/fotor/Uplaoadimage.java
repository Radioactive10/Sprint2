package com.fotor;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Uplaoadimage {
	private static XSSFWorkbook workbook;
	public static void main(String[] args) throws IOException, AWTException, InterruptedException {
		
		//driver path
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		
		//intaializing driver varaiable using chromedriver
		WebDriver driver = new ChromeDriver();
		
		//propertyfile
		File src= new File("C:\\Users\\kushal\\eclipse-workspace\\Sprint2petstore\\fotorwebdriver\\property\\upload.property");
		FileInputStream fis = new FileInputStream(src);
		
		// Load the properties File
		Properties prop = new Properties();
		prop.load(fis);
		
		//lanching fotor.com on the browser
		driver.navigate().to(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
		//fetching from xl file 
		FileInputStream fis1 = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\uploadimage.xlsx");
		workbook = new XSSFWorkbook(fis1);
		XSSFSheet ws = workbook.getSheetAt(0);
		int rownum  = ws.getLastRowNum();
		int colnum = ws.getRow(0).getPhysicalNumberOfCells();
		System.out.println("no of colunum for login credntial :" + colnum);
		System.out.println("no of row for login credntial :" + rownum);
		XSSFCell email;
		XSSFCell pass;
		email= ws.getRow(1).getCell(0);
		pass= ws.getRow(1).getCell(1);
		driver.findElement(By.xpath(prop.getProperty("signinButton"))).click();
		
		//entering email
		driver.findElement(By.xpath(prop.getProperty("emailText"))).sendKeys(email.toString());
		
		//entering password
		driver.findElement(By.xpath(prop.getProperty("passText"))).sendKeys(pass.toString());
		driver.findElement(By.xpath(prop.getProperty("loginButton"))).click();
		driver.findElement(By.xpath(prop.getProperty("uploadPageLink"))).click();
		
		//Robot class
		Robot robot = new Robot();
		
		//feathing from xl file
		XSSFSheet ws1 = workbook.getSheetAt(1);
		int rownum1  = ws1.getLastRowNum();
		int colnum1 = ws1.getRow(0).getPhysicalNumberOfCells();
		System.out.println("no of colnum for images :" + colnum1);
		System.out.println("no of rows for images :" + rownum1);
		XSSFCell photoPath;
		
		for(int i = 1; i <= rownum1 ; i++) {
			driver.findElement(By.xpath(prop.getProperty("uploadButton"))).click();
			photoPath= ws1.getRow(i).getCell(0);
			robot.setAutoDelay(2000);
			
			//copy the path
			StringSelection stringselection = new StringSelection(photoPath.toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
			robot.setAutoDelay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			
            //paste the path
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
            //click on enter
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		
		//my project
		driver.findElement(By.xpath(prop.getProperty("myproject"))).click();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath(prop.getProperty("ellipsismypro")))).perform();
		driver.findElement(By.xpath(prop.getProperty("ellipsismypro"))).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(prop.getProperty("myprototrash"))).click();
		Thread.sleep(2000);
		
		//trash
		driver.findElement(By.xpath(prop.getProperty("trash"))).click();
		Actions b = new Actions(driver);
		b.moveToElement(driver.findElement(By.xpath(prop.getProperty("ellipsitrash")))).perform();
		driver.findElement(By.xpath(prop.getProperty("ellipsitrash"))).click();
		
		//explicit wait
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(prop.getProperty("restore"))));
		driver.findElement(By.xpath(prop.getProperty("restore"))).click();
		
		//refresh the webpage
		driver.navigate().refresh();
	}

}
