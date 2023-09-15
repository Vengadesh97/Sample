package org.calendar;

import java.util.ArrayList;
import java.util.Calendar;
import java.time.YearMonth;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ViewMeeting {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub


		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://staging.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("vengadeshr25@gmail.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		Thread.sleep(2000);
		
		//Left side Meeting Tab
		
		driver.findElement(By.xpath("//span[text()='Meetings']")).click();
		
		//View Month
		driver.findElement(By.xpath("//div //a[text()='Month']")).click();
		
		Thread.sleep(4000);
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollTo(0,200)");
		
		int dateOneLoc;
		int day = 3; int year = 2023; int month = 8,repeat=1;
		int monthDayCount;
		
		
		
		Thread.sleep(8000);
		int week = 0;
		for (int j=0; j<3; j++)
		{
			int i;
			//Finding total days of the month provided
			YearMonth ym = YearMonth.of(year,month);
			monthDayCount = ym.lengthOfMonth();
		    System.out.println("Month : "+month+"\tmonthDayCount : "+monthDayCount); 
		    
			List<WebElement> listOfallDateName = driver.findElements(By.xpath("//div[@role='row'] //span[@class='cal-day-number']"));
			// Day one count
			ViewMeeting viewMeeting = new ViewMeeting();
			// dateOneLoc--> Cell Location of day 1 of current month
			dateOneLoc = viewMeeting.findDateOneLoc(listOfallDateName);
			Thread.sleep(2000);
			int ii=dateOneLoc;
			List<WebElement> allCells = driver.findElements(By.xpath("//div[@role='row'] //td"));		
			
			if(j==0)
			{
				//day --> passing date 
				ii=dateOneLoc+day-1;
				//ii --> locating cell of passing date
			}
			else
			{
				// locating date 1 for subsequent month 
				ii=ii+week;
			}
			//System.out.println("ii = "+ii);
			Thread.sleep(3000);
			//List<String> oneCell = new ArrayList<String>();
			int vCount=0;
			for(i=ii;i<dateOneLoc+monthDayCount;i=i+repeat)
			{
				String[] oneCell = allCells.get(i).getText().split("[\\r\\n]+");
				//r --> split with enter
				System.out.println("Date "+oneCell[0]);
				int flag = 0;
				for(String a : oneCell)
				{
					if(a.equals("11:30 AM Legal Case 5 - Case filling"))
					{
						System.out.println("Matched :  "+a);
						flag = 1;
						if(vCount<2)
						{
							
						}
					//	System.out.println("i :  "+i);
					}
				}
				if(flag==0)
				{
					//assertion fail
				}
				//string.split("[\\r\\n]+")
//				if(allCells.get(i).getText().contains("11:30 AM Legal Case 5 - Case filling"))
//					System.out.println("Each cell text "+allCells.get(i).getText());
//				else
//					System.out.println("Errrrrrrrrrrrrrrrrrrrrrrrror");
				// For Current month
				vCount++;
			}
			//assertion true
			
			
		//	week = (i+1)%14;
			//week++;
			week = i-(dateOneLoc+monthDayCount);
			//System.out.println("i = "+i);
			//System.out.println("dateOneLoc = "+dateOneLoc);
			//System.out.println("monthDayCount = "+monthDayCount);
			
			//System.out.println("week = "+week);
			driver.findElement(By.xpath("//img[@class='righticon']")).click();
			month = month +1;
			Thread.sleep(5000);
			if(month==13)
			{
				year++;
				month = 1;
			}
		   
		}
	}

	
	public int findDateOneLoc(List<WebElement> allDates) {

		int temp = 50;
		// Date one Found
		for (int i = 0; i < allDates.size(); i++) {
			if (allDates.get(i).getText().equals("1")) {
				System.out.println("location of 1 : " + i);
				temp = i;
				break;
			}
		}
		return temp;
	}
	
}

