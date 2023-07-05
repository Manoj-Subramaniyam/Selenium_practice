package week2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class LearnAlerts {
	

	@Test
	public void simplealerts() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.leafground.com");
		driver.findElement(By.xpath("//form[@id='menuform']/ul/li[2]")).click();
		driver.findElement(By.xpath("//span[text()='Alert']")).click();
		driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following-sibling::button")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//h5[text()=' Alert (Simple Dialog)']/following-sibling::span")).getText());
		
		//Alert accept and cancel
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button")).click();
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::span")).getText());
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::button")).click();
		System.out.println(alert.getText());
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//h5[text()=' Alert (Confirm Dialog)']/following-sibling::span")).getText());
		
		//Alert  input text
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button")).click();
		alert.sendKeys("Test");
		alert.accept();
		System.out.println(driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::span")).getText());
		
		driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::button")).click();
		alert.dismiss();
		System.out.println(driver.findElement(By.xpath("//h5[text()=' Alert (Prompt Dialog)']/following-sibling::span")).getText());
		
	//Sweet alert simple
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following::button[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Simple Dialog)']/following::button[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Dialog']/following::a[1]")).click();
		
	//sweet alert confirmation
		
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following::button[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='Yes']")).click();
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following::button[1]")).click();
		
		driver.findElement(By.xpath("//span[text()='No']")).click();
		driver.findElement(By.xpath("//h5[text()='Sweet Alert (Confirmation)']/following::button[1]")).click();
		driver.findElement(By.xpath("//span[text()='Confirmation']/following::span[1]")).click();
		
		
		driver.quit();
		
		
		
	}
}
