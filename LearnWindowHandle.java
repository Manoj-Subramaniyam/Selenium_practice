package week2;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class LearnWindowHandle {
	@Test
	public void windowHandles() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.leafground.com");
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		String currentWindow= driver.getWindowHandle();
		driver.findElement(By.xpath("//h5[text()='Click and Confirm new Window Opens']/following-sibling::button")).click();
		Set<String> numOfWindows= driver.getWindowHandles();
		List<String>numOfWindowsList= new ArrayList<String>(numOfWindows);
		//System.out.println(numOfWindowsList.get(1));
		driver.switchTo().window(numOfWindowsList.get(1));
		
		driver.switchTo().window(currentWindow);
		driver.findElement(By.xpath("//h5[text()='Close all windows except Primary']/following-sibling::button")).click();
		numOfWindows= driver.getWindowHandles();
		numOfWindowsList= new ArrayList<String>(numOfWindows);
		for(String window:numOfWindowsList)
		{
			if(!window.equals(currentWindow))
			{
				driver.switchTo().window(window);
				if(!driver.getTitle().equals("Dashboard")) {
					
					driver.close();
					}
			}
		}
		driver.switchTo().window(currentWindow);
		driver.findElement(By.xpath("//h5[text()='Find the number of opened tabs']/following-sibling::button")).click();
		numOfWindows= driver.getWindowHandles();
		numOfWindowsList= new ArrayList<String>(numOfWindows);
		for(String window:numOfWindowsList)
		{
			if(!window.equals(currentWindow))
			{
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//h5[text()='Wait for 2 new tabs to open']/following-sibling::button")).click();
		numOfWindows= driver.getWindowHandles();
		numOfWindowsList= new ArrayList<String>(numOfWindows);
		for(String window:numOfWindowsList)
		{
			if(!window.equals(currentWindow))
			{
				driver.switchTo().window(window);
				System.out.println(driver.getTitle());
				driver.close();
			}
		}
		
		
		driver.quit();
		
	}

}
