package org.Time;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class TimeSheet {

	static ChromeDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);

		driver.get("https://staging.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("vengadesh0719@gmail.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		Thread.sleep(2000);

		// Left Timesheets
		driver.findElement(By.xpath("//span[text()='Timesheets']")).click();
		
		Thread.sleep(3000);
		  //Left arrow
		  driver.findElement(By.xpath("//i[@class='fa fa-thin fa-chevron-left']")).click();
		/*
		  * 
		 * //Right arrow
		 * driver.findElement(By.xpath("//i[@class='fa fa-thin fa-chevron-right']")).
		 * click();
		 * 
		 * // Heading
		 * driver.findElement(By.xpath("//a[text()='My Timesheets']")).click();
		 * 
		 * //Submitted heading
		 * driver.findElement(By.xpath("//a[text()='Submitted']")).click();
		 * 
		 * //Non submitted heading
		 * driver.findElement(By.xpath("//a[text()='Not Submitted']")).click();
		 * 
		 */
		// Project
/*
		Thread.sleep(3000);
		WebElement projectList = driver.findElement(By.xpath("//select[@formcontrolname='matter_type']"));
		projectList.click();

		Select projecNames = new Select(projectList);
		projecNames.selectByVisibleText(" General Case 64 ");
		projectList.click();

		// Task

		Thread.sleep(3000);
		WebElement taskList = driver.findElement(By.xpath("//select[@formcontrolname='title']"));
		taskList.click();

		Select taskNames = new Select(taskList);
		taskNames.selectByVisibleText(" Draft agreements");
		taskList.click();

		// Status

		Thread.sleep(3000);
		WebElement statusList = driver.findElement(By.xpath("//select[@formcontrolname='billing']"));
		statusList.click();

		Select statusNames = new Select(statusList);
		statusNames.selectByVisibleText(" Non Billable ");
		statusList.click();

		// Date

		Thread.sleep(3000);
		WebElement dateList = driver.findElement(By.xpath("//select[@formcontrolname='date']"));
		dateList.click();

		Select dateNames = new Select(dateList);
		dateNames.selectByVisibleText(" Jul 26, 2023 ");
		dateList.click();

		//Hours 
		
		Thread.sleep(2000);
		WebElement hours = driver.findElement(By.xpath("//input[@type='number']"));
		hours.clear();
		hours.sendKeys("2");
		
		//Minutes
		
		Thread.sleep(3000);
		WebElement minutesList = driver.findElement(By.xpath("//select[@formcontrolname='duration_minutes']"));
		minutesList.click();

		Select minutesNames = new Select(minutesList);
		minutesNames.selectByVisibleText(" 30 ");
		minutesList.click();
		
		Thread.sleep(3000);
		// ADD+
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
	*/	
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		//Project below table
		
		List<WebElement> allRowNames1 = driver.findElements(By.xpath("//td[@rowspan='1']"));
		
		List<WebElement> allRowNames2 = driver.findElements(By.xpath("//td[@rowspan='2']"));
		
		List<WebElement> allRowNames3 = driver.findElements(By.xpath("//td[@rowspan='3']"));
		
		List<WebElement> allRowNames4 = driver.findElements(By.xpath("//td[@rowspan='4']"));
		
		List<WebElement> allRowNames5 = driver.findElements(By.xpath("//td[@rowspan='5']"));
		
		String[][] Span = new String[10][2];
		int count = 0;
		
		for(int i=0;i<allRowNames1.size();i++)
		{
			String text = allRowNames1.get(i).getText();
			Span[count][0] = text;
			Span[count][1] = "1";
			count++;
		}

		for(int i=0;i<allRowNames2.size();i++)
		{
			String text = allRowNames2.get(i).getText();
			Span[count][0] = text;
			Span[count][1] = "2";
			count++;
		}
		
		for(int i=0;i<allRowNames3.size();i++)
		{
			String text = allRowNames3.get(i).getText();
			Span[count][0] = text;
			Span[count][1] = "3";
			count++;
		}
		
//		for(int i=0;i<count;i++)
//		{
//			System.out.println(Span[i][0]+"\t"+Span[i][1]);
//		}
		
		
		Thread.sleep(1000);
		
		List<WebElement> projectNames = driver.findElements(By.xpath("//tr //td[@class='project']"));
		
		List<WebElement> allTaskNames = driver.findElements(By.xpath("//tr //td[@class='tasks']"));
		
		List<WebElement> allBillable = driver.findElements(By.xpath("//tr //td[@class='billable']"));
		
		List<WebElement> allNonBillable = driver.findElements(By.xpath("//tr //td[text()='non-billable']"));
		
		List<WebElement> allDate = driver.findElements(By.xpath("//tr //th[@class='date']"));
		int daycount = 0;
		for(int i=0;i<allDate.size();i++)
		{
			
			if(allDate.get(i).getText().contains("Jul 25, 2023"))
			{
				daycount = i;
				System.out.println("TopDaycount : "+daycount);
				break;
			}
		}
		
		String text;
		int y=0,x=0;
		int totalcount = 0;
//		for(int i=0;i<allBillable.size();i++)
//		{
//			System.out.println(allBillable.get(i).getText());
//		}
//		System.out.println("--------------------------");
//		
//		for(int i=0;i<allNonBillable.size();i++)
//		{
//			System.out.println(allNonBillable.get(i).getText());
//		}
//		
		for(int i=0;i<projectNames.size();i++)
		{
			text = projectNames.get(i).getText();
			System.out.println(text);
			if(text.contains("General Case 86- general"))
			{
				//System.out.println(text);
				Thread.sleep(1000);
				for(int j=0;j<count;j++)
				{
					if(Span[j][0].equals(text))
					{
						x=Integer.parseInt(Span[j][1]);
						break;
					}
				}
				Thread.sleep(1000);
				String task;
				for(int j=y;j<y+x;j++)
				{
					task = allTaskNames.get(j).getText();
					System.out.println(task);
					if(task.equals("Meeting with client"))
					{
						System.out.println("Y : "+y);
						System.out.println("j : "+j);
						System.out.println("dayCount : "+daycount);
						totalcount = ((j)*7) + daycount;
						System.out.println("Count : "+totalcount);
						break;
					}
				}
				
				break;
			}
			
			for(int j=0;j<count;j++)
			{
				//System.out.println(Span[j][0] +"\t"+Span[j][1]);
				if(Span[j][0].equals(text))
				{
					y=y+Integer.parseInt(Span[j][1]);
					System.out.println("y in loop : "+ y);
					break;
				}
			}
			
		}
		Thread.sleep(2000);
		List<WebElement> allDays = driver.findElements(By.xpath("//tr[@class='task-name'] //td //div"));
		Thread.sleep(1000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		if(allDays.get(totalcount).getText().equals(""))
		{
			WebElement clickField =allDays.get(totalcount);
			executor.executeScript("arguments[0].click();", clickField);
		}
		else
		{
			
			Thread.sleep(5000);
			List<WebElement> timeEdit = driver.findElements(By.xpath("//tr[@class='task-name'] //td //div//i[2]"));
			int editCount=0;
			for(int i=0;i<totalcount;i++)
			{
				if(!allDays.get(i).getText().equals(""))
				{
					editCount++;
				}
			}			
			WebElement editField = timeEdit.get(editCount);
			executor.executeScript("arguments[0].click();", editField);
			
		}
		
		//-------------
		//text scenario
		if(allDays.get(totalcount).getText().equals("1:00"))
		{
			WebElement clickField =allDays.get(totalcount);
			executor.executeScript("arguments[0].click();", clickField);
		}
		
		
		
}
}
