package org.Mem;

import java.time.Duration;
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

public class ViewMemberEditMemberinfo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\msedgedriver.exe");
		WebDriver driver = new EdgeDriver();

		driver.get("https://dev2.lauditor.com/login");

		driver.manage().window().maximize();

		driver.findElement(By.id("id_email")).sendKeys("fecicon184@dni8.com");

		driver.findElement(By.id("id_password")).sendKeys("Test@123");

		driver.findElement(By.xpath("//button[text()='Login']")).click();

		Thread.sleep(10000);
		WebElement scol = driver.findElement(By.cssSelector("html"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", scol);

		// Group Select on Left Side
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Groups']")).click();

		Thread.sleep(1000);
		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();
		Thread.sleep(1000);
		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(1000);
		// View Member click
		driver.findElement(By.xpath("//button[@routerlink='/groups/view-member']")).click();

		Thread.sleep(2000);

		String mailid = "yexoj14526@fenwazi.com";

		// SearchMemberName
		WebElement searchbox = driver.findElement(By.xpath("//input[@placeholder='Search Member']"));

		searchbox.sendKeys(mailid);

		Thread.sleep(2000);
		// ACtionbutton
		driver.findElement(By.xpath("//button[@data-bs-toggle='dropdown']")).click();

		Actions action = new Actions(driver);

		WebElement editmemberinfoButton = driver
				.findElement(By.xpath("(//ul[@class='dropdown-menu custom-dropdown show'])//li[1]"));

		Thread.sleep(5000);
		action.moveToElement(editmemberinfoButton).click().perform();

		a.sendKeys(Keys.PAGE_UP).build().perform();

		// name
		WebElement reNames = driver.findElement(By.name("name"));
		reNames.clear();
		reNames.sendKeys("vengadesh");

		// Designation
		WebElement renameDesignation = driver.findElement(By.name("designation"));
		renameDesignation.clear();
		renameDesignation.sendKeys("TeamMember");

		// Default Rate
		WebElement renameDefault = driver.findElement(By.name("defaultRate"));
		renameDefault.clear();
		renameDefault.sendKeys("150");

		// Email
		WebElement renameEmail = driver.findElement(By.name("email"));
		renameEmail.clear();
		renameEmail.sendKeys("vengadesh@c.com");

		// Confirm Email
		WebElement renameConfirm = driver.findElement(By.name("emailConfirm"));
		renameConfirm.clear();
		renameConfirm.sendKeys("vengadesh@c.com");

		// dropdownClick currency
		driver.findElement(By.name("currency")).click();

		String name = "AustralianDollar(AUD)";

		driver.findElement(By.xpath("//option[text()='" + name + "']")).click();

		// Cancel
		driver.findElement(By.xpath("//button[@class='btn btn-default btncancel']")).click();

		// Save
		driver.findElement(By.xpath("//button[@class='btn btn-default btnsave']")).click();

		// SUccess popup close button
		driver.findElement(By.xpath("//button[@class='btn-close pull-right']")).click();

	}
}
