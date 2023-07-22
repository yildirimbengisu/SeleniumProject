package Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUsPage {
	
	WebDriver driver;
	
	public ContactUsPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public void GoToContactUsPage() {
		
		driver.findElement(By.cssSelector("a[href='/contact_us']")).click();
		
	}
	
	public void ContactUs(String name,String email,String subject,String message) throws InterruptedException {
		
		WebElement userName = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		WebElement userEmail = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		WebElement subjectBox = driver.findElement(By.xpath("//input[@placeholder='Subject']"));
		WebElement messageBox = driver.findElement(By.id("message"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,250)");
	    Thread.sleep(2000);
	    WebElement uploadFile = driver.findElement(By.name("upload_file"));
	    userName.sendKeys(name);
	    userEmail.sendKeys(email);
	    subjectBox.sendKeys(subject);
	    messageBox.sendKeys(message);
        uploadFile.sendKeys("C:\\Users\\w10\\OneDrive\\Desktop\\test.docx");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        js.executeScript("window.scrollBy(0,-250)");
        driver.findElement(By.cssSelector(".btn.btn-success")).click();
        driver.navigate().back();
	}

}
