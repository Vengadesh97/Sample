package org.matter;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewMatter {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://staging.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("ligokib730@mustbeit.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div //img[@class='mattersicon'])[1]")));
		
		//Left side Tab
		driver.findElement(By.xpath("(//div //img[@class='mattersicon'])[1]")).click();
		
		Thread.sleep(5000);
		
		//view button 
		//driver.findElement(By.xpath("//a[text()='View']")).click();
		
		//search box
		driver.findElement(By.xpath("//input[@placeholder='Search Group']")).sendKeys("Temp Legal Test1");
		
		js.executeScript("window.scrollTo(0,500)");
		
		Thread.sleep(10000);
		//action button
		driver.findElement(By.xpath("//div //button[@data-bs-toggle='dropdown']")).click();
		
		Thread.sleep(3000);
		WebElement editMatterInfo = driver.findElement(By.xpath("//ul[@class='dropdown-menu show'] //li[2]"));
		
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(editMatterInfo).click().perform();
				
		Thread.sleep(2000);
		WebElement titled = driver.findElement(By.id("title"));
		titled.clear();
		titled.sendKeys("hello");
		Thread.sleep(3000);
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn']")).click();
		
	}

}
