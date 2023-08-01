package week5;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LearnHyperLink {
	
	WebDriver driver = new ChromeDriver();
	@Test
	public void hyperLink() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/");
		gotoHyperLink();
		driver.findElement(By.linkText("Go to Dashboard")).click();
		gotoHyperLink();
		
		Thread.sleep(3000);
		driver.close();
	}
	public void gotoHyperLink()
	{
		driver.findElement(By.xpath("//form[@id='menuform']/ul/li[3]")).click();
		driver.findElement(By.id("menuform:m_link")).click();
	}
}
