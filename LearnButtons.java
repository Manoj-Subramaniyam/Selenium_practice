package week3;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
public class LearnButtons {

	
	public void buttons()
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
		if(driver.findElement(By.xpath("//title")).getText().equals("Dashboard"))
				System.out.println("In Dashboard");
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Button']")).click();
		if(driver.findElement(By.xpath("//h5[contains(text(),'Confirm if')]/following-sibling::button")).isEnabled())
			System.out.println("Button is Disabled");
	}
}
