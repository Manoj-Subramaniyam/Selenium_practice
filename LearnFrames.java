package week2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class LearnFrames {
		
	@Test
		public void frames() throws InterruptedException
		{
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.leafground.com");
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Frame']")).click();
		Thread.sleep(5000);
		List<WebElement>framesList=driver.findElements(By.tagName("iframe"));
		System.out.println("Number of Frames in the Page: "+framesList.size());
		
		driver.switchTo().frame(0);
		driver.findElement(By.id("Click")).click();
		System.out.println("Frame1:"+driver.findElement(By.id("Click")).getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame(2).switchTo().frame("frame2");
		driver.findElement(By.id("Click")).click();
		System.out.println("Frame2:"+driver.findElement(By.id("Click")).getText());
		driver.switchTo().defaultContent();
		driver.quit();
		}
}
