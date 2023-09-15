package org.matter;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;

public class ViewMatterOpenCloseMatter {
	
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
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

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div //img[@class='mattersicon'])[1]")));

		// Left side Tab
		driver.findElement(By.xpath("(//div //img[@class='mattersicon'])[1]")).click();

		Thread.sleep(5000);
		
		String names ="Test";
		
		// search box
		driver.findElement(By.xpath("//input[@placeholder='Search Group']")).sendKeys(names);
		
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,500)");

		List<WebElement> matterNames = driver.findElements(By.xpath("//tr//td[1]"));
		
		List<WebElement> actionBtn = driver.findElements(By.xpath("//tr//td[6]"));
		
		Actions action = new Actions(driver);
		
		for(int i=0;i<matterNames.size();i++)
		{
			String text = matterNames.get(i).getText();
			
			if(names.contains(text))
			{
				wait.until(
						ExpectedConditions.visibilityOfAllElements(actionBtn));
				WebElement actionClick = actionBtn.get(i);
				wait.until(
						ExpectedConditions.visibilityOfAllElements(actionBtn));
			action.moveToElement(actionClick).click().perform();
				
			}
			
		}
		

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu show'] //li[4]")));
		WebElement closeMatter = driver.findElement(By.xpath("//ul[@class='dropdown-menu show'] //li[4]"));

		Thread.sleep(2000);
		//Actions action = new Actions(driver);
		action.moveToElement(closeMatter).click().perform();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default alertbtn alertbtnyes']")));
		
		//Confirmation Ok 
		driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn alertbtnyes']")).click();
		
		//Confirmation Cancel 
	//	driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn alertbtnno']")).click();
		
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default alertbtn']")));
		
		//Success View Matter
		driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn']")).click();
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='Closed']")));
		
		WebElement element = driver.findElement(By.xpath("//td[text()='Closed']"));
		
        // Find the element by name
      //  WebElement element = driver.findElement(By.name("example-name"));

        // Check if the element's name is displayed
        boolean isNameDisplayed = element.isDisplayed();

        // Print the result
       System.out.println("Name is displayed: " + isNameDisplayed);
		
	
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	

}
