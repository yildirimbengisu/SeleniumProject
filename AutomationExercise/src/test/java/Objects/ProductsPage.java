package Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductsPage {
	
	WebDriver driver;
	
	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		
		
	}
	
	public void GoToProductsPage() {
		
		driver.findElement(By.cssSelector("a[href='/products']")).click();
	}
	
	public void ProductsVisibility() throws InterruptedException {
		
		WebDriverWait iframeWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        iframeWait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/product_details/1'")));

		//driver.navigate().back();     
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
		Thread.sleep(2000);
		driver.navigate().back();//closing the pop up ad
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
		WebElement productname = driver.findElement(By.xpath("//h2[normalize-space()='Blue Top']"));
		Assert.assertTrue(productname.isDisplayed());
		String text_pname = productname.getText();
		System.out.println(text_pname);
		WebElement catagory = driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']"));
		Assert.assertTrue(catagory.isDisplayed());
		String text_catagory = catagory.getText();
		System.out.println(text_catagory);
		WebElement price = driver.findElement(By.cssSelector("div[class='product-information'] span span"));
		Assert.assertTrue(price.isDisplayed());
		String text_price = price.getText();
		System.out.println(text_price);
		WebElement availability = driver.findElement(By.xpath("//b[normalize-space()='Availability:']"));
		Assert.assertTrue(availability.isDisplayed());
		String text_availability = availability.getText();
		System.out.println(text_availability);
		WebElement condition = driver.findElement(By.xpath("//b[normalize-space()='Condition:']"));
		Assert.assertTrue(condition.isDisplayed());
		String text_condition = condition.getText();
		System.out.println(text_condition);
		WebElement brand = driver.findElement(By.xpath("//b[normalize-space()='Brand:']"));
		Assert.assertTrue(brand.isDisplayed());
		String text_brand = brand.getText();
		System.out.println(text_brand);
	}
	
	public void SearchProduct(String search) {
		
		
		WebElement searchText = driver.findElement(By.id("search_product"));
		searchText.sendKeys(search);
		driver.findElement(By.id("submit_search")).click();
		List<WebElement> results = driver.findElements(By.xpath("//div[@class='col-sm-4']"));
		
		boolean allVisible = results.stream().allMatch(WebElement::isDisplayed);
		if (allVisible) 
		{
		    System.out.println("All products related to the search are visible");
		} 
		else 
		{
		    System.out.println("Some products related to the search are not visible");
		}
	}
	
	public void AddProducts() throws InterruptedException {
		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    driver.navigate().back(); //closing the pop up ad
	    js.executeScript("window.scrollBy(0,500)");
	    WebElement product1 = driver.findElement(By.cssSelector("body section div[class='container'] div[class='row'] div[class='col-sm-9 padding-right'] div[class='features_items'] div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)")); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));", product1);
        
        WebElement addCartButton1 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)")); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCartButton1);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[normalize-space()='Continue Shopping']")).click();
        Thread.sleep(2000);
        WebElement product2 = driver.findElement(By.cssSelector("body section div[class='container'] div[class='row'] div[class='col-sm-9 padding-right'] div[class='features_items'] div:nth-child(1) div:nth-child(1) div:nth-child(1) div:nth-child(1)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].dispatchEvent(new MouseEvent('mouseover', {bubbles: true}));", product2);
	
        WebElement addCartButton2 = driver.findElement(By.cssSelector("body > section:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > a:nth-child(3)")); 
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addCartButton2);
        
        Thread.sleep(2000);
        driver.findElement(By.xpath("//u[normalize-space()='View Cart']")).click();
        Thread.sleep(1000);
        
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Blue Top']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Men Tshirt']")).isDisplayed());
		
        WebElement product1price = driver.findElement(By.cssSelector("tr[id='product-1'] td[class='cart_price'] p"));
        String product1pricetext = product1price.getText();
        System.out.println(product1pricetext);
        WebElement product1quantity = driver.findElement(By.cssSelector("tr[id='product-1'] button[class='disabled']"));
        String product1quantitytext = product1quantity.getText();
        System.out.println(product1quantitytext);
        WebElement product1total = driver.findElement(By.cssSelector("tr[id='product-1'] td[class='cart_total']"));
        String product1totaltext = product1total.getText();
        System.out.println(product1totaltext);
        
        WebElement product2price = driver.findElement(By.cssSelector("tr[id='product-2'] td[class='cart_price'] p"));
        String product2pricetext = product2price.getText();
        System.out.println(product2pricetext);
        WebElement product2quantity = driver.findElement(By.cssSelector("tr[id='product-2'] button[class='disabled']"));
        String product2quantitytext = product2quantity.getText();
        System.out.println(product2quantitytext);
        WebElement product2total = driver.findElement(By.cssSelector("tr[id='product-2'] p[class='cart_total_price']"));
        String product2totaltext = product2total.getText();
        System.out.println(product2totaltext);
		
		
	}
	
	
	
	public void BrandsVisibility() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		List<WebElement> brands = driver.findElements(By.cssSelector(".brands-name"));
		boolean allVisible = brands.stream().allMatch(WebElement::isDisplayed);
		if (allVisible) 
		{
		    System.out.println("Brands are visible");
		} 
		else 
		{
		    System.out.println("Brands are not visible");
		}
		js.executeScript("window.scrollBy(0,500)");
		WebElement brand1 = driver.findElement(By.cssSelector("a[href='/brand_products/Polo']"));
		WebElement brand2 = driver.findElement(By.cssSelector("a[href='/brand_products/H&M']"));
		brand1.click();
		driver.navigate().back();//closing pop up ad
		brand2.click();
		
		List<WebElement> allproducts_brand1 = driver.findElements(By.cssSelector(".features_items"));
		boolean allVisiblebrand1 = allproducts_brand1.stream().allMatch(WebElement::isDisplayed);
		if (allVisiblebrand1) 
		{
		    System.out.println("All products related to the brand1 are visible");
		} 
		else 
		{
		    System.out.println("Some products related to the brand1 are not visible");
		}
		
		List<WebElement> allproducts_brand2 = driver.findElements(By.cssSelector(".features_items"));
		boolean allVisiblebrand2 = allproducts_brand2.stream().allMatch(WebElement::isDisplayed);
		if (allVisiblebrand2) 
		{
		    System.out.println("All products related to the brand2 are visible");
		} 
		else 
		{
		    System.out.println("Some products related to the brand2 are not visible");
		}
		
	}
		
		public void AddReview(String name,String email,String review) throws InterruptedException {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)");
			WebElement viewproduct = driver.findElement(By.cssSelector("a[href='/product_details/1']"));
			viewproduct.click();
			Thread.sleep(2000);
			driver.navigate().back();//closing pop up ad
			viewproduct.click();
			js.executeScript("window.scrollBy(0,500)");
			String reviewText = driver.findElement(By.cssSelector("a[href='#reviews']")).getText();
			reviewText = reviewText.replaceAll("�", "");
			reviewText = reviewText.replaceAll("\\P{Print}", "");
			String expectedReviewText = "WRITE YOUR REVIEW";
			if(expectedReviewText.equalsIgnoreCase(reviewText)) {
				System.out.println(reviewText);
				Assert.assertEquals(expectedReviewText, reviewText);
			}
			
			WebElement userName = driver.findElement(By.xpath("//input[@id='name']"));
			WebElement userEmail = driver.findElement(By.xpath("//input[@id='email']"));
			WebElement addReview = driver.findElement(By.xpath("//textarea[@id='review']"));
			userName.sendKeys(name);
			userEmail.sendKeys(email);
			addReview.sendKeys(review);
			driver.findElement(By.cssSelector("#button-review")).click();
			WebElement message = driver.findElement(By.xpath("//span[normalize-space()='Thank you for your review.']"));
			System.out.println(message.getText());
	}

}
