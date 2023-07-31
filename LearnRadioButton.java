package week4;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class LearnRadioButton {
		@Test
		public void radioButton() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.get("https://www.leafground.com/");
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//form[@id='menuform']/ul/li[3]")).click();
			driver.findElement(By.id("menuform:m_radio")).click();
			driver.findElement(By.xpath("//label[text()='Chrome']")).click();
			
			if(driver.findElement(By.xpath("//label[text()='Chrome']/preceding-sibling::div/div/input")).isSelected())
				System.out.println("Chrome is selected");
			
			Thread.sleep(3000);
			driver.close();
;			
		}
}
