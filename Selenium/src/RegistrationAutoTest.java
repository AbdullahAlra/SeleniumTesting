
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
public class RegistrationAutoTest {
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
	//1 -  Test if the browser is opening the automationpractice.com page
	public void testwebsite() {

		
		//1.1 - specifying the web site to be tested 
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

		
		//1.2 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "http://automationpractice.com/index.php";
		actualResult = driver.getCurrentUrl();
		assertEquals(expectedResult, actualResult);

	}
    
	@Test
	@Order(2) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9491)
	//2 -  Test the sign in button that takes to the signup page: 
	public void signInButtonTest() {

		//2.1 - wait untill the "login" button is visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//2.2 - locate "login" button and click on it:
		driver.findElement(By.className("login")).click();
			
		//2.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		actualResult = driver.getCurrentUrl();
		expectedResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		assertEquals(expectedResult, actualResult);
	}

	
	@Test
	@Order(3) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9506)
	//3 - Test the registration email field:
	public void registerTest() {

		//3.1 - wait until the email field is visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//3.2 - Locate the email field. 
		WebElement FieldTest = driver.findElement(By.id("email_create"));
		
		//3.3 - after locating the email field, insert the given email: 
		driver.findElement(By.id("email_create")).sendKeys("11@stucnydnet.com");
		
		//3.4 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "11@gmail.com";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
		
	}
	
	
	
	@Test
	@Order(4) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9508)
	// 4 - Test the registration button:
	public void registerButtonTest() {

		//4.1 - wait until the button is visible and wait for the email to be inserted: 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//4.2 - Click on submit to start the registration process: 
		driver.findElement(By.xpath("//*[@id=\"SubmitCreate\"]")).click();
				
		//4.3 - checks if the test passes and the account is registered,and checks if the URL is as expected		
		actualResult = driver.getTitle();
		expectedResult = "Login - My Store";
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	
	@Test
	@Order(5) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9509)
	//5 - Test the radio button to choose gender:
	public void radioButtonTest() {

		//5.1 - wait until radio button is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//5.2 - click on radio button to choose gender kind.
		WebElement radio1 = driver.findElement(By.id("id_gender1"));
		radio1.click();
		
		
		//checking to see the above test was executed properly and see if the expected result equals the actual:
		actualResult = radio1.getAttribute("true");
		assertEquals(expectedResult, actualResult);
			
		
		
		
		
	}
	
	@Test
	@Order(6) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9507)
	//6 - Test the first name field 
	public void nameFieldTest() {

		//6.1 - wait until the customer first name field is  visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//6.2 - locate the the customer first name field, and insert the given name
		WebElement FieldTest = driver.findElement(By.id("customer_firstname"));
		driver.findElement(By.id("customer_firstname")).sendKeys(" ");
		
		
		//6.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = " ";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(7) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9512)
	//7 - Test the last name field 
	public void lastNameFieldTest() {

		//7.1 - wait until the customer first name field is  visible
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//7.2 - locate the the customer first name field, and insert the given name
		WebElement FieldTest = driver.findElement(By.id("customer_lastname"));
		driver.findElement(By.id("customer_lastname")).sendKeys("alrasheed");
		
		
		//7.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "alrasheed";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	
	@Test
	@Order(8) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9513)
	//8 - Test the password field:
	public void passwordTest() {

		//8.1 - wait until password field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//8.2 - locate the password field, and insert the given password
		WebElement FieldTest = driver.findElement(By.xpath("//*[@id=\"passwd\"]"));
		driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("123123");
		
		//8.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "123123";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(9) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9515)
	//9 - Test the month drop down menu: 
	public void monthSelectionTest() {

		//9.1 - calling and importing Select library, and locating the month's drop down menu  
		WebElement dobM = driver.findElement(By.xpath("//*[@id=\"months\"]"));
		//9.2 - initiating a variable from the Select library
		Select dobDrop = new Select(dobM);
		//9.3 selecting the month by the value "2" which "February" 
		dobDrop.selectByValue("2");
				
		//9.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
		expectedResult = "2";
		actualResult = dobM.getAttribute("value");
		assertEquals(expectedResult, actualResult);
		

	}
	
	@Test
	@Order(10) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9516)
	//10 - Test the day drop down menu: 
	public void daySelectionTest() {

		//10.1 - calling and importing Select library, and locating the day's drop down menu  
		WebElement dobD = driver.findElement(By.xpath("//*[@id=\"days\"]"));
		//10.2 - initiating a variable from the Select library
		Select dobDDrop = new Select(dobD);
		//10.3 - selecting the day by the value "2" which is the second of the day 
		dobDDrop.selectByValue("2");
				
		//10.4 - checking to see the above test was executed properly and see if the expected result equals the actual:	
		expectedResult = "2";
		actualResult = dobD.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(11) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9517)
	//11 - Test the year drop down menu
	public void yearSelectionTest() {

		//11.1 - calling and importing Select library, and locating the year's drop down menu  
		WebElement dobY = driver.findElement(By.xpath("//*[@id=\"years\"]"));
		//11.2 - initiating a variable from the Select library
		Select dobYDrop = new Select(dobY);
		//11.3 - selecting the year by the value "2019" 
		dobYDrop.selectByValue("2019");
		
				
		//11.4 - checking to see the above test was executed properly and see if the expected result equals the actual:		
		expectedResult = "2019";
		actualResult = dobY.getAttribute("value");
		assertEquals(expectedResult, actualResult);;
	}
	
	
	
	@Test
	@Order(12) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9518)
	//12 - Test the address name field: 
	public void addressNameTest() {

		
		
		//12.1 - wait until first name field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//12.2 - locating first name field, and inserting the text	
		WebElement FieldTest = driver.findElement(By.id("firstname"));
		driver.findElement(By.id("firstname")).sendKeys("abdullah");
		
		//12.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "abdullah";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	
	@Test
	@Order(13) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9519)
	//13 - Test the last name in the address field:
	public void addressLastNameTest() {

		
		//13.1 - wait until last name field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//13.2 - locating the last name field and inserting the given text	
		WebElement FieldTest = driver.findElement(By.id("lastname"));
		driver.findElement(By.id("lastname")).sendKeys("alrasheed");
		
		//13.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "alrasheed";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(14) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9520)
	//14 - Test the address of house field:
	public void addressTest() {

		
		//14.1 - wait until address field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//14.2 - locate the address field and insert the given address 
		WebElement FieldTest = driver.findElement(By.id("address1"));
		driver.findElement(By.id("address1")).sendKeys("southbank");
		
		//14.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "southbank";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);			
	}
	
	
	
	@Test
	@Order(15) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9521)
	//15 - Test the city name field:
	public void cityTest() {

		//15.1 - wait until the city field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//15.2 - locate the city field and insert the given city
		WebElement FieldTest = driver.findElement(By.id("city"));
		driver.findElement(By.id("city")).sendKeys("Melbourne");
		
		//15.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "Melbourne";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(16) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9522)
	//16 - Test the state selection drop down menu
	public void stateSelectionTest() {


		//16.1 - initiating a new variable from the driver, and finding the state drop down menu
		WebElement FieldTest = driver.findElement(By.name("id_state"));
		//16.2 - initiating a variable from the select Library
		Select stateDrop = new Select(FieldTest);
		//16.3 - Selecting value "2" from the state drop down menu
		stateDrop.selectByValue("2");
		
		//16.4 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "2";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
		
	}
	
	

	@Test
	@Order(17) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9523)
	//17 - Test the post code field:
	public void postcodeTest() {

		
		//17.1 - wait until post code field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//17.2 - locating the post code field and inserting the given post code
		WebElement FieldTest = driver.findElement(By.id("postcode"));
		driver.findElement(By.id("postcode")).sendKeys("12345");
		
		//17.3 - checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "12345";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(18) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9524)
	//18 - Test the phone number field:
	public void phoneNumberTest() {

		
		//18.1 - wait until the phone number field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//18.2 -locating the phone number field and inserting the given number 
		WebElement FieldTest = driver.findElement(By.id("phone_mobile"));
		driver.findElement(By.id("phone_mobile")).sendKeys("874585");
		
		//18.3 - checking to see the above test was executed properly and see if the expected result equals the actual:

		expectedResult = "8745894";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(19) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9525)
	//19 - Test the alias address:
	public void aliasAddressTest() {

		
		//19.1 - wait until the alias address field is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//19.2 - locating the address alias field and inserting the given email address 
		WebElement FieldTest = driver.findElement(By.id("alias"));
		driver.findElement(By.id("alias")).sendKeys("asd@gmail.com");
		
		//19.3 -  checking to see the above test was executed properly and see if the expected result equals the actual:
		expectedResult = "asd@gmail.com";
		actualResult = FieldTest.getAttribute("value");
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	@Test
	@Order(20) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9526)
	//20 - Test the submit button:
	public void submitButtomTest() {

		
		//20 - locating the submit button, and clicking on it
		driver.findElement(By.id("submitAccount")).click();

				
		//20.1 -  checking to see the above test was executed properly and see if the expected result equals the actual:		
		actualResult = driver.getTitle();
		expectedResult = "My account - My Store";
		assertEquals(expectedResult, actualResult);
	}
	
	
	
	
	
	@Test
	@Order(21) // << the order of the test, so this test-case is running as second
	@SpiraTestCase(testCaseId = 9891)
	//21 - Test the log out button:
	public void logOutTest() {

		//21.1 - wait until the logout button is visible 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//21.2 - locating the locate the shirts tab and click on it 
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")).click();
				
				
		//22.3 -  checking to see the above test was executed properly and see if the expected result equals the actual:	
		actualResult = driver.getCurrentUrl();
		expectedResult = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		assertEquals(expectedResult, actualResult);
	}
	

		
	@AfterAll
	// closing or quitting the browser after the test
	public static void closeBrowser() {
		driver.close();
		driver.quit();
	}
}
