package Test_Scenarios;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Objects.CartPage;
import Objects.CheckOutPage;
import Objects.ContactUsPage;
import Objects.HomePage;
import Objects.ProductsPage;
import Objects.SignupAndLoginPage;
import Objects.TestCasesPage;



public class TestMethods {
	
	WebDriver driver;
	
	@BeforeTest
	public void beforetest() {
	
	System.setProperty("Webdriver.chrome.driver","C:\\Users\\w10\\Downloads\\chromedriver_win32.exe");
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--remote-allow-origins=*");
	 driver = new ChromeDriver(options);
	driver.get("https://www.automationexercise.com/");
	driver.manage().window().maximize();
	}
	
	@Test (priority=1)
	public void signupTest() throws InterruptedException {
	SignupAndLoginPage signupform = new SignupAndLoginPage(driver);
	signupform.GoToLoginPage();
	signupform.SignupForm("bengisu", "bengisu1@gmail.com");
	SignupAndLoginPage signupandlogin = new SignupAndLoginPage (driver);
	signupandlogin.Signup( "12345"," 27", "May", "1996", "bengisu", "yildirim"," test", "Street 1,0675,Test", "Street 2,0675,Test"," Canada"," State", "City"," 123", "123456789");
	SignupAndLoginPage accountdelete = new SignupAndLoginPage(driver);
	accountdelete.AccountDelete();
	}
	
	@Test (priority=2)
	public void successfulLoginTest() {
	SignupAndLoginPage successfullogin = new SignupAndLoginPage(driver);
	successfullogin.GoToLoginPage();
	successfullogin.SuccessfulLogin("bengisu@gmail.com", "12345");
	SignupAndLoginPage logout = new SignupAndLoginPage(driver);
	logout.LogOut();
	HomePage goHome = new HomePage(driver);
	goHome.GoToHomePage();
	

	}
	
	@Test (priority=3)
	public void unsuccessfulLoginTest() {
		SignupAndLoginPage unsuccessfullogin = new SignupAndLoginPage(driver);
		unsuccessfullogin.GoToLoginPage();
		unsuccessfullogin.UnsuccessfulLogin("incorrect@gmail.com", "12345");
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
		
	}
	
	@Test (priority=4)
	public void ContactUsTest() throws InterruptedException {
	ContactUsPage contactUs = new ContactUsPage(driver);
	contactUs.GoToContactUsPage();
	contactUs.ContactUs("bengisu", "bengisu@gmail.com", "Subject", "message");
	JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollBy(0,-500)");
	HomePage goHome = new HomePage(driver);
	goHome.GoToHomePage();
}
	
	@Test (priority=5)
	public void TestCasesTest() {
		TestCasesPage testCases = new TestCasesPage(driver);
		testCases.GoToTestCasesPage();
		testCases.TestCases();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=6)
	public void ProductsVisibityTest() throws InterruptedException {
		ProductsPage productspage = new ProductsPage(driver);
		productspage.GoToProductsPage();
		productspage.ProductsVisibility();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=7)
	public void ProductSearchTest() {
		ProductsPage searchproduct = new ProductsPage(driver);
		searchproduct.GoToProductsPage();
		searchproduct.SearchProduct("top");
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=8)
	public void AddProductsTest() throws InterruptedException {
		ProductsPage addproducts = new ProductsPage(driver);
		addproducts.GoToProductsPage();
		addproducts.AddProducts();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	
	@Test (priority=9)
	public void BrandsVisibilityTest() throws InterruptedException {
		ProductsPage brandsvisibility = new ProductsPage(driver);
		brandsvisibility.GoToProductsPage();
		brandsvisibility.BrandsVisibility();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=10)
	public void AddReviewTest() throws InterruptedException {
		ProductsPage addreview = new ProductsPage(driver);
		addreview.GoToProductsPage();
		addreview.AddReview("bengisu", "bengisu1@gmail.com", "review");
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=11)
	public void SubscriptionTest() {
		HomePage subscriptionverify =new HomePage(driver);
		subscriptionverify.Subscription("bengisu@gmail.com");
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=12)
	public void ProductQuantityTest() throws InterruptedException {
		HomePage productquantity = new HomePage(driver);
		productquantity.ProductQuantity();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=13)
	public void CatagoryViewTest() throws InterruptedException {
		HomePage catagoryview = new HomePage(driver);
		catagoryview.CatagoryView();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	
	@Test (priority=14)
	public void AddRecommendedItemsTest() {
		HomePage addrecommendedItem = new HomePage(driver);
		addrecommendedItem.addRecommendedItems();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=15)
	public void CartSubscriptionTest() {
		CartPage cartSubscription = new CartPage(driver);
		cartSubscription.GoToCartPage();
		cartSubscription.Subscription("bengisu@gmail.com");
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=16)
	public void RemoveItemTest() throws InterruptedException {
		CartPage removeitem = new CartPage(driver);
		removeitem.RemoveItem();
		HomePage goHome = new HomePage(driver);
		goHome.GoToHomePage();
	}
	
	@Test (priority=17)
	public void RegisterWhileCheckOutTest() throws InterruptedException {
		ProductsPage addProduct = new ProductsPage(driver);
		addProduct.GoToProductsPage();
		addProduct.AddProducts();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		driver.findElement(By.xpath("//u[normalize-space()='Register / Login']")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,300)");
		SignupAndLoginPage signup = new SignupAndLoginPage(driver);
		signup.SignupForm("bengisu", "bengisu1@gmail.com");
		signup.Signup( "12345"," 27", "May", "1996", "bengisu", "yildirim"," test", "Street 1,0675,Test", "Street 2,0675,Test"," Canada"," State", "City"," 123", "123456789");
		CartPage cart = new CartPage(driver);
		cart.GoToCartPage();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		CheckOutPage registerWhileCheckout = new CheckOutPage(driver);
		registerWhileCheckout.CheckOut("bengisu", "123456789", "123", "05", "2027");
		SignupAndLoginPage deleteaccount = new SignupAndLoginPage(driver);
		deleteaccount.AccountDelete();
		
	}
	
	@Test (priority=18)
	public void RegisterBeforeCheckOutTest() throws InterruptedException {
		SignupAndLoginPage signup = new SignupAndLoginPage(driver);
		signup.GoToLoginPage();
		signup.SignupForm("bengisu", "bengisu1@gmail.com");
		signup.Signup( "12345"," 27", "May", "1996", "bengisu", "yildirim"," test", "Street 1,0675,Test", "Street 2,0675,Test"," Canada"," State", "City"," 123", "123456789");
		ProductsPage addProduct = new ProductsPage(driver);
		addProduct.GoToProductsPage();
		addProduct.AddProducts();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		CartPage cart = new CartPage(driver);
		cart.GoToCartPage();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		CheckOutPage registerBeforeCheckout = new CheckOutPage(driver);
		registerBeforeCheckout.CheckOut("bengisu", "123456789", "123", "05", "2027");
		SignupAndLoginPage deleteaccount = new SignupAndLoginPage(driver);
		deleteaccount.AccountDelete();	
		
	}
	
	
	@Test (priority=19)
	public void LoginBeforeCheckOutTest() throws InterruptedException {
		SignupAndLoginPage login = new SignupAndLoginPage(driver);
		login.GoToLoginPage();
		login.SuccessfulLogin("bengisu@gmail.com", "12345");
		ProductsPage addProduct = new ProductsPage(driver);
		addProduct.GoToProductsPage();
		addProduct.AddProducts();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		CartPage cart = new CartPage(driver);
		cart.GoToCartPage();
		driver.findElement(By.cssSelector(".btn.btn-default.check_out")).click();
		CheckOutPage loginBeforeCheckout = new CheckOutPage(driver);
		loginBeforeCheckout.CheckOut("bengisu", "123456789", "123", "05", "2027");
		SignupAndLoginPage logout = new SignupAndLoginPage(driver);
		logout.LogOut();
	}
	
	
	
	@AfterTest
	public void aftertest() {
		driver.quit();
	}
	
	
	
	}
	


