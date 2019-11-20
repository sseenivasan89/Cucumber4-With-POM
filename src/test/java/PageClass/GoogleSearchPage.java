package PageClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Steps.Hook;

public class GoogleSearchPage {
	WebDriverWait wait;
	public static WebDriver driver;
	

	public GoogleSearchPage() {
		GoogleSearchPage.driver = Hook.getDriver();
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Hook.ExplicitWaitTimeOutUnit);
	}
	
	@FindBy(name = "q")
	WebElement searchBox;
	@FindBy(css = "[name='btnK']")
	WebElement googleSearchButton;
	
	public void LaunchGoogle() {
		driver.get("https://www.google.com");
	}
	public void GoogleSearch() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		searchBox.sendKeys("Test");
		googleSearchButton.click();
	}
}
