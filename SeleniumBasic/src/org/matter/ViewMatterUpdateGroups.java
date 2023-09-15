package org.matter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewMatterUpdateGroups {


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

		// search box
		driver.findElement(By.xpath("//input[@placeholder='Search Group']")).sendKeys("Test Matter");

		js.executeScript("window.scrollTo(0,500)");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div //button[@data-bs-toggle='dropdown']")));
		// action button
		driver.findElement(By.xpath("//div //button[@data-bs-toggle='dropdown']")).click();

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='dropdown-menu show'] //li[3]")));
		WebElement updateGroups = driver.findElement(By.xpath("//ul[@class='dropdown-menu show'] //li[3]"));

		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(updateGroups).click().perform();

	// Unselect Groups 	
		Thread.sleep(3000);
		WebElement leftSideUnSelectedGroup = driver.findElement(By.xpath("(//div[@class='col-6 matterpadding'])[1]"));

		action.moveToElement(leftSideUnSelectedGroup).perform();
		
		Thread.sleep(3000);
		String[] selectedGroup = {"Meeting Group","Test123","Group Checking"};
	
		List<String> selectedGroupNames = Arrays.asList(selectedGroup);
		
		
		List<WebElement> listOfSelectedGroupNames = driver.findElements(By.xpath("//div[@class='input-group multicheck court']"));
		
		//System.out.println("all groups" + listOfGroupNames);
		List<WebElement> checkBoxSelect = driver.findElements(By.xpath("//i[@class='fa fa-regular fa-circle-xmark calimg calitem input-group-append sgroup']"));

			for(int i =0;i<listOfSelectedGroupNames.size();i++)
			{
				
				String allGroupNameText = listOfSelectedGroupNames.get(i).getText();
		
				if(selectedGroupNames.contains(allGroupNameText))
				{
					WebElement selectGroup = checkBoxSelect.get(i);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					Thread.sleep(3000);
					executor.executeScript("arguments[0].click();", selectGroup);
					
				}
	
		}
			
			
			
		// Select Groups 
		
			Thread.sleep(3000);
			
			js.executeScript("window.scrollTo(0,400)");
			
			WebElement rightSideUnSelectedGroup = driver.findElement(By.xpath("//div[@class='form-group'][2]"));

			action.moveToElement(rightSideUnSelectedGroup).perform();
			
			Thread.sleep(3000);
			String[] listOfGroup = {"new group","Teams","Document Share Group"};
		
			List<String> selectedGroupNames1 = Arrays.asList(listOfGroup);
			
			
			List<WebElement> listOfGroupNames = driver.findElements(By.xpath("//div[@class='multicheck form-control textbox']"));
			
			//System.out.println("all groups" + listOfGroupNames);
			List<WebElement> checkBoxSelect1 = driver.findElements(By.xpath("//input[@class='form-check-inpu calimg calitem input-group-app end checkboxitem']"));

				for(int i =0;i<listOfGroupNames.size();i++)
				{
					
					String allGroupNameText = listOfGroupNames.get(i).getText();
			
					if(selectedGroupNames1.contains(allGroupNameText))
					{
						WebElement selectGroup = checkBoxSelect1.get(i);
						JavascriptExecutor executor = (JavascriptExecutor) driver;
						Thread.sleep(3000);
						executor.executeScript("arguments[0].click();", selectGroup);
						
					}
		
			}
			
			
			Thread.sleep(2000);
			js.executeScript("window.scrollTo(0,1000)");
			
			//Submit
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			
			//Cancel Button
			//driver.findElement(By.xpath("//button[@type='reset']")).click();
		
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default alertbtn alertbtnyes']")));
			
			//Alert -Yes 
			driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn alertbtnyes']")).click();
			
			//wait.until(
			//		ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default alertbtn alertbtnno")));
			
			//Alert - No
			//driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn alertbtnno']")).click();
		
			wait.until(
					ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn btn-default alertbtn']")));
			
			
			
			//View Matter [ Success]
			driver.findElement(By.xpath("//button[@class='btn btn-default alertbtn']")).click();
			
		
		
		}
	}


