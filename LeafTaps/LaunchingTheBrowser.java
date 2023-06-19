package leaftaps;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LaunchingTheBrowser {
	
	@Test
	public void start() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/main");
		Thread.sleep(3000);
		driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		Thread.sleep(3000);
		String s= driver.findElement(By.tagName("h2")).getText();
		System.out.println(s);
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TEst");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Manoj");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Subramaniyam");
		driver.findElement(By.name("submitButton")).click();
		
		//get title
		String storeTitle=driver.getTitle();
		System.out.println(storeTitle);
		//get number on the company name
		
		String storeText=driver.findElement(By.id("viewLead_companyName_sp")).getText();
		String getNumbers=storeText.replaceAll("\\D", "");
		System.out.println(getNumbers);
		driver.quit();
	}

}
