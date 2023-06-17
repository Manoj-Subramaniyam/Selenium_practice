package week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page_RefreshForwardBackward {
	
	String url="https://www.leafground.com";
	
	//diffrent ways for Refreshing a page
	//Note: @Test will Execute based on the alphabetical order of methods
	@Test
	
	public void refresh() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		//using refresh command in webdriver
		driver.navigate().refresh();
		Thread.sleep(3000);
		//using get method
		driver.get(driver.getCurrentUrl());
		// by passing the f5 using sendkeys
		Thread.sleep(3000);
		driver.quit();
		System.out.println("refresh");
	}
	@Test
	public void backward() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		driver.navigate().back();
		driver.quit();
		//System.out.println("backward");
	}
	@Test
	public void forward() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		driver.navigate().forward();
		driver.quit();
		//System.out.println("forward");
	}

}
