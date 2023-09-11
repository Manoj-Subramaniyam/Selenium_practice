package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Individuals_without_mandatory_fields {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");

driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
driver.findElement(By.id("password")).sendKeys("India$321");
driver.findElement(By.name("Login")).click();
Thread.sleep(20000);
WebDriverWait wait=new WebDriverWait(driver, 20);
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='slds-icon-waffle']")));
driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='View All']")));
driver.findElement(By.xpath("//*[text()='View All']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='slds-input'][@placeholder='Search apps or items...']")));
driver.findElement(By.xpath("//input[@class='slds-input'][@placeholder='Search apps or items...']")).sendKeys("individuals");
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='slds-truncate']")));
driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='navItem slds-is-unsaved slds-context-bar__item slds-shrink-none slds-is-active']//child::div")));
//driver.findElement(By.xpath("//*[text()=\"Individuals Menu\"]/parent::a")).click();
driver.findElement(By.xpath("//*[@class='navItem slds-is-unsaved slds-context-bar__item slds-shrink-none slds-is-active']//child::div")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='New Individual']")));
WebElement click= driver.findElement(By.xpath("//span[text()='New Individual']"));
Actions act = new Actions(driver);
act.click(click).build().perform();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@placeholder='Last Name']")));
driver.findElement(By.xpath("//div[contains(@class,'salutation compound')]")).click();

driver.findElement(By.xpath("//a[@title='Mr.']")).click();
driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ganesh");

//driver.findElement(By.xpath("//*[@title='Save']")).click();
if (driver.findElement(By.xpath("//li[@class='form-element__help']")).isDisplayed())
	System.out.println("Displayed");
else
	System.out.println("Failed");


	}

}
