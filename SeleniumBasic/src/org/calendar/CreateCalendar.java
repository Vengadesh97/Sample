package org.calendar;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebDriver;

public class CreateCalendar {

	@SuppressWarnings("deprecation")
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
		
		//Left side Meeting Tab
		
		driver.findElement(By.xpath("//span[text()='Meetings']")).click();
	
		Thread.sleep(2000);
		//Create Tab
		
		driver.findElement(By.xpath("//a[text()='Create']")).click();
		
		Thread.sleep(5000);
		//Event Type Legal
		driver.findElement(By.id("legalMatter")).click();
		
//Matter Name 
		Thread.sleep(3000);
		WebElement matterName = driver.findElement(By.xpath("//div //select"));
		//Thread.sleep(3000);
		matterName.click();
		
		//Thread.sleep(3000);
		Select name = new Select(matterName);
		name.selectByVisibleText("Legal Case 5 ");
		matterName.click();
		
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(3000);
		
		// Add Team Member input Search box
		WebElement inputFieldTeamMember = driver.findElement(By.xpath("(//input[@id='file-name'])[1]"));
		
		// Team member dropdown Names
		List<WebElement> teamMembernames = driver.findElements(By.xpath("//input[@placeholder='Search team member']/following::datalist[@id='browsers']/option"));

		Thread.sleep(3000);
		
		for(int i=0;i<teamMembernames.size();i++)
		{
			String text = teamMembernames.get(i).getAttribute("value");
			if(text.contains("Jason Gifford"))
			{
				inputFieldTeamMember.click();
				inputFieldTeamMember.sendKeys("Jason Giffor");
				 Thread.sleep(1000);
				 Robot robot = new Robot();
				 robot.keyPress(KeyEvent.VK_DOWN);
				 Thread.sleep(1000);
				 robot.keyPress(KeyEvent.VK_ENTER);
				 Thread.sleep(1000);
				 //ADD button
				 driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();
			}
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
	/*
//Subject / Task
		Thread.sleep(3000);
		WebElement subjectTaskBtn = driver.findElement(By.xpath("//div //select[@formcontrolname='title']"));
		subjectTaskBtn.click();
		
		Select task = new Select(subjectTaskBtn);
		task.selectByVisibleText("Creating legal briefs ");
		subjectTaskBtn.click();
	/*	
//Time Zone
		Thread.sleep(3000);
		WebElement timeZoneBtn = driver.findElement(By.xpath("//div //select[@formcontrolname='timezone_location']"));
		timeZoneBtn.click();
		
		Select timeZone = new Select(timeZoneBtn);
		timeZone.selectByVisibleText("(GMT-07:00) Mountain Time - Yellowknife ");
		timeZoneBtn.click();
		
//Start time
		Thread.sleep(3000);
		WebElement startTimeBtn = driver.findElement(By.xpath("//div //select[@formcontrolname='from_ts']"));
		startTimeBtn.click();
		
		Select startTime = new Select(startTimeBtn);
		startTime.selectByVisibleText(" 11:00 ");
		startTimeBtn.click();

//End time		
		Thread.sleep(3000);
		WebElement endTimeBtn = driver.findElement(By.xpath("//div //select[2]"));
		endTimeBtn.click();
		
		Select endTime = new Select(endTimeBtn);
		endTime.selectByVisibleText(" 12:00 ");
		endTimeBtn.click();
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		
//Date
		Thread.sleep(3000);
		driver.findElement(By.id("drp")).click();
		
		String date ="8";
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[text()='"+date+"']")).click();
		
//Repetition
	Thread.sleep(3000);
	WebElement repetitionBtn = driver.findElement(By.xpath("//div //select[@formcontrolname='repeat_interval']"));
	repetitionBtn.click();
				
	Select reptition = new Select(repetitionBtn);
	reptition.selectByVisibleText("Bi-Weekly ");
	repetitionBtn.click();
				

//All Day 
	Thread.sleep(3000);
	driver.findElement(By.id("allday")).click();
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

//Meeting Link
	driver.findElement(By.id("meeting-link")).sendKeys("Hello");

//Dial-in Number
	driver.findElement(By.id("number")).sendKeys("Ind 987455");
	
//Location
	driver.findElement(By.id("location")).sendKeys("Kumbakonam");
	
//Meeting Agenda
	driver.findElement(By.name("meeting-agenda")).sendKeys("//https");
	
//Add Entity
	Thread.sleep(3000);
	WebElement addEntitybtn = driver.findElement(By.xpath("//select[@class='textbox form-control']"));
	addEntitybtn.click();
				
	Select entity = new Select(addEntitybtn);
	entity.selectByVisibleText("QA Test ");
	addEntitybtn.click();
	Thread.sleep(3000);
	//Search box entity
	driver.findElement(By.xpath("//input[@placeholder='Search client']")).click();
	Thread.sleep(3000);
	//pass the names
	driver.findElement(By.xpath("//input[@placeholder='Search client']")).sendKeys("TeamMember");
	Thread.sleep(3000);
	//Add Entity
	driver.findElement(By.xpath("(//input[@type='button'])[2]")).click();
	
	
	// Add Team Members
	Thread.sleep(3000);
	WebElement teamMembers = driver.findElement(By.xpath("//input[@placeholder='Search team member']"));
	teamMembers.click();
	teamMembers.sendKeys("Jason Gifford");
	Thread.sleep(3000);
	//add team member
	driver.findElement(By.xpath("(//input[@type='button'])[1]")).click();

	
	// Add Document
	
	Thread.sleep(3000);
	WebElement documents = driver.findElement(By.xpath("//input[@placeholder='Search Document']"));
	documents.click();
	documents.sendKeys("QA12");
	Thread.sleep(3000);
	//add docum
	driver.findElement(By.xpath("//input[@value='Attach']")).click();
	
	
	//Add Individuals 
	
	Thread.sleep(3000);
	WebElement individualsClients = driver.findElement(By.xpath("//input[@placeholder='Search Individual Clients']"));
	individualsClients.click();
	individualsClients.sendKeys("Dustin");
	Thread.sleep(3000);
	//add docum
	WebElement addIndiv = driver.findElement(By.xpath("//div//input[@placeholder='Search Individual Clients']/following::input"));
	addIndiv.click();
	
//Save	
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	
//View Changes
	Thread.sleep(4000);
	driver.findElement(By.xpath("//button[text()='View Changes']")).click();
	

	//View Matter
	Thread.sleep(4000);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,0)");
	
	Thread.sleep(2000);
	
	EventFiringWebDriver eventFiringWebDriver = new EventFiringWebDriver(driver);
	//eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 0");
	
	int num = 7;
	
	//int num = Integer.parseInt(number);
	
	//Thread.sleep(3000);
	
	if(num>=2)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 0");
	}
	
	if(num>=6)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 150");
	}
	if(num>=10)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 400");
	}
	if(num>=14)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 650");
	}
	if(num>=18)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 900");
	}
	if(num>=23)
	{
		eventFiringWebDriver.executeScript("document.querySelector('.mainmargin.scroll-container').scrollTop = 1150");
	}

	String meetingNames ="7:30 PM Contract Breach - Creating legal briefs";
	
	List<WebElement> allCalendarName = driver.findElements(By.xpath("//div //div[@class='cal-event']"));
	
	for (int i = 0; i < allCalendarName.size(); i++) {
		String	allCalendarTextName = allCalendarName.get(i).getText();
		Thread.sleep(2000);
		//System.out.println("All Group Name Text "+allCalendarTextName);
		if(meetingNames.contains(allCalendarTextName))
		{
			WebElement clickOnMeeting = allCalendarName.get(i);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", clickOnMeeting);
		}
		
	}
	
	
	*/
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
 
	/*	
		Thread.sleep(5000);
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("DD/MM/YYYY");
		
		String date ="25/07/2023";
		
		LocalDate dateGiven = LocalDate.parse(date);
		int mm = dateGiven.getMonthValue();
		
		System.out.println(mm);
		
		
		int gd = 25;
		String text = driver.findElement(By.xpath("//label[@class='tdate']")).getText();
		String date1 = text.split(",")[1];
		String date2 = date1.substring(Math.max(date1.length() - 2, 0));
		System.out.println("date format " +date2);
		int ed =Integer.parseInt(date2);
		int dd = gd-ed;
		int flag=1;
		if(dd<0)
		{
			flag =0;
			dd = -1 * dd;
		}
		
		for(int i=0;i<dd;i++)
		{
			if(flag==0)
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//img[@class='lefticon']")).click();
			}
			else
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("//img[@class='righticon']")).click();
			}
		}
		
	*/
		
		
	}

}
