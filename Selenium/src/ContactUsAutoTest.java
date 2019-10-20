
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

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
public class ContactUsAutoTest {
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
	// Test the web site automationpractice.com
	public void testwebsite() {

		driver.get("http://automationpractice.com/index.php");

		// Specifies the amount of time the driver should wait when searching
		// for an element if it is not immediately present. ( same as thread sleep but
		// in the right way)
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // << I asked wait maximum for 5 seconds for the next
		/*
		 * Another wait method:
		 * Sets the amount of time to wait for a page load to 
		 * complete before throwing an error.If the timeout is 
		 * negative, page loads can be indefinite.
		 * driver.manage().timeouts().pageLoadTimeout(time, unit)																// element
		 */

		expectedResult = "http://automationpractice.com/index.php";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);

	}
	
	@Test
	@Order(1) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9491)
	//1 - Test the sign in button. 
	public void signInButtonTest() {

		//1.2 - wait untill the "login" button is visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//1.3 - locate "login" button and click on it:
		driver.findElement(By.className("login")).click();
		
		//1.4 - checking to see the above test was executed properly and see if the expected result equals the actual:
		 actualResult = driver.getCurrentUrl();
		 expectedResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		assertEquals(expectedResult, actualResult);
	}


@Test
@Order(2) // << the order of the test, so this test-case is running as second
@SpiraTestCase(testCaseId = 9892)
//2 - Test the log in button
public void loginTest() {

	//2.1 - wait until the log in fields are visible 
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	//2.2 - locate login fields and insert data 
	driver.findElement(By.id("email")).sendKeys("11@gmail.com");
	driver.findElement(By.id("passwd")).sendKeys("123123");
	//2.3 - submit login button
	driver.findElement(By.name("SubmitLogin")).click();	
	

			
	//2.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
	 actualResult = driver.getCurrentUrl();
	 expectedResult = "http://automationpractice.com/index.php?controller=my-account";
	assertEquals(expectedResult, actualResult);

}

	@Test
	@Order(3)
	@SpiraTestCase(testCaseId = 10127)
	//3 - Test the contact us feature: 
	public void contactUsTest() {

		//3.1 - wait until the contact us button is visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		//3.2 - locate the contact us button and click on it  
		driver.findElement(By.id("contact-link")).click();
	
		//3.3 - checking to see the above test was executed properly and see if the expected result equals the actual:		
		 actualResult = driver.getCurrentUrl();
		 expectedResult = "http://automationpractice.com/index.php?controller=contact";
		assertEquals(expectedResult, actualResult);

	}
	
	
	@Test
	@Order(4) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 10128)
	//4 - Test Subject Handling: 
	public void SubjectHandlingTest() {

		
		
		//4.1 - calling and importing Select library, and locating the subject handling drop down menu  
		WebElement sub = driver.findElement(By.id("id_contact"));
		//4.2 - initiating a variable from the Select library
		Select subDrop = new Select(sub);
		//4.3 selecting the subject by the value "2"  
		subDrop.selectByValue("2");
				
		//4.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
		expectedResult = "2";
		actualResult = sub.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	@Order(5) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 10129)
	//5 - Test order Ref drop-down menu:
	public void orderRefTest() {

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//5.1 - calling and importing Select library, and locating the subject handling drop down menu  
		WebElement sub = driver.findElement(By.name("id_order"));
		//5.2 - initiating a variable from the Select library
		Select subDrop = new Select(sub);
		//5.3 selecting the order by the value "2"  
		subDrop.selectByValue("136219");
						
		//4.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
		expectedResult = "136219";
		actualResult = sub.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(6) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 10131)
	//6 - Test product Ref Drop-down menu:
	public void productRefTest() {

		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//6.1 - calling and importing Select library, and locating the subject handling drop down menu  
		WebElement sub = driver.findElement(By.name("id_product"));
		//6.2 - initiating a variable from the Select library
		Select subDrop = new Select(sub);
		//6.3 selecting the product by the value "2"  
		subDrop.selectByValue("1");
								
		//6.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
		expectedResult = "1";
		actualResult = sub.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	@Order(7) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 10132)
	//7 - Test message box:
	public void messageTest() {

		
		//7.1 - locate the message box and insert the text
		WebElement FieldTest = driver.findElement(By.id("message"));
		driver.findElement(By.id("message")).sendKeys("Please tell me the expected delivery time");
		
		//7.2 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "Please tell me the expected delivery time";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
		
	}
	
	@Test
	@Order(8) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 11642)
	//8 - Test message box:
	public void sendButtonTest() {

		
	//8.1 - locate the message box and insert the text
	driver.findElement(By.xpath("//*[@id=\"submitMessage\"]")).click();
		
	//8.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
	 actualResult = driver.getCurrentUrl();
	 expectedResult = "http://automationpractice.com/index.php?controller=contact";
	assertEquals(actualResult, expectedResult);
	}
	
	
	
	
	
	
	
	
	
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
