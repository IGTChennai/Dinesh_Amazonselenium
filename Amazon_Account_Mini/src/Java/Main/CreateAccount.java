package Java.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.yaml.snakeyaml.introspector.Property;

public class CreateAccount {
	public static WebDriver driver;
	public static File fle;
	public static Properties prop;
	
	
//static String URL="https://www.google.com/";
//static String URL="https://www.amazon.in/";
//static String signin="//a[text()='Sign in']";
	public static void main(String[] args) throws IOException, InterruptedException {
		
		propertyfile();
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver", ".//chromedriver.exe");
 driver= new ChromeDriver();
//driver.get(URL);
driver.get(Amazon_Locators.Login.URL);
//ChromeDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	Amazon_Inputs.click(Amazon_Inputs.locateElement("xpath",Amazon_Locators.Login.submit));
	Amazon_Inputs.click(Amazon_Inputs.locateElement("id",Amazon_Locators.Login.Continue_btn));
	//driver.findElement(By.xpath("//a[@id='nav-link-accountList']")).click();
	
	//driver.findElement(By.id("createAccountSubmit")).click();
	//Amazon_Inputs.sendkeys("email","abc");
	//driver.findElement(By.id("continue")).click();
	Amazon_Inputs.Verification("empty");
	Amazon_Inputs.takescreenshot();
	Amazon_Inputs.Verification("Validate");
	Amazon_Inputs.takescreenshot();
	Thread.sleep(20000);
	Amazon_Inputs.type(Amazon_Inputs.locateElement("name",Amazon_Locators.Login.email_btn),prop.getProperty("mail"));
	Amazon_Inputs.click(Amazon_Inputs.locateElement("id",Amazon_Locators.Login.Continue_btn));
	Amazon_Inputs.type(Amazon_Inputs.locateElement("id",Amazon_Locators.Login.txt_password),prop.getProperty("password"));
	Amazon_Inputs.click(Amazon_Inputs.locateElement("id",Amazon_Locators.Login.txt_SignIn));
	Amazon_Inputs.action_Keyborad(Amazon_Inputs.locateElement("id" , Amazon_Locators.Login.element_txt), prop.getProperty("product"));
	Amazon_Inputs.itemSearchanddisplayIT();
	
	Actions actn=new Actions(driver);
	
	WebElement btn=Amazon_Inputs.locateElement("xpath",Amazon_Locators.Login.Account_Logout);
		actn.moveToElement(btn).perform();
		Thread.sleep(2000);
		Amazon_Inputs.click(Amazon_Inputs.locateElement("id",Amazon_Locators.Login.Signout));
		Thread.sleep(2000);
		if(Amazon_Inputs.locateElement("name",Amazon_Locators.Login.email_btn).isDisplayed())
		{
			System.out.println("User has beem Logged out Successfully");
	
		}
	//WebElement alertContent=driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]"));
	/*String alertContent=driver.findElement(By.xpath("(//div[@class='a-alert-content'])[2]")).getText();
	if(alertContent.contains("Enter your name"))
			
	{
		System.out.println("Enter youe name is validated");
	}
	else{
		System.out.println("Enter youe name is not validated");
	}
	//driver.findElement(By.xpath("//a[text()='Sign in']")).click();
	
	//driver.findElement(By.xpath("(//a[text()='Sign in'])").Click();
	//driver.findElement(By.xpath(signin).click();
	//String verifyCustomerName=driver.findElement(By.name("customerName")).getAttribute("name");
	//System.out.println(verifyCustomerName);
	
//String Customername=driver.findElement(By.name("customerName")).sendKeys("Dineshkumar");

	//driver.findElement(By.name("customerName")).clear();
	 
	//driver.findElement(By.name("customerName")).sendKeys("Dineshkumar");
	
	*/
	
	String missingText = driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']")).getText();
	
	 if(missingText.contains("Enter your email or mobile phone number"))
	 {
		 System.out.println("Text is validated ");
	 }
	 else{
		 System.out.println("Text is not validated");
	 }
	 
	}
	
	/*public static void Verification(String Verify){
	try{

		Verify=Verify.toLowerCase();
		
		switch (Verify)
		{
		case "empty":
			String missingText = driver.findElement(By.xpath("//div[@id='auth-email-missing-alert']")).getText();
			
			 if(missingText.contains("Enter your email or mobile phone number"))
			 {
				 System.out.println("Text is validated ");
			 }
			 else{
				 System.out.println("Text is not validated");
			 }
			 
		}
	}
	
catch(Exception e)
	{
	
	}
	
	
	}
	*/
	
	
	public static void propertyfile() {

		try {

			fle = new File(
					".//TestData.Properties");
			FileInputStream fs = new FileInputStream(fle);
			prop = new Properties();
			prop.load(fs);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
 

