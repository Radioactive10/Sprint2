package editimage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditPage {
	@FindBy(xpath = "//body/div[@id='app']/div[2]/div[4]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/img[1]")
	private WebElement uploadimage;
	@FindBy(xpath = "//div[@id='leftSidebarBtn_basic']")
	private WebElement adjust;
	@FindBy(xpath = "//span[@class='_2rOgo']//span[contains(text(),'Crop')]")
	private WebElement crop;
	@FindBy(xpath = "//span[contains(text(),'9 x 16')]")
	private WebElement cropsize;
	@FindBy(xpath = "//div[@class='_11tGr _1KSz-']//button[@class='_3Mu_A _2Enu8 fd04j']")
	private WebElement cropapply;
	@FindBy(xpath = "//span[contains(text(),'Basic Adjust')]")
	private WebElement basicAdjust;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[1]/div[1]/div[2]/input")
	private WebElement brightness;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[2]/div[1]/div[2]/input")
	private WebElement Contrast;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[3]/div[1]/div[2]/input")
	private WebElement Saturation;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[4]/div[1]/div[2]/div/div/div[4]/div[1]/div[2]/input")
	private WebElement sharpness;
	@FindBy(xpath = "//span[contains(text(),'Basic Adjust')]")
	private WebElement adjustdropdown;
	@FindBy(xpath = "//span[@class='_2rOgo']//span[contains(text(),'Vignette')]")
	private WebElement vintage;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[1]/div[1]/div[5]/div[3]/div[2]/div/div/div/div[1]/div[2]/input")
	private WebElement intensity;
	@FindBy(xpath = "//div[@id='leftSidebarBtn_effect']")
	private WebElement effect;
	@FindBy(xpath = "//span[contains(text(),'Flash')]")
	private WebElement flash;
	@FindBy(xpath = "//div[@class='effect_list_btn']//div[@class='_11tGr']//button[@class='_3Mu_A _2Enu8 fd04j']")
	private WebElement flashapply;
	@FindBy(xpath = "//span[contains(text(),'Food')]")
	private WebElement food;
	@FindBy(xpath = "//div[@class='effect_list_btn']//div[@class='_11tGr']//button[@class='_3Mu_A _2Enu8 fd04j']")
	private WebElement foodapply;
	@FindBy(xpath = "//div[@id='leftSidebarBtn_text']//*[@id='图层_1']")
	private WebElement text;
	@FindBy(xpath = "//div[@class='_3g_af']")
	private WebElement textapply;
	@FindBy(xpath = "//span[contains(text(),'Frames')]")
	private WebElement frames;
	@FindBy(xpath = "(//span[.='Vintage'])[1]")
	private WebElement vintageframes;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[3]/div[1]/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div/div/div")
	private WebElement mousevintage;
	@FindBy(xpath = "/html/body/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div/div[3]/section[3]/div[1]/div[4]/div[2]/div/div/div/div[1]/div[1]/div/div/div/div")
	private WebElement clickvinatage;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[4]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/button[1]")
	private WebElement applyframe;
	@FindBy(xpath = "(//span[.='Vintage'])[1]")
	private WebElement vintagedrop;
	@FindBy(xpath = "//span[contains(text(),'Organic')]")
	private WebElement organic;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
	private WebElement selectframe;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[11]/span[1]")
	private WebElement selectcolor;
	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[2]/div[4]/div[1]/div[1]/div[1]/div[2]/div[1]/div[3]/section[3]/div[1]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/button[1]/span[1]")
	private WebElement selectapply;
	@FindBy(xpath = "//span[contains(text(),'Organic')]")
	private WebElement selectdrop;
	
	public EditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement Upload() {
		return uploadimage;
	}
	
	public WebElement adjustfea() {
		return adjust;
	}
	
	public WebElement cropimg() {
		return  crop;
	}
	
	public WebElement cropresize() {
		return cropsize;
	}
	
	public WebElement cropclick() {
		return cropapply;
	}
	
	public WebElement adjust() {
		return basicAdjust;
	}
	
	public WebElement brighimg() {
		return brightness;
	}
	
	public WebElement contimg() {
		return Contrast;
	}
	
	public WebElement satimg() {
		return Saturation;
	}
	
	public WebElement sharpimg() {
		return sharpness;
	}
	
	public WebElement adjustdrop() {
		return adjustdropdown;
	}
	
	public WebElement vin() {
		return vintage;
	}
	
	public WebElement vininte() {
		return intensity;
	}
	
	public WebElement effectfea() {
		return effect;
	}
	
	public WebElement flasheff() {
		return flash;
	}
	
	public WebElement flashapp() {
		return flashapply;
	}
	
	public WebElement foodeff() {
		return food;
	}
	
	public WebElement foodapp() {
		return foodapply;
	}
	
	public WebElement textfea() {
		return text;
	}
	
	public WebElement textapp() {
		return textapply;
	}
	
	public WebElement framesfea() {
		return frames;
	}
	
	public WebElement vintagefram() {
		return vintageframes;
		
	}
	
	public WebElement mousevint() {
		return mousevintage;
	}
	
	public WebElement clickvint() {
		return clickvinatage;
	}
	
	public WebElement applyframevint() {
		return applyframe;
	}
	
	public WebElement vintdrop() {
		return vintagedrop;
	}
	
	public WebElement organicfea() {
		return organic;
	}
	
	public WebElement selectfirst() {
		return selectframe;
	}
	
	public WebElement selectblack() {
		return selectcolor;
	}
	
	public WebElement clickapply() {
		return selectapply;
	}
	
	public WebElement seledrop() {
		return selectdrop;
	}
	
	
	

}
