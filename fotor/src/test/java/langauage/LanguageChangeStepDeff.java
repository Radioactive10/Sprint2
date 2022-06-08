package langauage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LanguageChangeStepDeff {
	WebDriver driver;

	@Before public void setUp() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	
	@Given("I want to open the url")
	public void i_want_to_open_the_url() {
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("sign in to account")
	public void sign_in_to_account() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/input[1]")).sendKeys("nicot69589@falkyz.com");
		driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/input[1]")).sendKeys("Team@4batch");
		//driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
	}

	@Then("I need to select the language")
	public void i_need_to_select_the_language() throws InterruptedException {
		Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("//body/div[@id='__next']/div[1]/aside[1]/div[1]/div[1]/div[2]"))).perform();
        driver.findElement(By.xpath("//span[contains(text(),'Language')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//p[contains(text(),'Japanese')]")).click();
	}
	
	
}
