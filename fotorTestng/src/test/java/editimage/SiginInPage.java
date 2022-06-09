package editimage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginInPage {
	@FindBy(xpath ="//span[@class='ScriptModal-module_modal__close__2Ixsi']")
	private WebElement popup;
	@FindBy(xpath ="//div[contains(text(),'Sign in')]")
	private WebElement SignInlink;
	@FindBy(xpath ="//div[@class='inputBox']//input[@type='text']")
	private WebElement email;
	@FindBy(xpath ="//input[@type='password']")
	private WebElement password;
	@FindBy(xpath="//div[contains(text(),'Sign In')]")
	private WebElement SignInButton;
	
	public SiginInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void signin(String username, String pass)
	{
		popup.click();
		SignInlink.click();
		email.sendKeys(username);
		password.sendKeys(pass);
		SignInButton.click();
	}
	
}
