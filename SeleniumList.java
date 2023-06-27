package week2;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.Test;
public class SeleniumList {

	@Test
	public void getNumberofLinks() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.get("https://www.leafground.com");
		driver.findElement(By.xpath("//form[@id='menuform']/ul/li[3]")).click();
		
		driver.findElement(By.xpath("//span[text()='Hyper Link']")).click();
		List<WebElement> noOfLinks=driver.findElements(By.tagName("a"));
		System.out.println(noOfLinks.size());
		
		driver.quit();
		
		

	}
}
