package SignUp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	@FindBy(xpath = "//button[text()='Sign in']")
	private WebElement signInButton;
	@FindBy(xpath = "//span[text()='Sign Up']")
	private WebElement signUpButton;
	@FindBy(xpath = "(//div[.='Sign up with email'])[2]")
	private WebElement signUpwithEmailButton;
	@FindBy(xpath = "//input[@type='text']")
	private WebElement emailText;
	@FindBy(xpath = "//input[@type='password']")
	private WebElement passText;
	@FindBy(xpath = "//div[@class='checkBox checkBoxSignUp ']")
	private WebElement checkBox;
	@FindBy(xpath = "//div[text()='Sign Up']")
	private WebElement signingUpButton;
	@FindBy(xpath = "//p[.='This email is already registed!']")
	private WebElement errorText;

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public void setLogin(String email, String pass) {
		signInButton.click();
		signUpButton.click();
		signUpwithEmailButton.click();
		emailText.sendKeys(email);
		passText.sendKeys(pass);
		checkBox.click();
		signingUpButton.click();
	}
	public WebElement ErrorIsAppeared() {
		return errorText;
	}
	

}
