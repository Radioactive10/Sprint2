package langauage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homelangua {
	String parent;
	@FindBy(xpath = "//div[contains(@class,'SideCommon_sidebarBottom__btn')]")
	private WebElement moreMouse;
	@FindBy(xpath = "//span[contains(text(),'Language')]")
	private WebElement lanButton;
	@FindBy(xpath = "//p[contains(text(),'Japanese')]")
	private WebElement japne;
	
	public homelangua(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement moveMouseToMore() {
		return moreMouse;
	}
	public WebElement ClickOnlang() {
		return lanButton;
	
	}
	public WebElement ClickOnjapne() {
		return japne;
	}
	

}
