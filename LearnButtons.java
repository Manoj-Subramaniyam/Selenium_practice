package week3;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
public class LearnButtons {

	@Test
	public void buttons() throws InterruptedException 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.)
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Button']")).click();
		driver.findElement(By.xpath("//h5[contains(text(),'Click and')]/following-sibling::button")).click();
		
		if(driver.getTitle().equals("Dashboard"))
				System.out.println("In Dashboard");
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Button']")).click();
		if(!driver.findElement(By.xpath("//h5[contains(text(),'Confirm if')]/following-sibling::button")).isEnabled())
			System.out.println("Button is Disabled");
		Point p=driver.findElement(By.xpath("//h5[contains(text(),'Find the position')]/following-sibling::button")).getLocation();
		System.out.println(p);
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'Find the Save')]/following-sibling::button")).getCssValue("background-color"));
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'Find the height')]/following-sibling::button")).getSize());
		Actions builder = new Actions(driver);
		builder.moveToElement(driver.findElement(By.xpath("//h5[contains(text(),'Mouse')]/following-sibling::button"))).perform();
		System.out.println(driver.findElement(By.xpath("//h5[contains(text(),'Mouse')]/following-sibling::button/span")).getCssValue("background-color"));
		driver.findElement(By.xpath("//h5[contains(text(),'Click Image Button')]/following::button")).click();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//span[contains(text(),'Primary')]")));
		
		driver.close();
	}
}
