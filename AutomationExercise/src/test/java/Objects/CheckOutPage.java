package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void CheckOut(String name,String cardnumber,String cvc,String month,String year) throws InterruptedException {
		
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
		 driver.findElement(By.cssSelector("textarea[name='message']")).sendKeys("comment");
		 driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		
		 WebElement cardName = driver.findElement(By.cssSelector("input[name='name_on_card']"));
		 WebElement cardNumber = driver.findElement(By.cssSelector("input[name='card_number']"));
		 WebElement cardCvc = driver.findElement(By.cssSelector(".form-control.card-cvc"));
		 WebElement cardMonth = driver.findElement(By.cssSelector(".form-control.card-expiry-month"));
		 WebElement cardYear = driver.findElement(By.cssSelector(".form-control.card-expiry-year"));
		cardName.sendKeys(name);
		cardNumber.sendKeys(cardnumber);
		cardCvc.sendKeys(cvc);
		cardMonth.sendKeys(month);
		cardYear.sendKeys(year);
		driver.findElement(By.cssSelector("#submit")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
	}
	

}
