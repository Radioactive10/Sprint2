package SaveImages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	String parent;
	@FindBy(xpath = "//div[contains(@class,'SideCommon_sidebarBottom__btn')]")
	private WebElement moreMouse;
	@FindBy(xpath = "//span[.='Help Center']")
	private WebElement helpButton;
	@FindBy(xpath = "/html/body/div[1]/div[1]/aside/div/aside/div/a[3]")
	private WebElement myProject;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/a/img")
	private WebElement imageMouse;
	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div/div[2]/div/div/div[1]/button[1]")
	private WebElement dotsOnimage;
	@FindBy(xpath = "//span[text()='Download']")
	private WebElement downloadButton;
	@FindBy(xpath = "//span[text()='Done']")
	private WebElement successDownload;
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	public WebElement moveMouseToMore() {
		return moreMouse;
	}
	public WebElement ClickOnHelp() {
		return helpButton;
	}
	public WebElement ClickOnMyproject() {
		return myProject;
	}
	public WebElement moveMouseToImage() {
		return imageMouse;
	}
	public WebElement ClickOnDotsOnImage() {
		return dotsOnimage;
	}
	public WebElement ClickOnDownloadButton() {
		return downloadButton;
	}
	public WebElement ClickOnSuccessDownload() {
		return successDownload;
	}
	

}
