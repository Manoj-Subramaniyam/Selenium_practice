package week4;


import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LearnCheckBox {
	
	@Test
	public void checkBox() throws InterruptedException
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
		driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
		//ele= driver.findElement(By.xpath("//div[@role='alert']/div/span"));
		
		if(driver.findElement(By.xpath("//div[@role='alert']/div/span")).isDisplayed()) {
			System.out.println("pop up displayed");
			System.out.println(driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText());
			driver.findElement(By.xpath("//span[text()='Ajax']/preceding-sibling::div[1]")).click();
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Unchecked']")));
			System.out.println( driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText());
			
			}
		List<WebElement>lstOfWebElements= new ArrayList<WebElement>(driver.findElements(By.xpath("//h5[text()='Choose your favorite language(s)']/following-sibling::div//tr/td")));
		for(WebElement temp:lstOfWebElements)
		{
			temp.click();
		}
		
		ele=driver.findElement(By.xpath("//h5[text()='Tri State Checkbox']/following-sibling::div//div[contains(@class,'ui-chkbox-box')]"));
		ele.click();
		System.out.println(driver.findElement(By.xpath("(//div[@role='alert']/div/p)[2]")).getText());
		
		ele.click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//p[text()='State = 1']"))));
		System.out.println(driver.findElement(By.xpath("(//div[@role='alert']/div/p)[2]")).getText());
		
		ele.click();
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//p[text()='State = 2']"))));
		
		System.out.println(driver.findElement(By.xpath("(//div[@role='alert']/div/p)[2]")).getText());
		driver.findElement(By.xpath("//h5[text()='Toggle Switch']/following-sibling::div/div[2]")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.xpath("//div[@role='alert']/div/span")).getText());
		
		if(!driver.findElement(By.xpath("//span[text()='Disabled']/preceding-sibling::div/input")).isEnabled())
			System.out.println("checkbox disabled");
		Thread.sleep(3000);
		driver.close();
	}

}
