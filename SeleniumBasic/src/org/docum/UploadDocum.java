package org.docum;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

public class UploadDocum {

	static String path = "C:\\Users\\Vengadesh\\Documents\\Image";

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub

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
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[text()='Documents']")).click();

		Thread.sleep(2000);
	
	
		WebElement clientInputBox = driver.findElement(By.xpath("//input[@aria-autocomplete='list']"));
		clientInputBox.click();
		
		String name ="Apollo Healthcare";
		int j=0;
		
		List<WebElement> allClientsName = driver.findElements(By.xpath("//div[@role='listbox'] //ul //li"));
		
		List<WebElement> selectName = driver.findElements(By.xpath("//div[@role='listbox'] //ul //li //a"));
		
		
		for(int i=0;i<allClientsName.size();i++)
		{
			String allNametext = allClientsName.get(i).getText();
			if(name.contains(allNametext))
			{
				j++;
				WebElement selectClients = selectName.get(i);
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				Thread.sleep(3000);
				executor.executeScript("arguments[0].click();", selectClients);
				
				if (j == name.length()) {
					break;
			}
			}
			
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//label[@for='title'])[3]")).click();
		
		Thread.sleep(5000);
		WebElement browserBtn = driver.findElement(By.id("btnadd"));
		browserBtn.click();
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	/*
	
	
	public static void uploadClient() throws InterruptedException, AWTException {
		Thread.sleep(10000);

		// Select Upload Tab
		// driver.findElement(By.xpath("//a[text()='Upload']")).click();

		// Select Client Tab
		// driver.findElement(By.xpath("//a[text()='Client']")).click();

		String clientName = "Ananth kumar";
		// Client Name inputbox
		WebElement clientNameInput = driver.findElement(By.xpath("//*[@aria-label='Type to select ']"));
		clientNameInput.click();
		Thread.sleep(2000);
		clientNameInput.sendKeys(clientName);

		Robot robot = new Robot();
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_ENTER);

		Thread.sleep(5000);

		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);

		getFile(path);

		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(10000);

		swt();
		// Enable Download
		// driver.findElement(By.xpath("//*[text()='Enable Download']")).click();

		// Disable Download
		// driver.findElement(By.xpath("//*[text()='Disable Download']")).click();

		// Add Tags
		// driver.findElement(By.xpath("//*[text()='Add Tags']")).click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		// js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Thread.sleep(5000);

		// Cancel
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// btncancel']")).click();

		// Submit [Upload]
		// driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Thread.sleep(5000);
		// Upload More
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// upload-btn']")).click();

		// View Changes
		// driver.findElement(By.xpath("//button[@class='btn btn-default
		// alertbtn']")).click();

		// System.out.println("Successfull");
	}

	public static void uploadFirm() throws InterruptedException {
		
		//Firm Tab
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Firm']")).click();
		
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//i[@aria-hidden='true']")).click();

		Thread.sleep(5000);

		String firmNames = "Common Law";

		List<WebElement> listFirmName = driver.findElements(By.xpath("//*[@class='callselect']"));
		
		for (int i = 0; i < listFirmName.size(); i++) {
			Thread.sleep(2000);
			String name = listFirmName.get(i).getText();

			if (firmNames.contains(name)) {
				driver.findElements(By.xpath("//input[@type='checkbox']")).get(i).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("//i[@aria-hidden='true']")).click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.id("btnadd")).click();

		Thread.sleep(5000);

		getFile(path);

		Thread.sleep(10000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

	//	Thread.sleep(5000);

		//swt();

//		        driver.findElement(By.xpath("//button[@type='submit']")).click();
//		         		
//		        Thread.sleep(5000);
//		        
//			driver.findElement(By.xpath("(//button[@class='btn btn-default alertbtn'])[2]")).click();
//			
//			System.out.println("Successfull");
//		        

	}

	public static void getFile(String path) throws InterruptedException {
		File directory = new File(path);

		String allimages = "";
		File[] flist = directory.listFiles();

		for (File file : flist) {
			if (file.isFile()) {
				allimages = allimages + "\"" + file.getName() + "\"" + " ";
			}
		}

		try {

			Runtime.getRuntime().exec(
					"C:\\Users\\Vengadesh\\Documents\\FileUpload\\getthefolder.exe" + " " + directory + File.separator);
			Thread.sleep(5000);
			Runtime.getRuntime().exec(
					"C:\\Users\\Vengadesh\\Documents\\FileUpload\\SelectallandClickonOpen1.exe" + " " + allimages);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void editData(String name, String descp) throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement dName = driver.findElement(By.id("documentName"));
		// Name
		dName.click();
		dName.clear();
		dName.sendKeys(name);
		Thread.sleep(2000);
		WebElement dDescrp = driver.findElement(By.xpath("//textarea[@name='description']"));
		// Description
		dDescrp.click();
		dDescrp.clear();
		dDescrp.sendKeys(descp);
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	

	public static void swt() throws InterruptedException {
		Thread.sleep(5000);
		Integer[] intArray = new Integer[] { 0, 2,3 };
		List<Integer> intList = new ArrayList<>(Arrays.asList(intArray));

		List<WebElement> edit = driver.findElements(By.xpath("//i[@class='fa fa-edit']"));
		Thread.sleep(5000);
		for (int i = 0; i <= edit.size(); i++) {
			Thread.sleep(2000);
			if (intList.contains(i)) {
				Thread.sleep(2000);
				if (i == 0) {
					Thread.sleep(1000);
					driver.findElements(By.xpath("//i[@class='fa fa-edit']")).get(i).click();
					Thread.sleep(1000);
					editData("test","Value0");
			} 
				else if (i == 1)
				{
					Thread.sleep(1000);
					driver.findElements(By.xpath("//i[@class='fa fa-edit']")).get(i).click();
					Thread.sleep(1000);
					editData("Passvalue","NewValues1");
				} 
	
				else if (i == 2)
					
				{
					Thread.sleep(1000);
					driver.findElements(By.xpath("//i[@class='fa fa-edit']")).get(i).click();
					Thread.sleep(1000);
					editData("Code 2", "Changes2");
				}

				else if (i == 3)
				{
					Thread.sleep(1000);
					driver.findElements(By.xpath("//i[@class='fa fa-edit']")).get(i).click();
					Thread.sleep(1000);
					editData("Changed 3", "Test3");
				}
				
				}

		}
		System.out.println("Done");
	}*/
