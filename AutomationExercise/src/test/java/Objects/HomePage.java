package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void GoToHomePage() {
		driver.findElement(By.xpath("//a[normalize-space()='Home']")).click();
	}
	
	public void Subscription(String email) {
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,8500)");
	    
	    WebElement userEmail = driver.findElement(By.id("susbscribe_email"));
	    userEmail.sendKeys(email);
	    driver.findElement(By.id("subscribe")).click();
	    
	    String message = driver.findElement(By.xpath("//*[text()='You have been successfully subscribed!']")).getText();
	    message = message.replaceAll("�", "");
	    message = message.replaceAll("\\P{Print}", "");
	    String expectedMessage = "You have been successfully subscribed!";
	    if(expectedMessage.equalsIgnoreCase(message)) {
	    	System.out.println(message);
	    	Assert.assertEquals(expectedMessage, message);
	    }
	    
	    
	}
	
		public void ProductQuantity() throws InterruptedException {
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			driver.findElement(By.cssSelector("a[href='/product_details/3']")).click();
			WebElement quantityInput = driver.findElement(By.id("quantity"));
			Actions actions = new Actions(driver);
			actions.moveToElement(quantityInput).click().perform();
			WebElement quantityInput1 = driver.findElement(By.id("quantity"));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			String input = "4";
			js1.executeScript("arguments[0].value = arguments[1];", quantityInput1, input);
			
			driver.findElement(By.cssSelector("button[type='button']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
			
			WebElement quant = driver.findElement(By.cssSelector(".disabled"));
			String number = quant.getText();
			Assert.assertEquals(number, input);
		
		
		
		
	}
		
		
		public void CatagoryView() throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,300)");
			
			List<WebElement> catagory = driver.findElements(By.xpath("//div[@id='accordian']"));
			boolean allVisible = catagory.stream().allMatch(WebElement::isDisplayed);
			if (allVisible) 
			{
			    System.out.println("Whole list related to the catagory are visible");
			} 
			else 
			{
			    System.out.println("Some of them related to the catagory are not visible");
			}
			
			
			driver.findElement(By.xpath("//a[normalize-space()='Women']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='Women']//a[contains(text(),'Dress')]")).click();
			
			List<WebElement> allproducts = driver.findElements(By.xpath("//div[@class='features_items']"));
			boolean allVisibleproducts = allproducts.stream().allMatch(WebElement::isDisplayed);
			if (allVisibleproducts) 
			{
			    System.out.println("All products related to the catagory are visible");
			} 
			else 
			{
			    System.out.println("Some products related to the catagory are not visible");
			}
			
			String title = driver.findElement(By.xpath("//h2[normalize-space()='Women - Dress Products']")).getText();
			title = title.replaceAll("�", "");
			title = title.replaceAll("\\P{Print}", "");
			String expectedTitle = "WOMEN - DRESS PRODUCTS";
			if(expectedTitle.equalsIgnoreCase(title)) {
				System.out.println(title);
				Assert.assertEquals(expectedTitle, title);
			}
			
			
			
		}
		
		public void addRecommendedItems() {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			
			String title = driver.findElement(By.xpath("//h2[normalize-space()='recommended items']")).getText();
			title = title.replaceAll("�", "");
			title = title.replaceAll("\\P{Print}", "");
			String expectedTitle = "RECOMMENDED ITEMS";
			if(expectedTitle.equalsIgnoreCase(title)) {
				System.out.println(title);
				Assert.assertEquals(expectedTitle, title);
			}
			
			driver.findElement(By.xpath("//div[@class='item active']//div[1]//div[1]//div[1]//div[1]//a[1]")).click();
			
		}
		
		
		

}
