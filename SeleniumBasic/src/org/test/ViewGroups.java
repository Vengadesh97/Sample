package org.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import graphql.schema.diffing.EditOperation;

public class ViewGroups {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver","C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();
	
		driver.get("https://app.lauditor.com/login");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("id_email")).sendKeys("coffersuperuser@gmail.com");
		
		driver.findElement(By.id("id_password")).sendKeys("Test@123");
		
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
		Thread.sleep(10000);
		WebElement scol = driver.findElement(By.cssSelector("html"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", scol);
	
		// Group Select on Left Side
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Groups']")).click();
		
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View Group']")).click();
		
		List<WebElement> groupNameText = driver.findElements(By.xpath("//tr/td[1]"));
		
		String name ="Family law";
		
		List<WebElement> actionBtnClick = driver.findElements(By.xpath("//button[text()=' Action ']"));
		
		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		for(int i=0;i<groupNameText.size();i++)
		{
			String grouptextcomp = groupNameText.get(i).getText();

			Thread.sleep(200);
			if (name.contains(grouptextcomp)) {
				Thread.sleep(5000);

				WebElement actionMenu = actionBtnClick.get(i);
				
				executor.executeScript("arguments[0].click();", actionMenu);
			} }		
		
		Thread.sleep(5000);
		
		WebElement actionList = driver.findElement(By.xpath("//ul[@class='dropdown-menu custom-dropdown show']"));
		
	//	Thread.sleep(5000);

		Actions action = new Actions(driver);
		action.moveToElement(actionList).build().perform();
		
	
		WebElement editgroupin = driver.findElement(By.xpath("(//ul[@class=\"dropdown-menu custom-dropdown show\"])//li[2]"));
	
		
	//	Thread.sleep(5000);
		action.moveToElement(editgroupin).click().perform();
		
		Thread.sleep(5000);
		Actions ab = new Actions(driver);
		ab.sendKeys(Keys.PAGE_UP).build().perform();
		
		//all text name
		List<WebElement> updateNames = driver.findElements(By.xpath("//div[@class='form-control textbox']"));
		
		Thread.sleep(5000);

		//Remove listname
		String[] named= {"Miranda Williams","Susan"};
		
		List<String> nameSelect = Arrays.asList(named);
		
		//remove button 
		List<WebElement> removebutton =driver.findElements(By.xpath("//i[@class='fa fa-regular fa-circle-xmark calimg calitem input-group-append sgroup']"));
		
		for(int i=0;i<updateNames.size();i++)
		{
			String removedname = updateNames.get(i).getText();

			Thread.sleep(200);
			if (nameSelect.contains(removedname)) {
				Thread.sleep(2000);

				WebElement removeMemb = removebutton.get(i);
				
				executor.executeScript("arguments[0].click();", removeMemb);
			} }		
		
		Thread.sleep(5000);
		
		List<WebElement> updateNamed = driver.findElements(By.xpath("//div[@class='form-control textbox']"));
		
		//Add member
		String[] namedAdd = {"Neela C RSB Associates","Ananth-TM"};
		
		List<String> nameAdded =Arrays.asList(namedAdd);
		//Select member
		List<WebElement> selectedMemb = driver.findElements(By.xpath("//i[@class='fa a-solid fa-minus calimg calitem input-group-append sgroup']"));
		
		
		for(int j=0;j<updateNamed.size();j++)
		{
			String namedss = updateNamed.get(j).getText();
		Thread.sleep(1000);
		if (nameAdded.contains(namedss)) {
			Thread.sleep(1000);
			
			WebElement actionSelct =selectedMemb.get(j);
			
			executor.executeScript("arguments[0].click();", actionSelct);
		}
		
		}
		
		
		//Scroll down 
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='btn btn-default btnsave']")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("(//div[@class='center'])[3]")).click();

		
		
		
		
	}

}

//public void edit()
//{
//Thread.sleep(3000);
//
//WebElement actionList = driver.findElement(By.xpath("//ul[@class='dropdown-menu custom-dropdown show']"));
//
////Thread.sleep(5000);
//
//Actions action = new Actions(driver);
//action.moveToElement(actionList).build().perform();
//
////Thread.sleep(5000);
//WebElement editgroupin = driver.findElement(By.xpath("(//ul[@data-popper-placement=\"top-end\"] //a)[1]"));
//
////Thread.sleep(5000);
//action.moveToElement(editgroupin).click().perform();
//
////Rename groupName
//WebElement rename = driver.findElement(By.id("caseTitle"));
//rename.clear();
//rename.sendKeys("Changename");
//
//WebElement redesc = driver.findElement(By.name("description"));
//redesc.clear();
//redesc.sendKeys("text");
//
//driver.findElement(By.xpath("//button[@class='btn btn-default btnsave']")).click();
//
//Thread.sleep(1000);
//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[4]")).click();
//}