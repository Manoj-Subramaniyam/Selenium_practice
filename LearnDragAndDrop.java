package week3;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class LearnDragAndDrop {
	
	@Test
	public void DragandDrop()
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.leafground.com");
		driver.findElement(By.xpath("//form[@id='menuform']/ul/li[2]")).click();
		driver.findElement(By.xpath("//span[text()='Drag']")).click();
		Point postion= driver.findElement(By.xpath("//div[@id='form:conpnl']")).getLocation();
		System.out.println(postion);
		Actions builder= new Actions(driver);
		
		builder.dragAndDropBy(driver.findElement(By.xpath("//div[@id='form:conpnl']")),150,0).perform();
		Point postion1= driver.findElement(By.xpath("//div[@id='form:conpnl']")).getLocation();
		System.out.println(postion1);
		
		//drop to the Target
		System.out.println(driver.findElement(By.xpath("//p[@class='ui-widget-header']")).getText());
		
		WebElement drop=driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		
		WebElement target= driver.findElement(By.xpath("//div[@id='form:drop']"));
		builder.dragAndDrop(drop, target).perform();
		System.out.println(driver.findElement(By.xpath("//p[@class='ui-widget-header']")).getText());
	
		//drag and drop the column
		WebElement source = driver.findElement(By.xpath("//tr[@role='row']//th[3]/span[text()='Quantity']"));
		target=driver.findElement(By.xpath("//tr[@role='row']//th[2]/span[text()='Category']"));
		
		builder.clickAndHold(source).clickAndHold(target).release().perform();
		System.out.println(driver.findElement(By.xpath("//tr[@role='row']//th[2]/span")).getText());
		
		source = driver.findElement(By.xpath("//tr[@role='row']//th[3]/span[text()='Category']"));
		target=driver.findElement(By.xpath("//tr[@role='row']/th/span[text()='Name']"));
		
		builder.clickAndHold(source).clickAndHold(target).release().perform();
		System.out.println(driver.findElement(By.xpath("//tr[@role='row']//th/span")).getText());
		
		//drag and drop rows
	
		
		source = driver.findElement(By.xpath("(//tbody[contains(@id,'form:j_id')])[2]/tr[2]"));
		target=driver.findElement(By.xpath("(//tbody[contains(@id,'form:j_id')])[2]/tr"));
		
		builder.clickAndHold(source).clickAndHold(target).release().perform();
		//System.out.println(driver.findElement(By.xpath("//tbody[contains(@id,'form:j_id')])[2]/tr/td[1]")).getText());
		
		source = driver.findElement(By.xpath("(//tbody[contains(@id,'form:j_id')])[2]/tr[4]"));
		target=driver.findElement(By.xpath("(//tbody[contains(@id,'form:j_id')])[2]/tr[8]"));
		
		builder.clickAndHold(source).clickAndHold(target).release().perform();
		//System.out.println(driver.findElement(By.xpath("(//tbody[contains(@id,'form:j_id')])[2]/tr[8]/td[8]")).getText());
		
		
		driver.close();
	}
}
