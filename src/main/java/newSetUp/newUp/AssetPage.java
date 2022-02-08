package newSetUp.newUp;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import BaseClass.BaseClass;

public class AssetPage extends BaseClass {

	@FindBy(xpath = "//a[contains(text(),'Assets')]")
	WebElement asset;

	@FindBy(xpath = "//a[@data-test='upload-asset']")
	WebElement uploadButton;

	@FindBy(css = "button.browse-for-files-decoy")
	WebElement browse;

	@FindBy(xpath = "(//div/a[@title='Download asset'])[1]")
	static WebElement download;
	
	@FindBy(xpath = "(//button[@data-test='resource-list-item__dropdown'])[1]")
	static WebElement moreOption;
	
	@FindBy(xpath = "//a[@class='download']")
	static WebElement moreOptionDownload;
	
	@FindBy(xpath = "//a[@class='add manage-projects']")
	static WebElement moreOptionProject;

	@FindBy(xpath = "//table/tbody/tr[1]/td/div/label")
	static WebElement moreOptionSelectProject;
	
	@FindBy(xpath = "//input[@type='submit']")
	static WebElement submit;
	
	@FindBy(xpath = "//li/button[@type='submit']")
	static WebElement submitButton;
	
	
	@FindBy(css="li a.edit")
	static WebElement rename;

	@FindBy(css="input#rename-name")
	static WebElement updateProjectName;

	@FindBy(css="li a.edit-owner")
	static WebElement changeOwner;

	@FindBy(xpath="(//tbody/tr/td/input[@class=\"change-owner-radio\"])[1]")
	static WebElement selectRadioButton;
	
	@FindBy(css="div a.hide-msg")
	static WebElement deleteMessage;
	
		
	static By projectTitle=By.xpath("//form/h2[contains(text(),'Add assets to project(s)')]");
	static By changeOwnerDilaogbox=By.xpath("//div/h2[contains(text(),'Change Owner of Asset')]");
	static By projectAddSuccessMessage=By.cssSelector("div.msg");
	static By removeMessage=By.cssSelector("div a.hide-msg");
	
	static Actions actions = new Actions(driver);
	
	
	static WebDriverWait wait = new WebDriverWait(driver, 130);
	
	public AssetPage() {
		PageFactory.initElements(driver, this);
	}

	public void assetPage() {
		asset.click();

	}

	public static WebDriver windowHandle(int i) {
		
		List<String> list = new ArrayList<String>(driver.getWindowHandles());
		return driver.switchTo().window(list.get(i));
	}

	public void uploadFile() throws AWTException, InterruptedException {
		uploadButton.click();
		
		int tabNumber=1;
		AssetPage.windowHandle(tabNumber);
		
		Thread.sleep(5000);
		browse.click();
		System.out.print("click on browse");

		String assetLocation=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\VMware-Tools-Linux-10.3.1-9925305 (1) (2) (1) (1).iso";
		StringSelection sec = new StringSelection(assetLocation);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sec, null);

		Robot rb = new Robot();
		Thread.sleep(5000);

		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		

		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

		WebDriverWait wait = new WebDriverWait(driver, 1060);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@data-test='upload-files']")));
		driver.findElement(By.xpath("//button[@data-test='upload-files']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[contains(text(),'Completed')]")));
		String a = driver.findElement(By.xpath("//strong[contains(text(),'Completed')]")).getCssValue("font-colour");
		System.out.print(a);
	}	

	public static void downloadFile()
	{
		
		download.click();
		
	}
	
	public static void moreOptionDD() throws InterruptedException
	{
		moreOption.click();
		moreOptionDownload.click();
		moreOptionProject.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(projectTitle));
		
		
		moreOptionSelectProject.click();
		submit.click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(removeMessage));
		
		actions.moveToElement(deleteMessage).click().perform();
		
		Thread.sleep(6000);
		moreOption.click();
		rename.click();		
		updateProjectName.sendKeys("Taste the best");
		submit.click();
	
		actions.moveToElement(deleteMessage).click().perform();
		
		actions.moveToElement(moreOption).click().perform();
		changeOwner.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(changeOwnerDilaogbox));
		selectRadioButton.click();
		submitButton.click();
		
		
	}
}
