package Objects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SignupAndLoginPage {
	
	WebDriver driver;
	
	public SignupAndLoginPage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	public void GoToLoginPage() {
		
		driver.findElement(By.cssSelector("a[href='/login']")).click();
	}
	
	// Sign up Page
	
	public void SignupForm(String name, String email) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
		WebElement signName = driver.findElement(By.name("name"));
		WebElement email_address = driver.findElement(By.cssSelector("input[data-qa='signup-email']"));
		signName.sendKeys(name);
		email_address.sendKeys(email);
		driver.findElement(By.cssSelector("button[data-qa='signup-button']")).click();
	}
	
	
	public void Signup(String password,String day,String month,String year,String firstname,String lastname,String company,String address1,String address2,String country,String state,String city,String zipcode,String mobilenumber) throws InterruptedException {
		
		
		
		driver.findElement(By.id("id_gender2")).click();
		WebElement userPassword = driver.findElement(By.id("password"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    WebElement daysDropdown = driver.findElement(By.id("days"));
		WebElement monthDropdown = driver.findElement(By.id("months"));
		WebElement yearsDropdown = driver.findElement(By.id("years"));	
		WebElement checkBox = driver.findElement(By.id("newsletter"));
		WebElement checkBox2 = driver.findElement(By.id("optin"));
		WebElement firstName = driver.findElement(By.id("first_name"));
		WebElement lastName = driver.findElement(By.id("last_name"));
		WebElement companyUser = driver.findElement(By.id("company"));
		WebElement userAddress1 = driver.findElement(By.id("address1"));
		WebElement userAddress2 = driver.findElement(By.id("address2"));
		js.executeScript("window.scrollBy(0,500)");
		WebElement countryDropdown = driver.findElement(By.name("country"));
		WebElement userState = driver.findElement(By.id("state"));
		WebElement userCity = driver.findElement(By.id("city"));
		WebElement userZipcode = driver.findElement(By.id("zipcode"));
		WebElement userMobileNumber = driver.findElement(By.id("mobile_number"));
		userPassword.sendKeys(password);
		daysDropdown.click();
		Select daySelect = new Select(daysDropdown);
		daySelect.selectByVisibleText(day);
		monthDropdown.click();
		Select monthSelect = new Select(monthDropdown);
		monthSelect.selectByVisibleText(month);
		yearsDropdown.click();
		Select yearSelect = new Select(yearsDropdown);
		yearSelect.selectByVisibleText(year);
		checkBox.click();
		checkBox2.click();
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		companyUser.sendKeys(company);
		userAddress1.sendKeys(address1);
		userAddress2.sendKeys(address2);
		js.executeScript("window.scrollBy(0,500)");
		countryDropdown.click();
		Select countrySelect = new Select(countryDropdown);
		countrySelect.selectByVisibleText(country);
		userState.sendKeys(state);
		userCity.sendKeys(city);
		userZipcode.sendKeys(zipcode);
		js.executeScript("window.scrollBy(0,300)");
		userMobileNumber.sendKeys(mobilenumber);
		
		driver.findElement(By.cssSelector("button[data-qa='create-account']")).click();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
		
		
		
		
	}
	
	
	
	
	public void SuccessfulLogin(String email,String password) {
		
		WebElement userEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		
		
		
	}
	
	
	public void UnsuccessfulLogin(String email,String password) {
		WebElement userEmail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		WebElement userPassword = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		userEmail.sendKeys(email);
		userPassword.sendKeys(password);
		
		driver.findElement(By.cssSelector("button[data-qa='login-button']")).click();
		
		String errorMessage = driver.findElement(By.xpath("//p[normalize-space()='Your email or password is incorrect!']")).getText();
		errorMessage = errorMessage.replaceAll("�", "");
		errorMessage = errorMessage.replaceAll("\\P{Print}", "");
		String expectedErrorMessage = "Your email or password is incorrect!";
		
		if(expectedErrorMessage.equalsIgnoreCase(errorMessage)) {
			System.out.println(errorMessage);
			Assert.assertEquals(expectedErrorMessage, errorMessage);
		}
		
		
		
		
	}
	
	
	public void AccountDelete() throws InterruptedException {
		 driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
		 driver.findElement(By.cssSelector(".btn.btn-primary")).click();
		
	}
	
	public void LogOut() {
		
		driver.findElement(By.cssSelector("a[href='/logout']")).click();
		
		
		
	}

}
