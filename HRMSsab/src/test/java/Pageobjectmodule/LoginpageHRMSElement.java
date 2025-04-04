package Pageobjectmodule;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.cucumber.java.StepDefinitionAnnotations;

public class LoginpageHRMSElement {
	
	private static LoginpageHRMSElement logininstance;
	
	private LoginpageHRMSElement() {
		
	}
	
	public static LoginpageHRMSElement getinstance() {
		if (logininstance==null) {
			logininstance= new LoginpageHRMSElement();
		}
		return logininstance;
	}
	
	@FindBy(id = "username")
	private static WebElement usernametype;

	@FindBy(id = "password")
	private static WebElement passowrdtype;
	
	@FindBy(id = "loginsubmit")
	private static WebElement loginbutton;
	
	@FindBy(id = "prof_name")
	private static WebElement adminlist;
	
	@FindBy(xpath ="//div[contains(text(),'The username or password you entered is incorrect.')]")
	private static WebElement errormesage;
	
	@FindBy(xpath = "//div[text()='Please enter password.']")
	private static WebElement passworderrormessage;
	
	
	public static WebElement getErrormesage() {
		return errormesage;
	}

	public static WebElement getPassworderrormessage() {
		return passworderrormessage;
	}

	public static WebElement getUsernametype() {
		return usernametype;
	}

	public static WebElement getPassowrdtype() {
		return passowrdtype;
	}

	public static WebElement getLoginbutton() {
		return loginbutton;
	}

	public static WebElement getAdminlist() {
		return adminlist;
	}
	


}
