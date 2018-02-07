package OpenCartPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OpenCartFunctions {
	
	WebDriver driver;
	
	OpenCartFunctions(WebDriver driver){
		this.driver=driver;
	}
	String successMsg;

	public void inputAccoutDetails(){

		successMsg=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		 
		System.out.println("---inputAccoutDetails ---");
		/*Register page...*/
		WebElement user = driver.findElement(By.xpath("//a[contains(@href,'/register')]"));
		user.click();
		System.out.println("Entered Personal details ... ");		
		driver.findElement(By.name("firstname")).sendKeys("mahender");
		driver.findElement(By.name("lastname")).sendKeys("m");
		driver.findElement(By.name("email")).sendKeys("m.mahenderoii@wipro.com");
		driver.findElement(By.name("telephone")).sendKeys("9087574318");	
		System.out.println("Address success fully entered............");
		//
		System.out.println("Enter the address................");		
		driver.findElement(By.name("address_1")).sendKeys("gopanapalli");
		driver.findElement(By.name("address_2")).sendKeys("Hyderabad");
		driver.findElement(By.name("city")).sendKeys("Hyderabad");
		driver.findElement(By.name("postcode")).sendKeys("500046");
		driver.findElement(By.name("country_id")).sendKeys("India");
		driver.findElement(By.name("zone_id")).sendKeys("Andhra Pradesh");		
		System.out.println("Address success fully entered............");
		//
		System.out.println("Enter your password..............");	
		driver.findElement(By.name("password")).sendKeys("mahender");
		driver.findElement(By.name("confirm")).sendKeys("mahender");
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		//
	   WebElement warning = driver.findElement(By.xpath("//div[@class='warning']"));
	   String Warning_Msg=driver.findElement(By.xpath("//div[@class='warning']")).getText();
	  
	   
		System.out.println(Warning_Msg);	
		
		if(warning.isDisplayed()){
			System.out.println("Inside IF");	
			loginCart();
			addToCart();
			//logoutCart();
			
		}else{
			System.out.println("Inside Else");	
			Assert.assertEquals(successMsg, "Your Account Has Been Created!","Create Account unSuccessfull");
			addToCart();
		}	
	}
	
	public void loginCart(){
		System.out.println("...Inside loginCart...");
		//String successMsg=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		//driver.findElement(By.linkText("login page")).click();
		//driver.findElement(By.linkText("login")).click();
		wait(5);
		driver.findElement(By.xpath("//a[text()='login']")).click();
		driver.findElement(By.name("email")).sendKeys("m.mahender@wipro.com");
		driver.findElement(By.name("password")).sendKeys("mahender");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		String successMsg=driver.findElement(By.xpath("//*[@id='content']/h1")).getText();
		System.out.println("Login msg::"+successMsg);
		//Assert.assertEquals(successMsg, "Register Account","Login unSuccessfull ::");
		Assert.assertEquals(successMsg, "My Account","Login unSuccessfull ::");
	}
	
	public void addToCart(){
		System.out.println("...addToCart...");
		wait(5);
		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		wait(5);
		driver.findElement(By.xpath("//a[@class='nivo-imageLink']")).click();//span[@class='links']
		wait(5);
		driver.findElement(By.linkText("Add to Wish List")).click();
		//System.out.println("you have added successfully galaxy samsung tab..........");
		
		//driver.findElement(By.xpath("//a[@id='wishlist-total']")).click();
		wait(5);
		driver.findElement(By.id("wishlist-total")).click();
		wait(5);
		driver.findElement(By.linkText("£")).click();
		String priceValue=driver.findElement(By.xpath("//tbody[@id='wishlist-row49']//div[@class='price']")).getText();
		//String poundValue=driver.findElement(By.xpath("//tbody[@id='wishlist-row49']//div[@class='price']")).getText();
		//System.out.println("Pound price is ::"+poundValue);
		System.out.println("Pound price is ::"+priceValue);
		//-------------------------------------//
		driver.findElement(By.linkText("€")).click();
		wait(5);
		//String euroValue=driver.findElement(By.xpath("//tbody[@id='wishlist-row49']//div[@class='price']")).getText();
		//System.out.println("Euro price is ::"+euroValue);
		System.out.println("Euro price is ::"+priceValue);
		wait(5);
		driver.findElement(By.linkText("$")).click();
		wait(5);
		//String dollerValue=driver.findElement(By.xpath("//tbody[@id='wishlist-row49']//div[@class='price']")).getText();
		//System.out.println("Doller price is ::"+dollerValue);
		System.out.println("Doller price is ::"+priceValue);
		///-------
		//System.out.println("user able to click the currency.......");
		
		wait(5);
		driver.findElement(By.xpath("//img[@title='Add to Cart']")).click();
		System.out.println("User able to click Add to cart....");
		
		/*wait(5);
		driver.findElement(By.xpath("//img[@class='close']")).click();
		System.out.println("sucess message closed...");*/
		
		wait(5);
		driver.findElement(By.id("wishlist-total")).click();
		/*String actualwish
		Assert.assertEquals(actual, "My Wish List");*/
		wait(5);
		driver.findElement(By.xpath("//tbody[@id='wishlist-row49']/tr[1]/td[6]/a")).click();	
		System.out.println("successfully Removed....");
		
		wait(5);
		driver.findElement(By.linkText("Continue")).click();
		System.out.println("user able to click continue....");
		logoutCart();
		}

	public void orderHistoryDetails(){
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//img[@alt='Your Store']")).click();
		
		driver.findElement(By.linkText("iPhone")).click();
		System.out.println("you selected iphone....");
	
		driver.findElement(By.xpath("//a[@href='#tab-related']")).click();
		
		System.out.println("Related Products tab opened..........");
		
		driver.findElement(By.linkText("Add to Cart")).click();
		System.out.println("Product added in AddToCart successfully.........");
		
		driver.findElement(By.linkText("Related Products (2)")).click();
		System.out.println("Related Products 2 tab opened..........");
		
		driver.findElement(By.xpath("//img[@src='http://10.207.182.108:81/opencart/image/cache/data/demo/iphone_1-80x80.jpg']")).click();
		System.out.println("user able to select product..");
		
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		System.out.println("user able to add the product in addtocart");
		
		/********************Shopping cart Page**********************/
		driver.findElement(By.linkText("Shopping Cart")).click();
		System.out.println("user able to open shopping cart.......");
		
		driver.findElement(By.name("quantity[40::]")).clear();
		
		driver.findElement(By.name("quantity[40::]")).sendKeys("1");
		System.out.println("user able to change the quantity......");
		
		driver.findElement(By.xpath("//input[@alt='Update']")).click();
		System.out.println("user able to update the quantity.........");
		/***Checkout****/
		driver.findElement(By.linkText("Checkout")).click();
		System.out.println("user able to checkout the products.....");
		
		//select[@name='address_id']/option[@value='1833']
		wait(5);
		driver.findElement(By.xpath("//select[@name='address_id']/option[@value='1833']")).click();
		wait(5);
		driver.findElement(By.id("button-payment-address")).click();
		System.out.println("user able click continue button 2.......");
		wait(5);
		driver.findElement(By.id("button-shipping-address")).click();
		System.out.println("user able click continue button 3.......");
		wait(5);
		driver.findElement(By.id("button-shipping-method")).click();
		System.out.println("user able click continue button 4.......");
		wait(5);
		driver.findElement(By.name("agree")).click();
		System.out.println("User able to click the Terms and conditions...........");
		wait(5);
		driver.findElement(By.id("button-payment-method")).click();
		System.out.println("User able to click the continue button...........");
		/*********************Order Tab Opened*****************/
		wait(5);
		driver.findElement(By.xpath("//input[@value='Confirm Order']")).click();
		System.out.println("user able to do confirm order.........");
		System.out.println("Your Order Has Been Processed!...........");
		wait(5);
		driver.findElement(By.linkText("Order History")).click();
		System.out.println("user able to openOrder History successfully..");
		wait(5);
		driver.findElement(By.xpath("//*[@id='content']/div[2]/div[3]/div[3]/a[1]")).click();
		System.out.println("Order Information page id Page id displayed.... ");
		wait(5);
		driver.findElement(By.xpath("//img[@alt='Return']")).click();
		System.out.println("Product return tab shoud be displayed.... ");
		wait(5);
		driver.findElement(By.xpath("//a[@class='button']")).click();
		System.out.println("Home Page Should be displayed..");
		/**************LogOut*****************/
		wait(5);
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout successfully..");
		 }
	
public void Product_Comparison() {
		
		String editSearch="//input[@name='search']";

		//Enter the value in search box

		driver.findElement(By.xpath(editSearch)).sendKeys("orders");

		driver.findElement(By.xpath(editSearch)).sendKeys(Keys.ENTER);

		driver.findElement(By.cssSelector("a[href='http://10.207.182.108:81/opencart/index.php?route=product/category&path=25']")).click();

		driver.findElement(By.xpath("//img[@title='Your Store']")).click();
		//Click on the component link
	
		driver.findElement(By.xpath("//a[@href='http://10.207.182.108:81/opencart/index.php?route=product/category&path=24']")).click();
   
		//Select the value
   
		Select dropDownSortBy=new Select(driver.findElement(By.xpath("//div[@class='sort' ]/select[@onchange='location = this.value;']")));
 		dropDownSortBy.selectByVisibleText("Price (High > Low)");
	  
		//creating the list
 
 		//OpenCartFunctions obj = new OpenCartFunctions(driver);
		List<WebElement> listCompare = driver.findElements(By.xpath("//div[@class='compare']"));
   
		for(WebElement c :listCompare){
			System.out.println("inside for each" + c.getText());

	   wait(5);
	   c.click();
   }
 
		//User is printing the output
		System.out.println("Click on Add to Compare  for the first three phones and click on Close button");
   
      
   
		wait(5);
		//User is clicking on the Product comparison link.
		driver.findElement(By.xpath("//div[@id='notification']/div[@class='success']/a[text()='product comparison']")).click();
		System.out.println("User is able to click on the product comparision link");
		//User is able to click on the Palm Treo Pro link.
   
		driver.findElement(By.linkText("Palm Treo Pro")).click();
		System.out.println("User is able to click on the first product");
   
		/*****User is able to click on the add to cart button.*****/
		driver.findElement(By.id("button-cart")).click();
   
		System.out.println("User is able to click on the add to cart link");
   
		wait(5);
		/*******User will click on the shopping cart link.*******/
   
		driver.findElement(By.xpath("//div[@id='notification']/div[@class='success']/a[text()='shopping cart']")).click();
   
		System.out.println("user is able to click on the shopping cart link");
   
  
		//Clear the quanity field
		driver.findElement(By.xpath("//td[@class='quantity']/input[@type='text']")).clear();
   
		System.out.println("User is able to clear the quantity");
   
   
		//enter the quantity in the field
		driver.findElement(By.xpath("//td[@class='quantity']/input[@type='text']")).sendKeys("1");
   
		System.out.println("User should be able to enter the quantity value");
   
		//Click on the CheckOut button
		
		driver.findElement(By.xpath("//div[@class='right']/a[@class='button']")).click();
   
		System.out.println("User is able to click on the check button");
		wait(5);
   
		//Click on the continue button present in the Billing Details pane

		driver.findElement(By.xpath("//div[@class='buttons']/div[@class='right']/input[@id='button-payment-address']")).click();
		System.out.println("User is able to click on the continue button");
   
		wait(5);
		//Click on the continue button present in the Step 3: Delivery Details pane

		driver.findElement(By.xpath("//div[@class='buttons']/div[@class='right']/input[@id='button-shipping-address']")).click();
		System.out.println("User is able to click on the continue button");
		wait(5);
		//Click on the continue button present in the Step 4: Delivery Method pane
		driver.findElement(By.xpath("//div[@class='buttons']/div[@class='right']/input[@id='button-shipping-method']")).click();
		System.out.println("User is able to click on the continue button");
		//Click on the continue button present in Step 5: Payment Method
		wait(5);
		//Click on the check box for terms and conditions
		driver.findElement(By.xpath("//div[@class='buttons']/div[@class='right']/input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//div[@class='buttons']/div[@class='right']/input[@id='button-payment-method']")).click();
		System.out.println("User is able to click on the continue button");
		wait(5);
		//Click on the Continue button in the Step 6:Confirm order pane
		driver.findElement(By.xpath("//div[@class='payment']/div[@class='buttons']/div[@class='right']/input[@id='button-confirm']")).click();
   
		//user is navigated back
		driver.navigate().back();
		System.out.println("User is naviagte back");
		if (driver.findElement (By.linkText("0 item(s) - $0.00")) != null)
		{
			System.out.println("Value is zero in shopping cart");
		}
		else
		{
			System.out.println("Value is present");
		}
		//User is able to click on the order history link
		wait(5);
		driver.findElement(By.xpath("//div[@id='content']/p/a[text()='history']")).click();
		System.out.println("user is able to click on the history link");
		//This will click on the newsletter link
		wait(5);
		driver.findElement(By.xpath("//ul/li[10]/a[text()='Newsletter']")).click();
		System.out.println("User is able to click on the newsletter link");
		//User will click on the Specials link in the Extras section
		wait(5);
		driver.findElement(By.xpath("//ul/li[4]/a[text()='Specials']")).click();
		System.out.println("User is ablt to click on the Specials link");
		/*****************Click on the Grid*******************/
		wait(5);
		driver.findElement(By.xpath("//div[@id='content']/div[@class='product-filter']")).click();
		System.out.println("User is able to click on the grid option");		
}
	public void logoutCart(){
		wait(5);
		driver.findElement(By.linkText("Logout")).click();
		successMsg=driver.findElement(By.xpath("//div[@id='content']/h1")).getText();
		Assert.assertEquals(successMsg, "Account Logout", "Logout unsuccessfull");
		
	}
	
	public void addingPhones() {
		/*Home Page should be displayed..*/
		driver.findElement(By.linkText("Home")).click();
		System.out.println("Home page should be displayed....");
		
		driver.findElement(By.xpath("//a[@class='nivo-imageLink']")).click();
		System.out.println("Samsung Galaxy Tab 10.1 page has to be displayed....");
		
		//driver.findElement(By.xpath("//img[@id='image']")).click();
		driver.findElement(By.id("image")).click();
		System.out.println("The picture should be displayed in modal window.....");
				
		/*User able to click image slides.....*/
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");	
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.id("cboxNext")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.xpath("//div[@id='cboxClose']")).click();
		System.out.println("User able to click the next button....");
		wait(5);
		driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
		System.out.println("You have added the phone must be displayed.....");
		wait(5);
		driver.findElement(By.linkText("Shopping Cart")).click();
		System.out.println("Shopping cart page is displayed with all the products added to the cart...");
	
		wait(5);
		driver.findElement(By.id("shipping_estimate")).click();
		System.out.println("Estimate shipping for the region , " +
							"state and pin code is displayed along with 'Get Quotes' button");
		
		wait(5);
		driver.findElement(By.id("button-quote")).click();
		System.out.println("User able to clik the Get Quotes button...");
		wait(5);
		driver.findElement(By.xpath("//input[@value='flat.flat']")).click();
		System.out.println("User able to select the flate Shipping Rate....");
		wait(5);
		driver.findElement(By.xpath("//input[@value='Apply Shipping']")).click();
		System.out.println("Success message is displayed on the page and the total amount is displayed...");
		wait(5);
		driver.findElement(By.id("use_coupon")).click();
		System.out.println("Use Coupon tab is displayed.....");
		wait(5);
		driver.findElement(By.name("coupon")).click();
		driver.findElement(By.xpath("//input[@value='Apply Coupon']")).click();
		System.out.println("Warning Ribbon Message is displayed on the page......");
		wait(5);
		driver.findElement(By.linkText("Checkout")).click();
		System.out.println("Check out page is displayed...........");	
		wait(5);
		driver.findElement(By.xpath("//option[@value='1824']")).click();
		System.out.println("User able to select the adress.........");
		wait(5);		
		System.out.println("Billing details....");
		wait(5);
		driver.findElement(By.id("button-payment-address")).click();
		System.out.println("Delivery Method rollup is displayed.");
		wait(5);
		driver.findElement(By.id("button-shipping-address")).click();
		System.out.println("Delivery Method rollup is displayed.");
		wait(5);
		driver.findElement(By.name("comment")).sendKeys("fsdfsgsgsgertgerg");
		wait(5);
		driver.findElement(By.id("button-shipping-method")).click();
		System.out.println("delivery details....");
		//payment method
		wait(5);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		System.out.println("user able to click the checkbox....");
		wait(5);
		driver.findElement(By.id("button-payment-method")).click();
		System.out.println("Paymentmethod.............");
		wait(5);
		driver.findElement(By.xpath("//input[@value='Confirm Order']")).click();
		System.out.println("Your order has been processed...........");
		wait(5);
		driver.findElement(By.linkText("Logout")).click();
		System.out.println("Logout Successfully.........");
	
	}
	public static void wait(int time){
		try {
		Thread.sleep(5555);
		} catch (InterruptedException e) {
		e.printStackTrace();
		}
	}
}
