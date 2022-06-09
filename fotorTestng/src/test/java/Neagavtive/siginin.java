package Neagavtive;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class siginin {
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailText;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passText;
	@FindBy(xpath = "(//div[.='Sign In'])[2]")
	private WebElement loginButton;
	@FindBy(xpath = "//p[contains(text(),'Account or password is invalid')]")
	private WebElement error;
	public siginin(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setLogin(String email, String pass) {
		signInButton.click();
		emailText.sendKeys(email);
		passText.sendKeys(pass);
		loginButton.click();
	}
	public WebElement error() {
		return error;
	}

}
