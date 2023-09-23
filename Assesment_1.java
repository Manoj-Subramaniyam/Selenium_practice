package day1_Assesment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assesment_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		ChromeOptions options= new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("saturn@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Bootcamp$123");
		driver.findElement(By.name("Login")).click();
		WebDriverWait wait= new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'slds-icon-waffle')]")));
		driver.findElement(By.xpath("//div[contains(@class,'slds-icon-waffle')]")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'View')]")));
		driver.findElement(By.xpath("//input[contains(@placeholder,'Search apps')]")).sendKeys("Sales");
		
		
		//

	}

}
