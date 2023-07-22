package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CartPage {
	
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	public void GoToCartPage() {
		driver.findElement(By.cssSelector("body > header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")).click();
	}
	
	public void Subscription(String email) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,8500)");
	    
	    WebElement userEmail = driver.findElement(By.id("susbscribe_email"));
	    userEmail.sendKeys(email);
	    driver.findElement(By.id("subscribe")).click();
	    
	    String text = driver.findElement(By.xpath("//h2[normalize-space()='Subscription']")).getText();
	    text = text.replaceAll("�", "");
	    text = text.replaceAll("\\P{Print}", "");
	    String expectedText = "SUBSCRIPTION";
	    if(expectedText.equalsIgnoreCase(text)) {
	    	System.out.println(text);
	    	Assert.assertEquals(expectedText, text);
	    }
	}
	
	public void RemoveItem() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,500)");
		 WebElement element4 = driver.findElement(By.cssSelector("body section div[class='container'] div[class='row'] div[class='col-sm-9 padding-right'] div[class='features_items'] div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)")); 
	     ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));", element4);
	     
	     WebElement button = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)")); 
	     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	     Thread.sleep(1000);
	     driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
	     Thread.sleep(2000);
	     WebElement element5 = driver.findElement(By.cssSelector("body section div[class='container'] div[class='row'] div[class='col-sm-9 padding-right'] div[class='features_items'] div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
	     ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));", element5);
		Thread.sleep(2000);
	     WebElement button2 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)")); 
	     ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button2);
		
		
	     driver.findElement(By.cssSelector("body > header:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > ul:nth-child(1) > li:nth-child(3) > a:nth-child(1)")).click();
	     
	     driver.findElement(By.xpath("//tr[@id='product-1']//i[@class='fa fa-times']")).click();
	}
	

}
