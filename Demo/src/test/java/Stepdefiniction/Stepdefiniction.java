package Stepdefiniction;

import static org.junit.Assert.assertEquals;

import com.lao.constant.constant;

import Utilities.Commonutiles;
import Webdrivermanager.Webdrivermanager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjectmomdel.Loginpage;

public class Stepdefiniction {
	
	//public  Loginpage log = new Loginpage();
	
	@Given("user able naivgate to orange HRM application")
	public void user_able_naivgate_to_orange_hrm_application() {
	   Webdrivermanager.getDriver().get(constant.url);
	}

	@Then("enter the user {string} and {string}")
	public void enter_the_user_and(String username, String password) {
		
		try {
			Loginpage.getinstance().getUsername().sendKeys(username);
			Loginpage.getinstance().getPasswrd().sendKeys(password);
		} catch (Exception e) {
			Commonutiles.getinstance().takescreenshot();
		}
		
	}

	@When("user click on login button")
	public void user_click_on_login_button() {
		
		try {
			Loginpage.getinstance().getLoginbutton().click();
		} catch (Exception e) {
			Commonutiles.getinstance().takescreenshot();
		}
		 
	}

	@Then("naviagate to PIM page")
	public void naviagate_to_pim_page() {
		try {
			Loginpage.getinstance().getPIMbutton().click();
		} catch (Exception e) {
			Commonutiles.getinstance().takescreenshot();
		}
	}

	@Then("verify that user is able to see the {string} in the page")
	public void verify_that_user_is_able_to_see_the_in_the_page(String page) {
		
		try {
			String actual = Loginpage.getinstance().getPIMName().getText();
			String expected = page;
			if (actual==expected) {
				System.out.println("passed");
			}
		} catch (Exception e) {
			Commonutiles.getinstance().takescreenshot();
		}
	    
	}

}
