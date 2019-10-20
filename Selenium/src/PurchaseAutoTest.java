
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.inflectra.spiratest.addons.junitextension.SpiraTestCase;
import com.inflectra.spiratest.addons.junitextension.SpiraTestConfiguration;






@SpiraTestConfiguration(
		// SpiraTeam Credentials:  Used to connect to my account 
		url = "URL",
		login = "333333333", 
		rssToken = "{rss rssToken hidden}", 
		projectId = 111,
		password = "password"

)
@TestMethodOrder(OrderAnnotation.class) // << this annotation is for using @order, or adding order to my test-cases
public class PurchaseAutoTest {
	//Initialization of variables used through out the test cases: 
	private static ChromeDriver driver;
	private String expectedResult;
	private String actualResult;
	

	@BeforeAll
	// setup my driver here through @BeforeAll, this method is running once before
	// all test-cases
	public static void setup() {
		
		// chrome driver initialization and location:
		
		System.setProperty("webdriver.chrome.driver","chromedriver");
		

		driver = new ChromeDriver();

	}
	@Test
	@Order(1) // << the order of the test, so this test-case is running as first
	@SpiraTestCase(testCaseId = 9441)
	//1 - Test if the browser is openning the automationpractice.com page
	public void testwebsite() {
		//1.1 - checks if it opens the website page 
		driver.get("http://automationpractice.com/index.php");

		//1.2 - Specifies the amount of time the driver should wait when searching
		// for an element if it is not immediately present. ( same as thread sleep but
		// in the right way)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // << I asked wait maximum for 5 seconds for the next
		
		//1.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "http://automationpractice.com/index.php";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	@Order(2) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9491)
	//2 - Test the login button, and check if it redirects the page to login page 
	public void signInButtonTest() {

		//2.1 - wait until the "login" button is visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//2.3 - locate "login" button and click on it:
		driver.findElement(By.className("login")).click();
		//2.4 - checking to see the above test was executed properly and see if the expected result equals the actual:
		actualResult = driver.getCurrentUrl();
		expectedResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		assertEquals(expectedResult, actualResult);
	}


@Test
@Order(3) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9892)
//3 - Test the login fields
public void loginTest() {

	//3.1 - wait until the log in fields are visible 
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	//3.2 - locate login fields and insert data 
	driver.findElement(By.id("email")).sendKeys("11@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("123123");
	
	//3.3 - submit login button
	driver.findElement(By.name("SubmitLogin")).click();	
	

			
	//3.4 - checking to see the above test was executed properly and see if the expected result equals the actual: 		
	actualResult = driver.getCurrentUrl();
	expectedResult = "http://automationpractice.com/index.php?controller=my-account";
	assertEquals(expectedResult, actualResult);
	
}

@Test
@Order(4) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9527)
//4 - Test the shirts tab
public void dressesTabTest() {

	//4.1 - wait until the shirts tab is visible  
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//4.2 - locating the locate the shirts tab and click on it 
	driver.findElement(By.cssSelector("a[class='sf-with-ul']")).click();
			
	//4.3 - checking to see the above test was executed properly and see if the expected result equals the actual:		
	actualResult = driver.getCurrentUrl();
	expectedResult = "http://automationpractice.com/index.php?id_category=3&controller=category";
	assertEquals(expectedResult, actualResult);
}


@Test
@Order(5) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9530)
//5 - Test the function of adding a product to cart
public void chooseProductTest() {
	

	//5.1 - wait for the page to load:
	WebDriverWait wait = new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")));
	//5.2 - locating the button to add to cart
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).click();
			
			
	//5.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
	actualResult = driver.getCurrentUrl();
	 expectedResult = "http://automationpractice.com/index.php?id_product=1&controller=product";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(6) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9534)
//6 - test the button to confirm adding to cart
public void addToCartTest() {

	
	//6.1 - locate the button and add to cart
	driver.findElement(By.id("add_to_cart")).click();
	
	//6.2 - checking to see the above test was executed properly and see if the expected result equals the actual:		
	 actualResult = driver.getCurrentUrl();
	 expectedResult = "http://automationpractice.com/index.php?id_product=1&controller=product";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(7) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9535)
//7 - Test checkout process step 2 
public void checkout2Test() {

	//7.1 - locate the "proceed to checkout button and click on it again
	driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a")).click();
			
	//7.2 - checking to see the above test was executed properly and see if the expected result equals the actual:		
	actualResult = driver.getCurrentUrl();
	expectedResult = "http://automationpractice.com/index.php?controller=order";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(8) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9536)
//8 - Test checkout and proceed step 3
public void checkAndProceedTest() {

	//8.1 - check if the home address is correct and locate the proceed to checkout button 
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]")).click();
			
			
	//8.2 - checking to see the above test was executed properly and see if the expected result equals the actual:	
	actualResult = driver.getCurrentUrl();
	expectedResult = "http://automationpractice.com/index.php?controller=order&step=1";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(9) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9537)
//9 - Test the "agree on terms and conditions" check box
public void checkboxTest() {


	//9.1 - locate the check box and check it
	driver.findElement(By.xpath("//*[@id=\"center_column\"]/form/p/button")).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	WebElement elementToClick = driver.findElement(By.id("cgv"));
	elementToClick.click();
	
	
			
	//9.2 - checking to see the above test was executed properly and see if the expected result equals the actual:		
	actualResult = driver.getTitle();
	expectedResult = "Order - My Store";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(10) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9539)
//10 - Test the final checkout step
public void finalCheckoutTest() {

	//10.1 - wait until click on agree terms is done  
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//10.2 - locate the final checkout button and click it
	driver.findElement(By.xpath("//*[@id=\"form\"]/p/button")).click();
	
			
			
	//10.3 - checking to see the above test was executed properly and see if the expected result equals the actual:	
	 actualResult = driver.getTitle();
	 expectedResult = "Order - My Store";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(11) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9540)
//11.1 - Test the payment method
public void paymentMethodTest() {

	//11.1 - wait until types of payments is displayed
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//11.2 - locate the type of payment method and click on it 
	driver.findElement(By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[1]/div/p/a")).click();
			
	
			
			
	//11.3 - checking to see the above test was executed properly and see if the expected result equals the actual:	
	 actualResult = driver.getTitle();
	 expectedResult = "My Store";
	assertEquals(expectedResult, actualResult);
}

@Test
@Order(12) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9541)
//12 - Test the confirmation button
public void confirmationTest() {

	//12.1 - wait until confirmation page is displayed 
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//12.2 - locate the confirmation button and click on it  
	driver.findElement(By.xpath("//*[@id=\"cart_navigation\"]/button")).click();
	
	//12.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
	 actualResult = driver.getTitle();
	 expectedResult = "Order confirmation - My Store";
	assertEquals(expectedResult, actualResult);

}
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
