package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class DeleteGroup {

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
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Groups']")).click();

		Actions a = new Actions(driver);
		a.sendKeys(Keys.PAGE_UP).build().perform();
		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View Group']")).click();

		List<WebElement> groupNameText = driver.findElements(By.xpath("//tr/td[1]"));

		

		List<WebElement> actionBtnClick = driver.findElements(By.xpath("//button[text()=' Action ']"));

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		for (int i = 0; i < groupNameText.size(); i++) {
			String grouptextcomp = groupNameText.get(i).getText();
			String name = "Group check";
			Thread.sleep(2000);
			if (name.contains(grouptextcomp)) {
				Thread.sleep(5000);

				WebElement actionMenu = actionBtnClick.get(i);

				executor.executeScript("arguments[0].click();", actionMenu);
			}
		}

		Thread.sleep(5000);

		WebElement actionList = driver.findElement(By.xpath("//ul[@class='dropdown-menu custom-dropdown show']"));

		Actions action = new Actions(driver);
		action.moveToElement(actionList).build().perform();

		WebElement deleteBtn = driver
				.findElement(By.xpath("(//ul[@class=\"dropdown-menu custom-dropdown show\"])//li[4]"));

		action.moveToElement(deleteBtn).click().perform();
		
		Thread.sleep(5000);
		
		WebElement searchbar = driver.findElement(By.xpath("//input[@placeholder='Search group']"));
		
		searchbar.sendKeys("Civil Law");
		
		Thread.sleep(5000);
		// Assign to another group text
		List<WebElement> assignGroupText = driver.findElements(By.xpath("//label[@class='callselect float-left']"));

		// Select button
		List<WebElement> selectBtnAssignGroup = driver
				.findElements(By.xpath("//div[@class='multicheck form-control textbox']"));
		
		Thread.sleep(5000);

		for (int i = 0; i < assignGroupText.size(); i++) {
			String selectAssignGroup = assignGroupText.get(i).getText();
			String assignGroupname = "Civil Law";
			Thread.sleep(2000);
			if (assignGroupname.contains(selectAssignGroup)) {
				Thread.sleep(2000);

				WebElement selectedAssignGroup = selectBtnAssignGroup.get(i);

				executor.executeScript("arguments[0].click();", selectedAssignGroup);
			}
		}
		Thread.sleep(2000);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		Thread.sleep(2000);
		// Delete
		driver.findElement(By.xpath("//button[@data-bs-target='#confirmModal']")).click();

		// Yes
		Thread.sleep(1000);
		//driver.findElement(By.xpath("(//button[@aria-label='Close'])[3]")).click();

		//ok
		//driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[1]")).click();
		
	}

}
