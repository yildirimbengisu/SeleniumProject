package Objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class TestCasesPage {
	
	WebDriver driver;
	
	public TestCasesPage(WebDriver driver) {
		this.driver = driver;
	}
	
	@SuppressWarnings("deprecation")
	public void GoToTestCasesPage() {
		driver.findElement(By.cssSelector("header[id='header'] li:nth-child(5) a:nth-child(1)")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void TestCases() {
		
		String message = driver.findElement(By.xpath("//span[normalize-space()='Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:']")).getText();
		message = message.replaceAll("�", "");
		message = message.replaceAll("\\P{Print}", "");
		String expectedMessage = "Below is the list of test Cases for you to practice the Automation. Click on the scenario for detailed Test Steps:";
		if(expectedMessage.equalsIgnoreCase(message)) {
			System.out.println(message);
			Assert.assertEquals(expectedMessage, message);
		}
		
	}
	
	

}
