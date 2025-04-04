package Stepdefiniction;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.junit.Test;
import Contatnt.Constant;
import Pageobjectmodule.LoginpageHRMSElement;
import Utilities.Commonutils;
import Webdrivermanager.Webdrivermanager;
import io.cucumber.java.en.*;

public class loginpage {
	
	@Given("user should navigate to appication url")
	public void user_should_navigate_to_appication_url() {
		try {
			Webdrivermanager.getDriver().get(Constant.url);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}

	//scenario 1
	@Given("I am on the login page")
	public void i_am_on_the_login_page() {}
		

	@When("I enter valid username and password")
	public void i_enter_valid_username_and_password() {
		try {
			LoginpageHRMSElement.getUsernametype().sendKeys(Constant.username);
			LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.password);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}

	@When("I click on the Login button")
	public void i_click_on_the_login_button() {
		try {
			LoginpageHRMSElement.getLoginbutton().click();
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}

	@Then("I should be logged into the applications")
	public void i_should_be_logged_into_the_applications() {
		try {
			boolean admin = LoginpageHRMSElement.getAdminlist().isDisplayed();
			if (admin==true) {
				System.out.println("login is successfull");
			}
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	
	//scenario2
	@When("user enter valid username and invalidpassword")
	public void user_enter_valid_username_and_invalidpassword() {
	    LoginpageHRMSElement.getUsernametype().sendKeys(Constant.username);
	    LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.invalidpassword);
	}
	@When("Click on the Login button")
	public void click_on_the_login_button() throws InterruptedException {
	    LoginpageHRMSElement.getLoginbutton().click();
	    Thread.sleep(2000);
	}
	@Then("user should see the message error message for invalid password")
	public void user_should_see_the_message_error_message_for_invalid_password() {
	    try {
	    	String excepted = "Please enter password.";
			  WebElement error = LoginpageHRMSElement.getPassworderrormessage();
			  String actual = error.getText();
			  assertTrue("Expected error message:" + excepted + " Actual error message:"+ actual + ".", actual.contains(excepted));
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	
	//scenario3
	@When("user enter invalid username and valid password")
	public void user_enter_invalid_username_and_valid_password() {
		try {
			LoginpageHRMSElement.getUsernametype().sendKeys(Constant.invalidusername);
			LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.password);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	    
	}
	
	@Then("user should see the message error message for invalid username")
	public void user_should_see_the_message_error_message_for_invalid_username() {
		try {
			Thread.sleep(2000);
			boolean usernameerrormessage = LoginpageHRMSElement.getErrormesage().isDisplayed();
			if (usernameerrormessage==true) {
				System.out.println("message is getting displayed");
			}else {
				System.out.println("message is not getting displayed");
			}
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	    
	
	}
	
	//scenario 4
	@When("user enter invalid username and invalid password")
	public void user_enter_invalid_username_and_invalid_password() {
		try {
			LoginpageHRMSElement.getUsernametype().sendKeys(Constant.invalidusername);
			LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.invalidpassword);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	    
	}
	
	@Then("user should see the message error message for both username and password")
	public void user_should_see_the_message_error_messageboth_username_and_password() {
	  try {
		  String excepted = "The username or password you entered is incorrect.";
		  WebElement error = LoginpageHRMSElement.getErrormesage();
		  String actual = error.getText();
		  assertTrue("Expected error message:" + excepted + " Actual error message:"+ actual + ".", actual.contains(excepted));
		
	} catch (Exception e) {
		Commonutils.screenshot();
	}	
}
	
	//scenario 5
	@When("user not enter credentials")
	public void user_not_enter_credentials() {
		try {
			LoginpageHRMSElement.getUsernametype().sendKeys("1234");
			LoginpageHRMSElement.getPassowrdtype().sendKeys("1234");
		} catch (Exception e) {
			Commonutils.screenshot();
		}   
	}
	
	//scenario 6
	@When("user gives only username without giving the password")
	public void user_gives_only_username_without_giving_the_password() {
	    try {
	    	LoginpageHRMSElement.getUsernametype().sendKeys(Constant.username);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	
	@Then("I should see an error message indicating invalid login credentials")
	public void i_should_see_an_error_message_indicating_invalid_login_credentials() {
		try {
	    	String currenturl = Webdrivermanager.getDriver().getCurrentUrl();
	    	String homepage="Welcome";
	    	if (currenturl.contains(homepage)) {
				System.out.println("user navigate to homepage");
			}else {
				System.out.println("user can't able to navigate to homepage");
			}
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	//scenario 7
	@When("user gives only password without giving the username")
	public void user_gives_only_password_without_giving_the_username() {
		try {
	    	LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.password);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	
	//scenario 8
	@When("user gives only invalid username without giving the password")
	public void user_gives_only_invalid_username_without_giving_the_password() {
		 try {
		    	LoginpageHRMSElement.getUsernametype().sendKeys(Constant.invalidusername);
			} catch (Exception e) {
				Commonutils.screenshot();
			}
	}
	
	//scenario 9
	
	@When("user gives only invalid password without giving the username")
	public void user_gives_only_invalid_password_without_giving_the_username() {
		try {
	    	LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.invalidpassword);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	
	//scenario 10
	@When("user enter password in the password field")
	public void user_enter_password_in_the_password_field() {
	    try {
	    	LoginpageHRMSElement.getPassowrdtype().sendKeys(Constant.password);
		} catch (Exception e) {
			Commonutils.screenshot();
		}
	}
	@Then("the password should be masked in the password field")
	public void the_password_should_be_masked_in_the_password_field() {
		if (LoginpageHRMSElement.getPassowrdtype().getAttribute("type").equals("password")) {
            System.out.println("Password field is masked");
        } else {
            System.out.println("Password field is not masked");
        }
}
}

