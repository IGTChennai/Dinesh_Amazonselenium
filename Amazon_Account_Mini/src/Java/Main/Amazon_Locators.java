package Java.Main;

public class Amazon_Locators {
	
	public static class Login
	{
		public static String URL="https://www.amazon.in/";
		
		public static String submit="//a[@id='nav-link-accountList']";
		
		public static String Continue_btn="continue";
		
		public static String missingContent="(//div[@id='auth-email-missing-alert'])";
		
		public static String email_btn="email";
		public static String txt_password="ap_password";
		
		public static String element_txt="twotabsearchtextbox";
		
		public static final String txt_SignIn ="signInSubmit";
		
		public static String Account_Logout = "(//span[contains(text(),'Account & Lists') and @class='nav-line-2'])";
		
		public static String Signout = "//span[text()='Sign Out']";
		
	}

}
