package org.Mem;

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

public class ViewMemberUpdateGroupAccess {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.edge.driver",
				"C:\\Users\\Vengadesh\\git\\SeleniumGIT\\SeleniumBasic\\Driver\\msedgedriver1.exe");
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

		WebElement updateGroupAccessBtn = driver
				.findElement(By.xpath("(//ul[@class='dropdown-menu custom-dropdown show'])//li[2]"));

		Thread.sleep(5000);
		action.moveToElement(updateGroupAccessBtn).click().perform();

		a.sendKeys(Keys.PAGE_UP).build().perform();

		Thread.sleep(5000);

		// ListofGroupNameText
		List<WebElement> ListofGroupNameText = driver
				.findElements(By.xpath("//*[@class='multicheck form-control textbox']//div"));
		Thread.sleep(1000);
		// CheckboxSelect
		List<WebElement> checkboxSelect = driver.findElements(
				By.xpath("//input[@class='form-check-inpu calimg calitem input-group-app end checkboxitem']"));
		// Add member
		String[] updategroupsnamedAdd = { "Matters Group", "Teams", "Test New group", "Example group" };
		Thread.sleep(4000);
		List<String> updategroupNames = Arrays.asList(updategroupsnamedAdd);

		// String names = "Criminal Case custody";
		// int j = 0;
		for (int i = 0; i < ListofGroupNameText.size(); i++) {
			String groupNameText = ListofGroupNameText.get(i).getText();
			if (updategroupNames.contains(groupNameText)) {
				// j++;
				Thread.sleep(3000);
				WebElement checkboxSelectedGroupName = checkboxSelect.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedGroupName);

//				if (j == updategroupNames.size()) {
//					break;
//
//				}
			}
		}

		Thread.sleep(5000);
		
//		// Selected GroupName Text
//		List<WebElement> selectedgroupnametext = driver
//				.findElements(By.xpath("//div[@class='multicheck form-control textbox active']//div"));
//
//		// Selected box to uncheck
//		List<WebElement> checkboxSelected = driver
//				.findElements(By.xpath("//div[@class='multicheck form-control textbox active']//input"));
//		System.out.println("done");
//
//		// Add member
//		String[] unselectGroupName = { "Case 2", "Case 1", "GroupHeadSample" };
//		Thread.sleep(4000);
//		List<String> unselectGroupNames = Arrays.asList(unselectGroupName);

//		int k = 0;
//		for (int i = 0; i < selectedgroupnametext.size(); i++) {
//			String groupsNameTexts = selectedgroupnametext.get(i).getText();
//			if (updategroupNames.contains(groupsNameTexts)) {
//				k++;
//				Thread.sleep(3000);
//				WebElement unSelectedGroupName = checkboxSelected.get(i);
//
//				JavascriptExecutor executor = (JavascriptExecutor) driver;
//				executor.executeScript("arguments[0].click();", unSelectedGroupName);
//
//				if (k == unselectGroupNames.size()) {
//					break;
//
//				}

				// Cancel
				// driver.findElement(By.xpath("//button[@class='btn btn-default btncancel']")).click();

				// Save
				// driver.findElement(By.xpath("//button[@class='btn btn-default btnsave']")).click();

				// SUccess popup close button
				// driver.findElement(By.xpath("//button[@class='btn-close
				// pull-right']")).click();

			}
		
}
