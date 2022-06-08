package signup;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import au.com.bytecode.opencsv.CSVReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SingUpStepDeff {
	WebDriver driver=null;
	@Before public void open() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@Given("navigated to fotor url")
	public void navigated_to_fotor_url() {
		driver.get("https://www.fotor.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@When("user should click on signup link and select signup with google")
	public void user_should_click_on_signup_link_and_select_signup_with_google() {
		driver.findElement(By.xpath("//button[text()='Sign in']")).click(); 
		driver.findElement(By.xpath("//span[.='Sign Up']")).click();
		driver.findElement(By.xpath("(//div[.='Sign up with email'])[2]")).click();
	}
	@When("user should enter emailId and password")
	public void user_should_enter_email_id_and_password() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("C:\\Users\\kushal\\eclipse-workspace\\Sprint2petstore\\fotor\\Externalfile\\signUp.csv"));
		List<String[]> li = reader.readAll();
		System.out.println("Total number of rows"+li.size());
		Iterator<String[]>i1=li.iterator();
		while(i1.hasNext()){
			String[] str=i1.next();
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(str[0]);
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys(str[1]);
			driver.findElement(By.xpath("//div[@class='checkBox checkBoxSignUp ']")).click();
			driver.findElement(By.xpath("//div[text()='Sign Up']")).click();
		}
	}

	@Then("user should navigated to HomePage")
	public void user_should_navigated_to_home_page() {
		WebElement error = driver.findElement(By.xpath("//p[.='This email is already registed!']"));
		if(error.isDisplayed()==true) {
			Assert.assertEquals("This email is already registed!",error.getText());
			System.out.println("This error is displayed "+error.getText());
		}
	}
	@After public void close() {
		driver.close();
	}
}

