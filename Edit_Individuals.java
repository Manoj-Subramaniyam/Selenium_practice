package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Edit_Individuals {

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

WebDriverWait wait=new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='slds-icon-waffle']")));
driver.findElement(By.xpath("//*[@class='slds-icon-waffle']")).click();
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='View All']")));
driver.findElement(By.xpath("//*[text()='View All']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='slds-input'][@placeholder='Search apps or items...']")));
driver.findElement(By.xpath("//input[@class='slds-input'][@placeholder='Search apps or items...']")).sendKeys("individuals");
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[@class='slds-truncate']")));
driver.findElement(By.xpath("//p[@class='slds-truncate']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@name='Individual-search-input']")));
driver.findElement(By.xpath("//*[@name='Individual-search-input']")).sendKeys("Kumar"+ Keys.ENTER);
//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='listViewContent slds-table--header-fixed_container']//tbody/tr[1]/td[6]//div']")));
//driver.findElement(By.xpath("//div[@class='listViewContent slds-table--header-fixed_container']//tbody/tr[1]/td[6]//div]")).click();
//Thread.sleep(10000);
WebElement element= driver.findElement(By.xpath("//div[@class='listViewContent slds-table--header-fixed_container']//tbody/tr[1]/td[6]//div"));

JavascriptExecutor executor = (JavascriptExecutor)driver;
executor.executeScript("arguments[0].click();", element);
//Actions act = new Actions(driver);
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'visible positioned')]//a[@title='Edit']")));

driver.findElement(By.xpath("//div[contains(@class,'visible positioned')]//a[@title='Edit']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'salutation compound')]")));

driver.findElement(By.xpath("//div[contains(@class,'salutation compound')]")).click();

driver.findElement(By.xpath("//a[@title='Mr.']")).click();
driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Ganesh");

driver.findElement(By.xpath("//*[@title='Save']")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'slds-theme')]")));
if(driver.findElement(By.xpath("//div[contains(@class,'slds-theme')]")).isDisplayed())
	System.out.println("Edited Successfully");
	else
		System.out.println("Failed");

//button[contains(@class,'slds-button slds-button_icon toastClose')]
Thread.sleep(5000);
driver.close();
	}
	

}
