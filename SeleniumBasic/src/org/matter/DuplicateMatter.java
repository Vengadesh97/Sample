package org.matter;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DuplicateMatter {

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

		Thread.sleep(3000);

		// Left side Tab
		driver.findElement(By.xpath("(//div //img[@class='mattersicon'])[1]")).click();

		Thread.sleep(3000);
		// Create Tab
		driver.findElement(By.xpath("//a[text()='Create']")).click();

		// Case Title
		driver.findElement(By.id("title")).sendKeys("Names");

		// Case Number
		driver.findElement(By.name("case_number")).sendKeys("F34");

		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(1000);

		// Scroll down till the bottom of the page
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		// Scroll Down
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

		Thread.sleep(3000);
		// Save[Next]
		driver.findElement(By.xpath("//span[@class='ng-star-inserted']")).click();

		Thread.sleep(3000);

		// All Groups Name
		List<WebElement> listOfGroupsName = driver.findElements(By.xpath("//div //div[@class='callselect']"));

		// CheckBox
		List<WebElement> checkboxSelect = driver.findElements(By.xpath("//*[@id='flexCheckDefault']"));

		int j = 0;

		String[] groupNames = { "Traffic Violation Law", "New Release Test Group", "Apple Inc" };

		List<String> groupNameSelect = Arrays.asList(groupNames);

		for (int i = 0; i < listOfGroupsName.size(); i++) {
			String textGroups = listOfGroupsName.get(i).getText();

			if (groupNameSelect.contains(textGroups)) {
				j++;
				Thread.sleep(3000);
				WebElement checkboxSelectedGroupName = checkboxSelect.get(i);

				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", checkboxSelectedGroupName);

				Thread.sleep(3000);

				if (j == groupNameSelect.size()) {
					break;

				}

			}

			List<WebElement> nameAppear = driver.findElements(By.xpath("//div[@class='form-control textbox']"));

			for (int z = 0; z < nameAppear.size(); z++) {
				String selectedName = nameAppear.get(z).getText();

				Thread.sleep(3000);
				if (groupNameSelect.contains(selectedName)) {

					System.out.println("Selected");
				} else {
					System.out.println("Not selected");
				}

			}

		}

	}

}








/*
 * 
 * 
 * //Groups
 * 
 * //using class name to fetch the group of multiple checkboxes List<WebElement>
 * checkboxes = driver.findElements(By.xpath("//div[@class='callselect']"));
 * 
 * // traverse through the list and select all checkboxes if they are enabled
 * and // displayed. // for(int i=0; i<checkboxes.size(); i++) // { //
 * if(checkboxes.get(i).isDisplayed() && checkboxes.get(i).isEnabled()) // { //
 * System.out.println("Checkbox is displayed at index : " + i +
 * " Clicking on it now"); // Thread.sleep(2000); // checkboxes.get(i).click();
 * // } // }
 * 
 * // deselect the checkbox on index 1 from the list of checkboxes selected
 * above
 * System.out.println("de-selecting checkbox with index 1");checkboxes.get(1).
 * click();if(checkboxes.get(1).isSelected()) {
 * System.out.println("Checkbox is still selected"); }else {
 * System.out.println("Checkbox is deselected successfully"); }
 * 
 */