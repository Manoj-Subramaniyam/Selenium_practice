package week1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class NavigatingIntoUrl {
	
	public String path= "C:\\Users\\manoj.subramaniyam\\Documents\\Selenium\\New\\chromedriver_win32\\chromedriver.exe";
	
	//method1
	@Test
	public void main() throws InterruptedException
	{
	System.setProperty("webdriver.chrome.driver",path); //Manually we need to download the chrome driver from web
		//WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.leafground.com");
	Thread.sleep(3000);
	driver.quit();
}
	//method2 no need to download drivers manually using WebDriverManager, it will be dowloaded automatically
	@Test
	public void main1() throws InterruptedException
	{
	
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.leafground.com");
	Thread.sleep(3000);
	driver.quit();
}
	//method3 in this method we are setting up the system variable and giving the path where all the drivers are available , so need to explicitly mention the drivers path or setup

	@Test
	public void main2() throws InterruptedException
	{
	
	
	ChromeDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.leafground.com");
	Thread.sleep(3000);
	driver.quit();
}
}
