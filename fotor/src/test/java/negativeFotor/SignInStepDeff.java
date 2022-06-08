package negativeFotor;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SignInStepDeff {
	WebDriver driver;
	@Before public void setUp() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	@Given("user want to open launch the url")
	public void user_want_to_open_launch_the_url() {
		driver.get("https://www.fotor.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@And("click on the signin button and select login with google")
	public void click_on_the_signin_button_and_select_login_with_google() {
		driver.findElement(By.xpath("//button[contains(text(),'Sign in')]")).click();
		driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]/input[1]")).sendKeys("nicot69589@falkyz.com");
		driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]/input[1]")).sendKeys("Teambatch");
		//driver.findElement(By.xpath("//body/div[@id='rootLogin']/div[1]/div[1]/div[2]/div[1]/div[1]/div[7]/div[1]/div[1]")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
	}

	@When("user enters invalid credetials error should be displayed")
	public void user_enters_invalid_credetials_error_should_be_displayed() throws InterruptedException {
		//p[contains(text(),'Account or password is invalid')]
		WebElement error = driver.findElement(By.xpath("//p[contains(text(),'Account or password is invalid')]"));
		if(error.isDisplayed()==true) {
			Assert.assertEquals("Account or password is invalid",error.getText());
			System.out.println("This error is displayed "+error.getText());
			Thread.sleep(2000);
		}
	}
	@After
	public void close() {
		driver.close();
	}
}
