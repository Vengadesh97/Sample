package org.matter;

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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMatter {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
	

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://app.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("coffersuperuser@gmail.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		WebDriverWait wait =  new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div //img[@class='mattersicon'])[1]")));

		//Thread.sleep(2000);
		
		//Left side Tab
		driver.findElement(By.xpath("(//div //img[@class='mattersicon'])[1]")).click();
		
		//Tab
		//driver.findElement(By.xpath("//*[text()='Legal Matters']")).click();
		
		//Create Tab
		driver.findElement(By.xpath("//a[text()='Create']")).click();
		
		//Case Title
		driver.findElement(By.id("title")).sendKeys("Names");
		
		//Case Number
		driver.findElement(By.name("case_number")).sendKeys("F34");
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		
		
		//Calender
		driver.findElement(By.xpath("//*[@class='mat-mdc-button-touch-target']")).click();
		
		Thread.sleep(2000);
		
		String date = " 5 ";
		
		driver.findElement(By.xpath("//div[text()='"+date+"']")).click();
	
		Thread.sleep(2000);
		
		//Description
		driver.findElement(By.name("description")).sendKeys("Test Welcome");
		
		//Case Type
		driver.findElement(By.id("case_type")).sendKeys("Individuals");
		
		//Court name
		driver.findElement(By.name("court_name")).sendKeys("High Court");
		
		//Judges
		driver.findElement(By.name("judges")).sendKeys("Mukesh");
		
		Thread.sleep(2000);
		//Prioirty
		
		String select = "Low";
		
		driver.findElement(By.xpath("//button[text()='"+select+"']")).click();
		
		Thread.sleep(2000);
		
		//Status 
		
		String status = "Pending";
		
		driver.findElement(By.xpath("//button[text()='"+status+"']")).click();
		
		
		Thread.sleep(2000);
		
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='button']")));
		
		//Opponent Advocates [Add] Buttons
		driver.findElement(By.xpath("//input[@type='button']")).click();
		
		//Name
		driver.findElement(By.id("name")).sendKeys("Vengadesh");
		
		//Email 
		driver.findElement(By.id("email")).sendKeys("veng@gmjs.com");
		
		//Phone
		driver.findElement(By.id("phone")).sendKeys("9988558855");
		
		//Scroll Down
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@type='submit'])[1]")));
		
		//Save
	
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		
		
		//Save[Next]
		driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();

		
		//cancel
		//driver.findElement(By.xpath("//button[text()='Cancel']")).click();
		
		Thread.sleep(3000);
		
		
		//Groups 
		
		//All Groups Name
		List<WebElement> listOfGroupsName = driver.findElements(By.xpath("//div //div[@class='callselect']"));
		
		//CheckBox
		List<WebElement> checkboxSelect = driver.findElements(By.xpath("//*[@id='flexCheckDefault']"));
		
		int j=0;
		
		String[]  groupNames = {"Group Modules Test","Corporative Law","Administration Group"}; 
		
		
		List<String> groupNameSelect = Arrays.asList(groupNames);
	
		for(int i=0;i<listOfGroupsName.size();i++)
		{
			String textGroups = listOfGroupsName.get(i).getText();
			
			System.out.println("All text name " +textGroups);
							
			}
		
		
		/*			
		for(int i=0;i<=listOfGroupsName.size();i++)
		{
			String textGroups = listOfGroupsName.get(i).getText();
			
			if(groupNameSelect.contains(textGroups))
			{
				j++;
				Thread.sleep(3000);
				WebElement checkboxSelectedGroupName = checkboxSelect.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedGroupName);
				
				if (j == groupNameSelect.size()) {
				break;

			}
							
			}
	
		}
		
		Thread.sleep(1000);
		
	
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(1000);
		//Next
		driver.findElement(By.className("btnsave")).click();
			
		//Cancel
		//driver.findElement(By.className("btncancel")).click();
		
		
		
	//Clients Name
		
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,500)");
		
		Thread.sleep(5000);

	
		//All Client Names
		List<WebElement> listOfClientNames = driver.findElements(By.xpath("//div //div[@class='callselect']"));
		
		List<WebElement> checkboxSelected = driver.findElements(By.xpath("//*[@id='flexCheckDefault']"));

		int k=0;
		
		String[]  ClientNames = {"Joe M M","Akhila and Associates - Prod Test","Production Test Entity"}; 
		
		
		List<String> clientNameSelect = Arrays.asList(ClientNames);
		
		for(int i=0;i<=listOfClientNames.size();i++)
		{
			String textClients = listOfClientNames.get(i).getText();
			
			if(clientNameSelect.contains(textClients))
			{
				k++;
				Thread.sleep(3000);
				WebElement checkboxSelectedClientName = checkboxSelected.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedClientName);
				
				if (k == clientNameSelect.size()) {
				break;

			}
							
			}
	
		}
		
		Thread.sleep(1000);
		
		
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		Thread.sleep(1000);
		//Next
		driver.findElement(By.className("btnsave")).click();
		
		
	// Team Member Names	
		
		Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,500)");
		
		Thread.sleep(5000);

	
		//All Team members Names
		List<WebElement> listOfTeamMemberNames = driver.findElements(By.xpath("//div //div[@class='callselect']"));
		
		List<WebElement> checkboxSelecteds = driver.findElements(By.xpath("//*[@id='flexCheckDefault']"));

		int l=0;
		
		String[]  TMNames = {"Susan","Karthick RSB TM","RSB TM"}; 
		
		
		List<String> TeamMemberNameSelect = Arrays.asList(TMNames);
		
		for(int i=0;i<=listOfTeamMemberNames.size();i++)
		{
			String textTeamMembers = listOfTeamMemberNames.get(i).getText();
			
			if(TeamMemberNameSelect.contains(textTeamMembers))
			{
				l++;
				Thread.sleep(3000);
				WebElement checkboxSelectedTMName = checkboxSelecteds.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedTMName);
				
				if (l == TeamMemberNameSelect.size()) {
				break;

			}
							
			}
	
		}
		
		Thread.sleep(1000);
		
		
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		
		Thread.sleep(1000);
		//Next
		driver.findElement(By.className("btnsave")).click();
		
		
	//Documents 
				
		Thread.sleep(5000);

	
		//All Team members Names
		List<WebElement> listOfDocumentNames = driver.findElements(By.xpath("//div //div[@class='callselect']"));
		
		List<WebElement> checkboxSelectes = driver.findElements(By.xpath("//*[@id='flexCheckDefault']"));

		int m=0;
		
		String[]  documentNames = {"Super User Excel Firm Files","Team Member Client Video","TM Client Image Prod","Image Fiels"}; 
		
		
		List<String> documentNameSelect = Arrays.asList(documentNames);
		
		for(int i=0;i<=listOfDocumentNames.size();i++)
		{
			String textDocumentName = listOfDocumentNames.get(i).getText();
			
			if(documentNameSelect.contains(textDocumentName))
			{
				m++;
				Thread.sleep(3000);
				WebElement checkboxSelectedDocumentName = checkboxSelectes.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedDocumentName);
				
				if (m == TeamMemberNameSelect.size()) {
				break;

			}
							
			}
	
		}
		
		Thread.sleep(2000);
		
		
		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		

		Thread.sleep(3000);
		//Next
		driver.findElement(By.className("btnsave")).click();
		
		Thread.sleep(3000);
		//Alter Yes
		driver.findElement(By.className("alertbtnyes")).click();
		
		Thread.sleep(3000);
		//Add Matter
		driver.findElement(By.xpath("//button[text()='Add Matter']")).click();
		
		//View Matter 
		//driver.findElement(By.xpath("//button[text()='View Matter List']")).click();
		
		
		
		
		*/
	}

}
