package fotor;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditImageStepDeff {
	WebDriver driver = null;
	@Before public void setUp() {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Given("user should be navigated to fotor editor page")
	public void user_should_be_navigated_to_fotor_editor_page() throws InterruptedException {
	    driver.navigate().to("https://www.fotor.com/photo-editor-app/editor/cloud");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	    //driver.switchTo().alert().dismiss();
	    driver.findElement(By.xpath("//span[@class='ScriptModal-module_modal__close__2Ixsi']")).click();
	}

	@When("user clicks on signin button")
	public void user_clicks_on_sign_in_button() {
		driver.findElement(By.xpath("//div[contains(text(),'Sign in')]")).click();
	    
	}

	@And("^user Enters valid (.*) and (.*) and login$")
	public void user_enters_valid_username_and_password_and_login(String username, String password) {
		driver.findElement(By.xpath("//div[@class='inputBox']//input[@type='text']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys(password);
		driver.findElement(By.xpath("//div[contains(text(),'Sign In')]")).click();
	    
	}

	@Then("user navigated to editor page")
	public void user_navigated_to_editor_page() {
		 String title = driver.getTitle();
		 Assert.assertEquals(title,driver.getTitle());
		 System.out.println(driver.getTitle());
	}
	
	@When("user uploads image")
	public void user_uploads_image() throws InterruptedException {
		//driver.findElement(By.xpath("")).sendKeys("‪D:\\1\\20201227_154430.jpg");
		driver.findElement(By.xpath("//body/div[@id='app']/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/img[1]")).click();
		Thread.sleep(2000);
	}

	@And("user should able to edit image by adjust features")
	public void user_should_able_to_edit_image_by_adjust_features() throws InterruptedException {
		//Adjust
		driver.findElement(By.xpath("//div[@id='leftSidebarBtn_basic']")).click();
		driver.findElement(By.xpath("//span[@class='_2rOgo']//span[contains(text(),'Crop')]")).click();
		driver.findElement(By.xpath("//span[contains(text(),'9 x 16')]")).click();
		driver.findElement(By.xpath("//div[@class='_11tGr _1KSz-']//button[@class='_3Mu_A _2Enu8 fd04j']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Basic Adjust')]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/input")).sendKeys("20" + Keys.ENTER);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/input")).sendKeys("33" + Keys.ENTER);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/input")).sendKeys("20" + Keys.ENTER);
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[4]/div[1]/div[2]/input")).sendKeys("150" + Keys.ENTER);
	    driver.findElement(By.xpath("//span[contains(text(),'Basic Adjust')]")).click();
	}
	
	@And("user should able to edit image by vintage feature")
	public void user_should_able_to_edit_image_by_vintage_feature(){
	    //vintage
	    driver.findElement(By.xpath("//span[@class='_2rOgo']//span[contains(text(),'Vignette')]")).click();
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[2]/input")).sendKeys("80" + Keys.ENTER);
	}
	
	@And("user should able to apply effects to image")
	public void user_should_able_to_apply_effects_to_image() throws InterruptedException{
	    //Effects
		driver.findElement(By.xpath("//div[@id='leftSidebarBtn_effect']")).click();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//div[@class='effect_list_btn']//div[@class='_11tGr']//button[@class='_3Mu_A _2Enu8 fd04j']")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Flash')]")).click();
	    driver.findElement(By.xpath("//div[@class='effect_list_btn']//div[@class='_11tGr']//button[@class='_3Mu_A _2Enu8 fd04j']")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//span[contains(text(),'Food')]")).click();
	    driver.findElement(By.xpath("//div[@class='effect_list_btn']//div[@class='_11tGr']//button[@class='_3Mu_A _2Enu8 fd04j']")).click();
	}
	
	@And("user should able to add text on image")
	public void user_should_able_to_add_text_on_image() throws InterruptedException{
	    //Text
	    driver.findElement(By.xpath("//div[@id='leftSidebarBtn_text']//*[@id='图层_1']")).click();
	    //driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//div[@class='_3g_af']")).click();
	}
	
	@And("user should be able to add frames to image")
	public void user_should_be_able_to_add_frames_to_image() throws InterruptedException{
	    //Frames
	    driver.findElement(By.xpath("//span[contains(text(),'Frames')]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("(//span[.='Vintage'])[1]")).click();
	    Thread.sleep(3000);
	    Actions a = new Actions(driver);
        a.moveToElement(driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[3]/div[1]/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div/div/div"))).perform();
	    driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[3]/div[1]/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div/div/div")).click();
	    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")).click();
	    driver.findElement(By.xpath("(//span[.='Vintage'])[1]")).click();
	    //Frames2
	    driver.findElement(By.xpath("//span[contains(text(),'Organic')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")).click();
	    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[11]/span[1]")).click();
	    driver.findElement(By.xpath("/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")).click();
	    driver.findElement(By.xpath("//span[contains(text(),'Organic')]")).click();
	    Thread.sleep(4000);
	}
	@After public void Browserclose() {
		driver.quit();
	}
}

