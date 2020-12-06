package Steps;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.google.common.io.Files;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hook {
	public static Duration ExplicitWaitTimeOutUnit = Duration.ofSeconds(10);
	public static WebDriver driver;

	@Before
	public void startSetUp() {

		System.setProperty("webdriver.chrome.silentOutput", "true");
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("enable-automation");
		//options.addArguments("--headless");
		options.addArguments("--window-size=1920,1080");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-extensions");
		options.addArguments("--dns-prefetch-disable");
		options.addArguments("--disable-gpu");
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		options.addArguments("enable-features=NetworkServiceInProcess");
		options.addArguments("disable-features=NetworkService");
		driver = new ChromeDriver(options);
		driver.manage().window().setSize(new Dimension(1200, 800));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		File folder = new File(System.getProperty("user.dir") + "/FailedScreenshots/");
		//for (File f : folder.listFiles()) {
		//	if (f.getName().endsWith(".png")) {
		//		f.delete();
		//	}
		// }
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed() == true) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			try {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File sourcePath = ts.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "/FailedScreenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
			} catch (IOException e) {
			}
		}
		driver.close();
		driver = null;

	}

	public static WebDriver getDriver() {
		return driver;
	}

}
