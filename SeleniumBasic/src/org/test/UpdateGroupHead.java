package org.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class UpdateGroupHead {

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

		String name = "Family law";

		List<WebElement> actionBtnClick = driver.findElements(By.xpath("//button[text()=' Action ']"));

		Thread.sleep(2000);
		JavascriptExecutor executor = (JavascriptExecutor) driver;

		for (int i = 0; i < groupNameText.size(); i++) {
			String grouptextcomp = groupNameText.get(i).getText();

			Thread.sleep(200);
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

		WebElement updategroupheadBtn = driver
				.findElement(By.xpath("(//ul[@class=\"dropdown-menu custom-dropdown show\"])//li[3]"));

		action.moveToElement(updategroupheadBtn).click().perform();

		Thread.sleep(2000);
		// Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();

		// GroupheadNameText
		List<WebElement> groupheadNameText = driver.findElements(By.xpath("//label[@class='callselect float-left']"));

		String groupheadname = "Anantha-kumar";
		
		//Vengadesh RSB Associates
		
		List<WebElement> selectbuttonGroupHead = driver
				.findElements(By.xpath("//div[@class=\"multicheck form-control textbox selmember\"]"));

		for (int i = 0; i < groupheadNameText.size(); i++) {
			String totalGroupheadname = groupheadNameText.get(i).getText();

			Thread.sleep(200);
			if (groupheadname.contains(totalGroupheadname)) {
				Thread.sleep(2000);

				WebElement selectedGroupHead = selectbuttonGroupHead.get(i);

				executor.executeScript("arguments[0].click();", selectedGroupHead);
			}
		}

		Thread.sleep(1000);
		//save
		driver.findElement(By.xpath("//button[@data-bs-target='#exampleModal']")).click();
		Thread.sleep(1000);
		//Yes
		driver.findElement(By.xpath("(//button[@data-bs-dismiss=\"modal\"])[6]")).click();
		
		Thread.sleep(1000);
		//ok
		driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[2]")).click();
		
		
		
	}

}
