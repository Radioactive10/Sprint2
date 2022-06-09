package editimage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class EditImageTest {
	WebDriver driver;
	private static XSSFWorkbook workbook;
	@BeforeTest
	public void openbrowser() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void EditImage() throws InterruptedException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\kushal\\Desktop\\Sprint\\testngeditpage.xlsx");
        workbook = new XSSFWorkbook(fis);
        XSSFSheet ws = workbook.getSheetAt(0);
        int rownum  = ws.getLastRowNum();
        int colnum = ws.getRow(0).getPhysicalNumberOfCells();
        System.out.println(colnum);
        System.out.println(rownum);
        XSSFCell email;
        XSSFCell pass;
        //XSSFCell bright;
        //XSSFCell ;
        email= ws.getRow(1).getCell(0);
        pass= ws.getRow(1).getCell(1);
        //bright=ws.getRow(2).getCell(1);
        //System.out.println(bright.toString());
		driver.navigate().to("https://www.fotor.com/photo-editor-app/editor/cloud");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		SiginInPage sp = new SiginInPage(driver);
		sp.signin(email.toString(),pass.toString());
		String title = driver.getTitle();
		//Regular Expression
		Assert.assertTrue(driver.getTitle().matches("^Fotor Editor(.*)$"));
		Assert.assertEquals(title,driver.getTitle());
		System.out.println(driver.getTitle());
		
		EditPage eg = new EditPage(driver);
		WebElement load = eg.Upload();
		load.click();
		Thread.sleep(3000);
		
		WebElement adjustjpeg = eg.adjustfea();
		adjustjpeg.click();
		
		WebElement cropjpeg = eg.cropimg();
		cropjpeg.click();
		
		WebElement cropratio = eg.cropresize();
		cropratio.click();
		
		WebElement cropbtton = eg.cropclick();
		cropbtton.click();
		
		WebElement adjustfea = eg.adjust();
		adjustfea.click();
		Thread.sleep(2000);
		
		WebElement brightjpeg = eg.brighimg();
		brightjpeg.sendKeys("20" + Keys.ENTER);
		
		WebElement contjpeg = eg.contimg();
		contjpeg.sendKeys("33" + Keys.ENTER);
		
		WebElement satjpeg = eg.satimg();
		satjpeg.sendKeys("20" + Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement shapjpeg = eg.sharpimg();
		shapjpeg.sendKeys("150" + Keys.ENTER);
		Thread.sleep(2000);
		
		WebElement adjustup = eg.adjustdrop();
		adjustup.click();
		
		WebElement vint =eg.vin();
		vint.click();
		
		WebElement vintinten = eg.vininte();
		vintinten.sendKeys("80" + Keys.ENTER);
		
		WebElement effectopt = eg.effectfea();
		effectopt.click();
		Thread.sleep(3000);
		
		WebElement flashcl = eg.flasheff();
		flashcl.click();
		
		WebElement flashsel = eg.flashapp();
		flashsel.click();
		Thread.sleep(2000);
		
		WebElement foodcl = eg.foodeff();
		foodcl.click();
		
		WebElement foodsel = eg.foodapp();
		foodsel.click();
		
		WebElement textopt = eg.textfea();
		textopt.click();
		Thread.sleep(4000);
		
		WebElement textsel = eg.textapp();
		textsel.click();
		
		WebElement framesopt = eg.framesfea();
		framesopt.click();
		Thread.sleep(2000);
		
		WebElement vinframe = eg.vintagefram();
		vinframe.click();
		Thread.sleep(3000);
		
		WebElement mousehover = eg.mousevint();
		Actions mh = new Actions(driver);
		mh.moveToElement(mousehover).perform();
		
		WebElement clickvintfrm = eg.clickvint();
		clickvintfrm.click();
		
		WebElement applvintagefr = eg.applyframevint();
		applvintagefr.click();
		
		WebElement vintedrop = eg.vintdrop();
		vintedrop.click();
		
		WebElement orgfea = eg.organicfea();
		orgfea.click();
		Thread.sleep(2000);
		
		WebElement selectframe = eg.selectfirst();
		selectframe.click();
		
		WebElement selectbl = eg.selectblack();
		selectbl.click();
		
		WebElement applyframe = eg.clickapply();
		applyframe.click();
		
		WebElement clickframedrop = eg.seledrop();
		clickframedrop.click();
		
	}
	@AfterTest
	public void closebrowser() {
		driver.close();
	}

}
