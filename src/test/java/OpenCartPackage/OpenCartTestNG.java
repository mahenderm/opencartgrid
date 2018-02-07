package OpenCartPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class OpenCartTestNG {
	WebDriver driver;
	OpenCartFunctions obj;

	@BeforeTest
    public void Openbrowser(){
		
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new ChromeDriver((capabilities));
		/*Maximize the window*/
		driver.manage().window().maximize();		
		obj = new OpenCartFunctions(driver);		
		driver.get("http://10.207.182.108:81/opencart/");
		String actTitle= driver.getTitle();
		String expTitle ="Your Store";
		//System.out.println("driver title : "+title);
		Assert.assertEquals(actTitle,expTitle ,"Open Cart Title not correct :");
		
	}
	@Test(priority=1)
	public void CreateAccount_01(){
		System.out.println("**********************1st TestCase **********************");
		obj.inputAccoutDetails();	
	}
	
	@Test(priority=2)
	public void LoginAccount_02(){
		System.out.println("**********************2nd TestCase **********************");
		obj.loginCart();
		obj.orderHistoryDetails();
	}
	
	@Test(priority=3)
	public void ProductComparison_03(){
		System.out.println("**********************3rd TestCase **********************");
		obj.loginCart();
		obj.Product_Comparison();	
	}
	
	@Test(priority=4)
	public void AddingPhones_04(){
		System.out.println("**********************4th TestCase **********************");
		obj.loginCart();
		obj.addingPhones();	
	}
	
	@AfterMethod
    public void logout(){
		obj.logoutCart();
	}
	
	@AfterTest
    public void Closebrowser(){
		driver.close();
	}
	
}
