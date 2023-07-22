package week4;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LearnCheckBox {
	
	@Test
	public void checkBox() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//a[contains(@href,'/checkbox.xhtml')]")).click();
		WebElement ele=driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[2]/input"));
		driver.findElement(By.xpath("//span[text()='Basic']/preceding-sibling::div[1]")).click();
		if(ele.isSelected())
			System.out.println("clicked");
		driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
		ele= driver.findElement(By.xpath("//div[@role='alert']/div/span"));
		
		if(ele.isDisplayed()) {
			System.out.println("pop up displayed");
			System.out.println(ele.getText());
			driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
			//Thread.sleep(5000);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Unchecked']")));
			ele= driver.findElement(By.xpath("//span[text()='Unchecked']"));
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
			System.out.println(ele.getText());
			}
		
		driver.close();
	}

}
