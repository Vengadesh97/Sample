package org.docum;

import java.awt.AWTException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadFirm {

	static String path = "C:\\Users\\Vengadesh\\Documents\\Image";

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stu

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://staging.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("vengadesh0719@gmail.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		Thread.sleep(4000);

		//Left side document 
		driver.findElement(By.xpath("(//a //span[@class='icotxt'])[2]")).click();
		Thread.sleep(3000);

		// Firm Click
		driver.findElement(By.xpath("//a[@class='details doc-option firm']")).click();
		Thread.sleep(3000);
		
		// add symbol click 
		driver.findElement(
				By.xpath("//i[@class='fa fa-plus form-check-inpu calimg calitem input-group-append checkboxitem']"))
				.click();
		
		// List of Names 
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='input-group index court'] //div[@class='multicheck form-control textbox']"));
		
		// CheckBox
		List<WebElement> selectCheckBox = driver.findElements(By.xpath("//div[@class='input-group index court'] //input[@id='flexCheckDefault']"));		
		
		
		Thread.sleep(3000);
		String[] selectedGroup = {"Group 3","Group 2","Group 1"};
		
		List<String> selectedGroupNames = Arrays.asList(selectedGroup);
	
		for(int i =0;i<names.size();i++)
			{
				String allGroupNameText = names.get(i).getText();
				if(selectedGroupNames.contains(allGroupNameText))
				{
					WebElement selectGroup = selectCheckBox.get(i);
					JavascriptExecutor executor = (JavascriptExecutor) driver;
					Thread.sleep(3000);
					executor.executeScript("arguments[0].click();", selectGroup);
					
				}
	
		}
			
		// Again click the add Button
		Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='fa fa-minus form-check-inpu calimg calitem input-group-append checkboxitem']")).click();
		
		
		
		
		
		
		
		
		
		
	}

}
