package week3;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class LearnTextBox {
	@Test
	public void textBox() {
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.leafground.com/");
	driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
	driver.findElement(By.xpath("//span[text()='Text Box']")).click();
	driver.findElement(By.xpath("//h5[text()='Type your name']/following::input")).sendKeys("Manoj");
	driver.findElement(By.xpath("//h5[contains(text(),'Append Country')]/following::input")).sendKeys(" India");
	boolean bool=driver.findElement(By.xpath("//h5[contains(text(),'Verify if text')]/following::input")).isEnabled();
	System.out.println(bool);
	
	}
}
