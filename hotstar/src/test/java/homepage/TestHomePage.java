package homepage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import commanUtils.ConfigFileReader;
import hotstarPageObjects.HomePage;

public class TestHomePage {
	static WebDriver driver;

	hotstarPageObjects.HomePage HomePage;

	@BeforeClass
	public void beforeClass() {
	}

	@BeforeMethod
	public void beforeMethod() throws FileNotFoundException, IOException, InterruptedException {
		String exePath = "C:\\Users\\spoojan\\eclipse-workspace1\\shiv.project\\src\\main\\resources\\chrome\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", exePath);
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ConfigFileReader conf = new ConfigFileReader();
		String url = conf.getReportConfigPath("conf.properties", "url");
		System.out.println(url);

		driver.get(url);
		driver.manage().window().maximize();
		Thread.sleep(10000);

		HomePage = PageFactory.initElements(driver, HomePage.class);
	}

	@Test
	public void f() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;

		String xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[32]/div/div/div/div[1]/div/h2/a";
		while (!isElementPresent(By.xpath(xpath))) {
			driver.switchTo().activeElement().sendKeys(Keys.PAGE_DOWN);
			Thread.sleep(500);
		}
		String text = driver.findElement(By.xpath(xpath)).getText();
		System.out.println("text::" + text);

		List<WebElement> traysLink = HomePage.trayTitles;
		for (WebElement element : traysLink) {
			Thread.sleep(500);
			String textpopular = element.getText();
			if (textpopular.contains("Popular")) {
				System.out.println(textpopular);
				System.out.println("***");
			}
		}
	}

	public boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

	@AfterClass
	public void afterClass() {
	}

}
