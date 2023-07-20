package week4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LearnDropdown {
	@Test
	public void dropdown() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.leafground.com/");
		driver.findElement(By.xpath("//span[text()='Element']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Dropdown']")).click();
		Select option = new Select(driver.findElement(By.xpath("//h5[contains(text(),'Which')]/following::select")));
		option.selectByIndex(1);
		driver.findElement(By.xpath("//h5[contains(text(),'Choose')]/following-sibling::div")).click();
		List<WebElement> l1 = new ArrayList<WebElement>(
				driver.findElements(By.xpath("//div[@class='ui-selectonemenu-items-wrapper']/ul/li")));

		for (int i = 0; i < l1.size(); i++) {
			if (l1.get(i).getText().equals("India"))
				l1.get(i).click();

		}
		// Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ele = driver.findElement(By.xpath("//label[text()='Select City']"));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
		driver.findElement(By.xpath("//label[text()='Select City']")).click();

		l1 = driver.findElements(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper']/ul)[2]/li"));

		for (WebElement value : l1) {

			if (value.getText().equals("Chennai")) {
				value.click();
				break;
			}
		}
		driver.findElement(By.xpath("//h5[text()='Choose the Course']/following::button")).click();

		l1 = driver.findElements(By.xpath("//ul[contains(@class,'ui-autocomplete-items')]/li"));
		for (WebElement value : l1) {
			System.out.println(value.getText());
			if (value.getText().equals("Selenium WebDriver")) {
				value.click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//label[text()='Select Language']")).click();

		l1 = driver.findElements(By.xpath("(//div[contains(@class,'ui-selectonemenu-items-wrapper')])[2]//li"));
		for (WebElement value : l1) {
			//System.out.println(value.getText());
			if (value.getText().equals("Hindi")) {
				value.click();
				break;
			}
		}
		ele=driver.findElement(By.xpath("//label[text()='Select Values']"));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(ele)));
		
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		l1 = driver.findElements(By.xpath("(//div[@class='ui-selectonemenu-items-wrapper'])[4]//li"));
		int i=0;
		for (WebElement value : l1) {
			//System.out.println(value.getText());
			i+=1;
			if (i==4) {
				value.click();
				break;
			}
		}
		driver.close();
	}

}
