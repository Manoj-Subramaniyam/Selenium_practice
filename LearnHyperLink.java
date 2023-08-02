package week5;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

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
		List<WebElement> lstoflinks=driver.findElements(By.xpath("//div[@class='layout-main-content']//a"));
		for(int i=1;i<lstoflinks.size();i++)
		{
			if(lstoflinks.get(i).getAttribute("href").equals(driver.findElement(By.linkText("Go to Dashboard")).getAttribute("href")))
				System.out.println("Duplicated link is : "+lstoflinks.get(i).getAttribute("href"));
		}
		String link=driver.findElement(By.linkText("Find the URL without clicking me.")).getAttribute("href");
		System.out.println(link);
		driver.findElement(By.linkText("How many links in this page?")).click();
		lstoflinks=driver.findElements(By.xpath("//span[@id='form:messages']//parent::div//a"));
		for()
		{
			
		}
		
		gotoHyperLink();
		driver.findElement(By.linkText("Broken?")).click();
		if(driver.findElement(By.xpath("//h2")).getText().contains("404"))
			System.out.println("Link is Broken");
		else
			System.out.println("Link is Not Broken");
		driver.navigate().back();
		
		Thread.sleep(3000);
		driver.close();
	}
	public void gotoHyperLink()
	{
		driver.findElement(By.xpath("//form[@id='menuform']/ul/li[3]")).click();
		driver.findElement(By.id("menuform:m_link")).click();
	}
}
