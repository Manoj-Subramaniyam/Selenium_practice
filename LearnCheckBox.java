package week4;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LearnCheckBox {
	
	@Test
	public void checkBox()
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
	}

}
