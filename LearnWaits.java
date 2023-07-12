package week3;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class LearnWaits {
	@Test
	public void waits()
{
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.leafground.com/");
	driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
	driver.findElement(By.xpath("//span[text()='Waits']")).click();
	driver.findElement(By.xpath("//h5[contains(text(),'Wait for Visibility')]/following::button[1]")).click();
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	WebElement ele=driver.findElement(By.xpath("//*[contains(text(),'I am here')]"));
	wait.until(ExpectedConditions.visibilityOf(ele));
	
	if(ele.isDisplayed()) System.out.println("element is Visible");
		
		
}
}
