package SaveImages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailText;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passText;
	@FindBy(xpath = "(//div[.='Sign In'])[2]")
	private WebElement loginButton;
	public SignInPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setLogin(String email, String pass) throws InterruptedException  {
		Thread.sleep(2000);
		signInButton.click();
		emailText.sendKeys(email);
		passText.sendKeys(pass);
		loginButton.click();
	}
	

}
