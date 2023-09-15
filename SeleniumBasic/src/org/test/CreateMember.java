package org.test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateMember {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\msedgedriver.exe");
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
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Groups']")).click();

		Thread.sleep(5000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@routerlink='/groups/create-member']")));
		// Create Member click
		driver.findElement(By.xpath("//button[@routerlink='/groups/create-member']")).click();

		// Name
		driver.findElement(By.name("name")).sendKeys("Mani");

		// Designation
		driver.findElement(By.name("designation")).sendKeys("TeamMember");

		// Default Rate
		driver.findElement(By.name("defaultRate")).sendKeys("50");

		// Email
		driver.findElement(By.name("email")).sendKeys("vengadesh@c.com");

		// Confirm Email
		driver.findElement(By.name("emailConfirm")).sendKeys("vengadesh@c.com");

		// dropdownClick currency
		driver.findElement(By.name("currency")).click();

		String name = "AustralianDollar(AUD)";

		driver.findElement(By.xpath("//option[text()='" + name + "']")).click();

		// Click on assign Group
		driver.findElement(By.xpath("//i[@class='fa fa-solid fa-plus calimg calitem input-group-append sgroup']"))
				.click();

		// Assign to Group name text
		List<WebElement> listofgroupsname = driver.findElements(By.xpath("//div[@class='callselect']"));

		List<WebElement> selectBtnGroup = driver.findElements(By.xpath("//input[@id='flexCheckDefault']"));

		String[] named = { "Family-Law-Ananth", "Group Creation test" };
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		
		List<String> selectgroupname = Arrays.asList(named);
		Thread.sleep(2000);
		for (int i = 0; i < listofgroupsname.size(); i++) {

			String groupsnametext = listofgroupsname.get(i).getText();
			Thread.sleep(2000);
			if (selectgroupname.contains(groupsnametext)) {
				Thread.sleep(2000);
				
				WebElement selectedGroupNameBtnClick = selectBtnGroup.get(i);

				executor.executeScript("arguments[0].click();", selectedGroupNameBtnClick);
			}

		}
		
		Thread.sleep(2000);
		
		executor.executeScript("scrollBy(0, 4500)");  
		
		
		//Save 
		driver.findElement(By.xpath("//button[@class='btn btn-default btnsave']")).click();
		
		//Add Team MEmber
		//driver.findElement(By.xpath("//button[text()='Add Members']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()='View Changes']")));
		
		//View Changes
		driver.findElement(By.xpath("//button[text()='View Changes']")).click();
		
		
	}

}
