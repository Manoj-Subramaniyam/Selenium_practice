package week4;

import java.util.ArrayList;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
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
			driver.findElement(By.xpath("//label[text()='Bengaluru']")).click();
			
			if(driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding-sibling::div/div/input")).isSelected())
				System.out.println("Bengaluru is selected");
			driver.findElement(By.xpath("//label[text()='Bengaluru']")).click();
			if(!driver.findElement(By.xpath("//label[text()='Bengaluru']/preceding-sibling::div/div/input")).isSelected())
				System.out.println("Bengaluru is Unselected");
			
			ArrayList<WebElement> lstOfWebElements= new ArrayList<WebElement>(driver.findElements(By.xpath("//h5[contains(text(),'Find')]/following-sibling::div//div/input")));
			int i=0;
			for (WebElement temp: lstOfWebElements)
			{
				i+=1;
				if(temp.isSelected()) {
					
					System.out.println(driver.findElement(By.xpath("(//h5[contains(text(),'Find')]/following-sibling::div//div/input)["+i+"]/following::label")).getText());
				}
					
			}
			Thread.sleep(3000);
			driver.close();
;			
		}
}
