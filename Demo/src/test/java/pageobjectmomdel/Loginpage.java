package pageobjectmomdel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import Utilities.Commonutiles;

public class Loginpage {
	
	
	
	private static Loginpage logininstance;
	
	private Loginpage() {
		
	}
	
	public static Loginpage getinstance() {
		
		if (logininstance==null) {
			logininstance= new Loginpage();
		}
		return logininstance;
	}

	@FindBy(xpath = "//input[@name='username']")
	private static WebElement username;
	
	
	@FindBy(xpath = "//input[@name='password']")
	private static WebElement passwrd;
	
	
	@FindBy(xpath = "//button[@type='submit']")
	private static WebElement loginbutton;
	
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
	private static WebElement PIMbutton;
	
	@FindBy(tagName = "h6")
	private static WebElement PIMName;

	public static WebElement getUsername() {
		//Commonutiles.getinstance().elementhighlight(username);
		return username;
	}

	public static WebElement getPasswrd() {
		//Commonutiles.getinstance().elementhighlight(passwrd);
		return passwrd;
	}

	public static WebElement getLoginbutton() {
		//Commonutiles.getinstance().elementhighlight(loginbutton);
		return loginbutton;
	}

	public static WebElement getPIMbutton() {
		//Commonutiles.getinstance().elementhighlight(PIMbutton);
		return PIMbutton;
	}

	public static WebElement getPIMName() {
		Commonutiles.getinstance().elementhighlight(PIMName);
		return PIMName;
	}
}
