package hotstarPageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {
	WebDriver driver;

	@FindBy(how = How.TAG_NAME, using = "a")
	public List<WebElement> traysLink;
	
	@FindBy(how = How.XPATH, using = "//*[@class=\"tray-title\"]/a")
	public List<WebElement> trayTitles;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div/div[2]/div/div[1]/div[1]/p")
	public WebElement connectWithUs;

	@FindBy(how = How.LINK_TEXT, using = "Popular channels")
	public WebElement popularChanel;

	@FindBy(how = How.XPATH, using = "//*[@id=\"app\"]/div/div/div/div[1]/div[2]/div[2]/div/div/div/div[32]/div/div/div/div[1]/div/h2/a")
	public WebElement popularChanel2;
	
	public HomePage(WebDriver driver)

	{

		this.driver = driver;

	}
}
