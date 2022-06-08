package saveimages;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SaveImageStepDeff {
	WebDriver driver = null;
	String parent;
	@Before public void BrowserOpen() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new  ChromeDriver();
	}
	
	@Given("navigated to fotor page")
	public void navigated_to_fotor_page() {
		driver.navigate().to("https://www.fotor.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("user clicks on the signIn button")
	public void user_clicks_on_the_sign_in_button() {
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
	}

	@When("^user enters (.*) and (.*) and loggedin$")
	public void user_enters_email_and_password_and_loggedin(String email, String pass) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(pass);
		driver.findElement(By.xpath("(//div[.='Sign In'])[2]")).click();
		//	driver.findElement(By.xpath("//button[.='Next']")).click();
		//	driver.findElement(By.xpath("//div[@class='App-module_modal__close__XxqCy']")).click();
	}

	@And("clicks on Help")
	public void clicks_on_help() throws InterruptedException {
		parent = driver.getWindowHandle();
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("//div[contains(@class,'SideCommon_sidebarBottom__btn')]"))).perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[.='Help Center']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='hero-inner']")).sendKeys("Tutorial");
		driver.switchTo().window(parent);
		System.out.println("Page title of new tab: " + driver.getTitle());
	}
	
	@Then("switch back to homePage")
	public void switch_back_to_home_page() {
		Assert.assertEquals(driver.getTitle(), "Home - Fotor");
	}
	
	@And("clicks on My Project")
	public void clicks_on_my_project() {
		driver.findElement(By.xpath("//*[@id=\"Sider\"]/div/a[3]")).click();
	}

	@Then("download edited Photo")
	public void download_edited_photo() throws InterruptedException {
		Actions a1 = new Actions(driver);
		a1.moveToElement(driver.findElement(By.xpath("//*[@id=\"layoutWrap\"]/div/div/div[2]/div/div/div[1]/a/img"))).perform();
		driver.findElement(By.xpath("//*[@id=\"layoutWrap\"]/div/div/div[2]/div/div/div[1]/button[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div/div[2]/div/div[2]/div/div[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div[8]/div/div/div/div/div/div[3]/button")).click();
	}
	@After public void Browserclose() {
		driver.quit();
	}
}