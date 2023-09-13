package day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Verify_Individuals_sort_order_by_Name {

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
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//th[@title='Name']//child::a[contains(@class,'toggle')]")));

Thread.sleep(5000);
JavascriptExecutor java1= (JavascriptExecutor)driver;
java1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
Thread.sleep(5000);
driver.findElement(By.xpath("//th[@title='Name']//child::a[contains(@class,'toggle')]")).click();
Thread.sleep(5000);
wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/th//a")));
List<WebElement> l1=driver.findElements(By.xpath("//tbody/tr"));
//int k=l1.size();
String s;
for (int i = 1; i <= l1.size(); i++) {
	s=driver.findElement(By.xpath("//tbody/tr["+i+"]/th//a")).getAttribute("title");
	System.out.println(s);
			
}

	}

}
