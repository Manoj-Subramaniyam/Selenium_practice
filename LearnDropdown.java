package week4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LearnDropdown {
	@Test
	public void dropdown() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/");
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Dropdown']")).click();
		Select option= new Select( driver.findElement(By.xpath("//h5[contains(text(),'Which')]/following::select")));
		option.selectByIndex(1);
		driver.findElement(By.xpath("//h5[contains(text(),'Choose')]/following-sibling::div")).click();
		List<WebElement> l1=driver.findElements(By.xpath("//div[@class='ui-selectonemenu-items-wrapper']/ul/li"));
		
		for(int i=0;i<l1.size();i++)
		{
			if(l1.get(i).getText().equals("India"))
				l1.get(i).click();
			
		}
		
		//option.selectByIndex(1);
		
		//option = new Select(driver.findElement(By.xpath("//h5[contains(text(),'Confirm')]/following::select")));
		//option.selectByVisibleText("Bengaluru");
		
		Thread.sleep(2000);
		driver.close();
	}

}
