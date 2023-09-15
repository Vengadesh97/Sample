package org.rel;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Relationship {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\msedgedriver.exe");
		driver = new EdgeDriver();

		driver.get("https://app.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("coffersuperuser@gmail.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		//Thread.sleep(2000);

		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a //*[@class='mattersicon'])[3]")));
		
		// Left side RelationShip Button
		driver.findElement(By.xpath("(//a //*[@class='mattersicon'])[3]")).click();
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div //a[text()='Add Relationship']")));
		//Tab Add RelationShip
		driver.findElement(By.xpath("//div //a[text()='Add Relationship']")).click();
		
		//Tab Individuals
		//driver.findElement(By.xpath("//div //a[text()='Individual']")).click();
		
		//Enter the email
		driver.findElement(By.xpath("//*[@placeholder='Search by email']")).sendKeys("vengadeshw45@gmail.com");
		
		//Click on Search button
		driver.findElement(By.id("btnadd")).click();
		

		
	}

}
