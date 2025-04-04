package Stepdefiniction;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hpsf.Array;
import org.apache.poi.ss.formula.functions.Code;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Pageobjectmodule.CodeboardtechElements;
import Resourcespackage.Excelnames;
import Resourcespackage.ValidationMessage;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import Utilities.Commonutilities;
import Webdrivermanager.Webdrivermanager;
import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefiniction {

	static long starttime;
	static long Endtime;
	@Given("user can able to navigate Codeboardsite")
	public void user_can_able_to_navigate_codeboardsite() {
		try {
			starttime = System.currentTimeMillis();
			Webdrivermanager.getDriver().get(Commonutilities.readExcelData(Excelnames.URL).get(0).get(0));
			Endtime = System.currentTimeMillis();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////==============sceanrio 1=============//////////////////
	@Given("I navigate to the website")
	public void i_navigate_to_the_website() {
		try {
			String actualurl = Webdrivermanager.getDriver().getCurrentUrl();
			String expectedurl = Excelnames.AppURL;
			assertEquals(actualurl,expectedurl);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@When("I capture the response time and the response time should be less than {string} milliseconds")
	public void i_capture_the_response_time_and_the_response_time_should_be_less_than_milliseconds(String string) {
		try {
			long Responsetime = (Endtime - starttime) /1000 ;
			long expected = 100;
			if (Responsetime<=expected) {
				System.err.println("The system taking less than 1000 milliseconds");
			}else {
				System.err.println("The system taking more than 1000 milliseconds ");
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	//////=============scenario 2==========///////////////////
	@Then("I should see the following menu items like Home, offering, Industeries, insights, about us and contact")
	public void i_should_see_the_following_menu_items_like_home_offering_industeries_insights_about_us_and_contact() {
		try {
			List<WebElement> Headerdropdown = CodeboardtechElements.getHeaderdropdowns();
			for (int i = 0; i < Headerdropdown.size(); i++) {
				String expected=Headerdropdown.get(i).getText();
				String actual = Commonutilities.readExcelData(Excelnames.Websiteicon).get(0).get(i);
				assertEquals(expected,actual);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	//////////=============sccenario 3===========//////////////////////
	@Then("I should see the cookies banner displayed correctly")
	public void i_should_see_the_cookies_banner_displayed_correctly() {
		try {
			Thread.sleep(1000);
			assert CodeboardtechElements.getCookies().isDisplayed() : ValidationMessage.CookiesErrormessage;
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////=============scenario 4=====/////////////////
	@Given("the cookies banner should include an Accept button and Decline button")
	public void the_cookies_banner_should_include_an_accept_button_and_decline_button() {
		try {
			Thread.sleep(2000);
			assert CodeboardtechElements.getCookiesacceptbuton().isDisplayed() && CodeboardtechElements.getCookiesdeclinebuton().isDisplayed() : ValidationMessage.Cookiesacceptederrormessage;
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////============scenario 4=========////////////
	@Given("the cookies banner should display the correct cookie content")
	public void the_cookies_banner_should_display_the_correct_cookie_content() {
		try {
			Thread.sleep(1500);
			String exp = CodeboardtechElements.getCookiescontent().getText();
			String act = Commonutilities.readExcelData(Excelnames.CookieContent).get(0).get(0);
			assertEquals(exp,act);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}


	//=================scenario 5=========================////////////
	@Then("the default content displayed should be {string}")
	public void the_default_content_displayed_should_be(String string) {
		try {
			String act = CodeboardtechElements.getSlideheadingOfHomePage(1).getText();
			System.err.println(act);
			String exp = Commonutilities.readExcelData(Excelnames.HomepicandContent).get(0).get(0);
			assertEquals(act,exp);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("the associated picture should be displayed")
	public void the_associated_picture_should_be_displayed() {
		try {		
			String bct = CodeboardtechElements.getSlideimageOfHomePage(1).getAttribute("src");
			System.err.println(bct);
			String exp = Commonutilities.readExcelData(Excelnames.HomepicandContent).get(0).get(2);
			assertEquals(bct,exp);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the related content should be visible")
	public void the_related_content_should_be_visible() {
		try {
			String bct = CodeboardtechElements.getSlidecontentOfHomePage(1).getText();
			System.err.println(bct);
			String exp = Commonutilities.readExcelData(Excelnames.HomepicandContent).get(0).get(1);
			assertEquals(bct,exp);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	////////////=====================scenario 6==============////////////////////////////
	@Then("I should see multiple slides displayed in the header")
	public void i_should_see_multiple_slides_displayed_in_the_header() {
		try {
			int actcount = CodeboardtechElements.getHeaderslides().size();
			int expected = 5;
			assertEquals(actcount, expected);
			System.err.println("There is a total of " + actcount + " slides.");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("each slide should have content")
	public void each_slide_should_have_content() {
		try {
			ArrayList<String> numberList1 = new ArrayList<>();
			for (int i = 0; i < CodeboardtechElements.getHeaderslides().size(); i++) {
				CodeboardtechElements.getClickoneonHeader(i+1).click();
				numberList1.add(CodeboardtechElements.getSlidecontentOfHomePage(i+1).getText());

			}
			ArrayList<String> numberList2 =new ArrayList<>();
			for (int i = 0; i < CodeboardtechElements.getHeaderslides().size(); i++) { 
				numberList2.add(Commonutilities.readExcelData(Excelnames.HomepicandContent).get(i).get(1));
			}
			if (numberList1.equals(numberList2)) {
				System.err.println(numberList1);
				System.err.println(numberList2);
			}
			else {
				Commonutilities.screenshot();
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("each slide should have a picture")
	public void each_slide_should_have_a_picture() {
		try {
			for (int i = 0; i < CodeboardtechElements.getHeaderslides().size(); i++) {
				CodeboardtechElements.getClickoneonHeader(i+1).click();
				String act = CodeboardtechElements.getSlideimageOfHomePage(i+1).getAttribute("src");
				String exp = Commonutilities.readExcelData(Excelnames.HomepicandContent).get(i+0).get(2);
				System.err.println(exp);
				System.err.println(act);
				assertEquals(act, exp);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("each slide should have a View More button")
	public void each_slide_should_have_a_view_more_button() {
		try {
			for (int i = 0; i < CodeboardtechElements.getHeaderslides().size(); i++) {
				CodeboardtechElements.getClickoneonHeader(i+1).click();
				if (CodeboardtechElements.getViewmorebutton(i+1).isDisplayed()) {
					System.err.println("The View more Button is get visible for slide " + (i+1));
				}else {
					System.err.println("The View more Button is not visible for slide " + (i+1));
				}
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}


	//////===============scenario 7==========///////////////////////
	@Given("I accept the cookies")
	public void i_accept_the_cookies() {
		try {
			Thread.sleep(1500);
			if (CodeboardtechElements.getCookiesacceptbuton().isDisplayed()) {
				CodeboardtechElements.getCookiesacceptbuton().click();
			}else {
				System.err.println(ValidationMessage.cookiesnotdisplayed);
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should see the About Us section")
	public void i_should_see_the_about_us_section() {
		try {
			Commonutilities.Dynamicscrolldown(350);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the About Us section should contain the expected content")
	public void the_about_us_section_should_contain_the_expected_content() {
		try {
			String text = CodeboardtechElements.getAboutuscontent().getText();
			System.err.println(text);
			String text1 = Commonutilities.readExcelData(Excelnames.Aboutus).get(0).get(0);
			assertEquals(text, text1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////======================scenario 8=========/////////////////////////
	@Then("I should see a Contact link in the header")
	public void i_should_see_a_contact_link_in_the_header() {
		try {
			if (CodeboardtechElements.getContactinheader().isDisplayed()) {
				System.err.println(ValidationMessage.Contactvisible);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@When("I click on the Contact link")
	public void i_click_on_the_contact_link() {
		try {
			CodeboardtechElements.getContactinheader().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should be redirected to the Contact Us section")
	public void i_should_be_redirected_to_the_contact_us_section() {
		try {
			String url = Webdrivermanager.getDriver().getCurrentUrl();
			if (url.contains(Excelnames.Contactus)) {
				System.err.println(ValidationMessage.navigstetocontactusmessage);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////==================scenario 9==========///////////////////
	@Then("I should see the What We Can Offer section")
	public void i_should_see_the_what_we_can_offer_section() {
		try {
			Commonutilities.Dynamicscrolldown(1500);
			if (CodeboardtechElements.getWhatweoffersection().isDisplayed()) {
				System.err.println("The system is navigated to What We Can Offer section");
			} else {
				System.err.println("The system is not navigated to What We Can Offer section");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the section should display the following categories: Insurance, Logistics, Fintech, and ISV")
	public void the_section_should_display_the_following_categories_insurance_logistics_fintech_and_isv() {
		try {
			int i = 1;
			int j = 0;
			for (WebElement fourelement : CodeboardtechElements.getFourcardsname()) {
				Actions act = new Actions(Webdrivermanager.getDriver());
				act.moveToElement(fourelement).perform();
				Thread.sleep(700);
				String ext =CodeboardtechElements.getcardcontentforfour(i++).getText();
				String pct = Commonutilities.readExcelData(Excelnames.CarDone).get(0).get(j++);
				System.err.println(pct);
				System.err.println(ext);
				assertEquals(pct, ext);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////////////==============scenario 10===========////////////////////////
	@Then("I should see the Why Us section")
	public void i_should_see_the_why_us_section() {
		try {
			Commonutilities.Dynamicscrolldown(2000);
			if (CodeboardtechElements.getWhyussection().isDisplayed()) {
				System.err.println("The system is navigated to Why us section");
			} else {
				System.err.println("The system is not navigated to Why us section");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should see the following items displayed like Time to Market, Development Acceleration, Agile, Management Commitment, Flexibility, Lower TCO, Enterprise Experience, Focus")
	public void i_should_see_the_following_items_displayed_like_time_to_market_development_acceleration_agile_management_commitment_flexibility_lower_tco_enterprise_experience_focus() {
		try {
			int i=0;
			for (WebElement element : CodeboardtechElements.getWhyustextbox()) {
				Thread.sleep(500);
				String actual = element.getText();
				System.err.println(actual);
				String expected = Commonutilities.readExcelData(Excelnames.Whyus).get(0).get(i++);
				System.err.println(expected);
				assertEquals(actual, expected);
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////////////////==================scenario 11========////////////////////////////////////
	@When("I scroll to the footer section")
	public void i_scroll_to_the_footer_section() {
		try {
			Commonutilities.Dynamicscrolldown(2800);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should see multiple slides displayed in the footer")
	public void i_should_see_multiple_slides_displayed_in_the_footer() {
		try {
			int actual = CodeboardtechElements.getFooterslides().size();
			int expected = 3;
			assertEquals(actual,expected);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("each slide should contain like Content, Pictures, View More button")
	public void each_slide_should_contain_like_content_pictures_view_more_button() {
		try {
			int i=6;
			int j=1;
			int k=0;
			for (WebElement element : CodeboardtechElements.getFooterslides()) {
				Thread.sleep(2000);
				CodeboardtechElements.getClickoneonfooter(j).click();
				String heading = CodeboardtechElements.getSlideheadingOfHomePage(i).getText();
				System.err.println(heading);
				String headingact = Commonutilities.readExcelData(Excelnames.Footerslide).get(0).get(k);
				System.err.println(headingact);
				assertEquals(heading,headingact);


				CodeboardtechElements.getClickoneonfooter(j).click();
				String content = CodeboardtechElements.getSlidecontentOfHomePage(i).getText();
				System.err.println(content);
				String expcontent = Commonutilities.readExcelData(Excelnames.Footerslide).get(1).get(k);
				System.err.println(expcontent);
				assertEquals(content,expcontent);


				CodeboardtechElements.getClickoneonfooter(j).click();
				String actimg = CodeboardtechElements.getSlideimageOfHomePagefooter(i).getAttribute("src");
				System.err.println(actimg);
				String expimg = Commonutilities.readExcelData(Excelnames.Footerslide).get(2).get(k);
				System.err.println(expimg);
				assertEquals(actimg,expimg);
				k++;
				i++;
				j++;
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////////================scenario 12===========//////////////////////////////////
	@Then("I should see the About Us section in the footer")
	public void i_should_see_the_about_us_section_in_the_footer() {
		try {
			Commonutilities.Dynamicscrolldown(3000);
			if (CodeboardtechElements.getFooterlogo().isDisplayed()) {
				System.err.println("The system is navigate to footer section of the application");
			} else {
				System.err.println("The system is not navigate to footer section of the application");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("the About Us section should contain like Description, Links, Contact Info")
	public void the_about_us_section_should_contain_like_description_links_contact_info() {
		try {
			String text = CodeboardtechElements.getFootercontent().getText();
			System.err.println(text);
			String expectedtext = Commonutilities.readExcelData(Excelnames.footercontent).get(0).get(0);
			System.err.println(expectedtext);
			assertEquals(text,expectedtext);
			for (WebElement element : CodeboardtechElements.getQuicklinks()) {
				String one = element.getText();
				String two = Commonutilities.readExcelData(Excelnames.footercontent).get(0).get(1);
				System.err.println(one);
				System.err.println(two);
				assertEquals(one,two);
				break;
			}

			for (WebElement element : CodeboardtechElements.getOtherlinks()) {
				String one = element.getText();
				String two = Commonutilities.readExcelData(Excelnames.footercontent).get(0).get(2);
				System.err.println(one);
				System.err.println(two);
				assertEquals(one,two);
				break;
			}
			int i=3;
			for (WebElement element : CodeboardtechElements.getOurnewsletter()) {
				String one = element.getText();
				System.err.println(one);
				String two = Commonutilities.readExcelData(Excelnames.footercontent).get(0).get(i);
				System.err.println(two);
				i++;
				assertEquals(one,two);
			}

		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////////==========================scenario 12==========/////////////////////
	@Given("I click on View More")
	public void i_click_on_view_more() {
		try {
			CodeboardtechElements.getViewmorebutton(1).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("I should be navigated to the Insurance page")
	public void i_should_be_navigated_to_the_insurance_page() {
		Commonutilities.navigatesuccessfullornot(Excelnames.Insurance);
	}

	/////==================scenario 13============///////////////////////////
	@Then("I should see the correct content for the Insurance page")
	public void i_should_see_the_correct_content_for_the_insurance_page() {
		try {
			Commonutilities.Headingcontentwith00("Insurance page 1");

			Commonutilities.Dynamicscrolldown(500);
			System.err.println(CodeboardtechElements.getInsuranceContainer().getText());
			System.err.println(Commonutilities.readExcelData(Excelnames.Insurancepage1).get(1).get(0)); 
			assertEquals(CodeboardtechElements.getInsuranceContainer().getText(),Commonutilities.readExcelData(Excelnames.Insurancepage1).get(1).get(0));
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("all relevant pictures should be displayed")
	public void all_relevant_pictures_should_be_displayed() {
		try {
			String use = CodeboardtechElements.getHeadingimage().getAttribute("src");
			System.err.println(use);
			String used = Commonutilities.readExcelData(Excelnames.Insurancepage1).get(0).get(1);
			assertEquals(use,used);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	////////////====================scenario 13=============////////////////////////////
	@Then("I should see five separate pages listed under the Insurance section")
	public void i_should_see_five_separate_pages_listed_under_the_insurance_section() {
		try {
			assertEquals(5,CodeboardtechElements.getChildsubmodules().size());
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	/////////////================scenario 14=======================////
	@Then("I should be redirected to the correct Sales and Quote page")
	public void i_should_be_redirected_to_the_correct_sales_and_quote_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("the page should display accurate and relevant content in Sales and Quote page")
	public void the_page_should_display_accurate_and_relevant_content_in_sales_and_quote_page() {
		try {
			String use = CodeboardtechElements.getHeadingcontent().getText();
			System.err.println(use);
			assertEquals(CodeboardtechElements.getHeadingcontent().getText(),Commonutilities.readExcelData(Excelnames.SalesandQuotes).get(0).get(1));
			String s12 = CodeboardtechElements.getSalesandquotescontent().getText();
			System.err.println(s12);	
			String e12 = Commonutilities.readExcelData(Excelnames.SalesandQuotes).get(0).get(0);
			System.err.println(e12);
			assertEquals(s12,e12);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	/////////===========scenario 15========////////////////////////////////////////
	@Then("I should be redirected to the correct Underwriting page")
	public void i_should_be_redirected_to_the_correct_underwriting_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Underwriting Page")
	public void the_page_should_display_accurate_and_relevant_content_in_underwriting_page() {
		try {
			int i=100;
			int j=0;
			Commonutilities.switchtoIDframe();
			int inh = CodeboardtechElements.getUnderwritingcontent().size();
			for (WebElement element : CodeboardtechElements.getUnderwritingcontent()) {
				String u1 = element.getText();
				System.err.println(u1);
				String uw2 = Commonutilities.readExcelData(Excelnames.Underwriting).get(j).get(0);
				System.err.println(uw2);
				assertEquals(u1, Commonutilities.readExcelData(Excelnames.Underwriting).get(j).get(0));
				Commonutilities.Dynamicscrolldown(i);
				i=i+80;
				j++;
			}
		} catch (Exception e) {
			System.err.println(e);
			Commonutilities.screenshot();
			fail();
		}
	}

	//////////////=================scenario 16======//////////////////////////
	@Then("I should be redirected to the correct Reinsurance page")
	public void i_should_be_redirected_to_the_correct_reinsurance_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Reinsurance Page")
	public void the_page_should_display_accurate_and_relevant_content_in_reinsurance_page() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Reinsurance);
			Commonutilities.Bodycontent101(Excelnames.Reinsurance);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////=============scenario 17=======//////////////////////////
	@Then("I should be redirected to the correct Claim Management page")
	public void i_should_be_redirected_to_the_correct_claim_management_page() {
		try {
			Commonutilities.Dynamicscrolldown(850);
			Thread.sleep(2000);
			CodeboardtechElements.getsubmodulescount(4).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Claim Management Page")
	public void the_page_should_display_accurate_and_relevant_content_in_claim_management_page() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.ClaimManagement);
			Commonutilities.Bodycontent101(Excelnames.ClaimManagement);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	////////////================scenario 18=======///////////////////////////
	@Then("I should be redirected to the correct Broker Management page")
	public void i_should_be_redirected_to_the_correct_broker_management_page() {
		try {
			Commonutilities.Dynamicscrolldown(850);
			Thread.sleep(1000);
			CodeboardtechElements.getsubmodulescount(5).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Broker Management Page")
	public void the_page_should_display_accurate_and_relevant_content_in_broker_management_page() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.BrokerManagement);
			Commonutilities.Bodycontent101(Excelnames.BrokerManagement);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	/////////================scenario 19====////////////////////////

	@Given("I click on View More in second side")
	public void i_click_on_view_more_in_second_side() {
		try {
			Thread.sleep(2000);
			CodeboardtechElements.getClickoneonHeader(2).click();
			Thread.sleep(900);
			CodeboardtechElements.getViewmorebutton(2).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}

	}
	@Then("I should be navigated to the Fintech page")
	public void i_should_be_navigated_to_the_fintech_page() {
		try {
			Thread.sleep(4000);
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains("fintech")) {
				System.err.println("The user is navigate to Fintech page");
			}else {
				System.err.println("The user is not navigate to fintech page");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	////=================scenario 20==============/////////////////////
	@Then("I should see the correct content for the Fintech page")
	public void i_should_see_the_correct_content_for_the_fintech_page() {
		try {
			Commonutilities.Headingcontentwith00("Fintech Page 2");
			System.err.println("all relevant headingcontent are displaying");

			Commonutilities.Dynamicscrolldown(500);
			System.err.println(CodeboardtechElements.getInsuranceContainer().getText());
			System.err.println(Commonutilities.readExcelData(Excelnames.Fintechpage2).get(1).get(0)); 
			assertEquals(CodeboardtechElements.getInsuranceContainer().getText(),Commonutilities.readExcelData("Fintech Page 2").get(1).get(0));
			System.err.println("all relevant content are displaying");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("all relevant pictures should be displayed in fintech page")
	public void all_relevant_pictures_should_be_displayed_in_fintech_page() {
		try {
			String use = CodeboardtechElements.getHeadingimage().getAttribute("src");
			System.err.println(use);
			assertEquals(CodeboardtechElements.getHeadingimage().getAttribute("src"),Commonutilities.readExcelData(Excelnames.Fintechpage2).get(2).get(0));
			System.err.println("all relevant pictures are displaying");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}


	////////////////=============scenario 21=======/////////////////////
	@Then("I should see {int} separate pages listed under the fintech section")
	public void i_should_see_separate_pages_listed_under_the_fintech_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having"+int1+"sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	//////////=================scenario 22=====//////////////////////
	@Then("I should be redirected to the correct Lending page")
	public void i_should_be_redirected_to_the_correct_lending_page() {
		try {
			Commonutilities.Dynamicscrolldown(850);
			Thread.sleep(2000);
			CodeboardtechElements.getsubmodulescount(1).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Lending Page")
	public void the_page_should_display_accurate_and_relevant_content_in_lending_page() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Lending);
			Commonutilities.Bodycontent110(Excelnames.Lending);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////=================sceanrio 23====//////////////////////
	@Then("I should be redirected to the correct Fraud and Compliance page")
	public void i_should_be_redirected_to_the_correct_fraud_and_compliance_page() {
		try {
			Commonutilities.Dynamicscrolldown(850);
			Thread.sleep(1000);
			CodeboardtechElements.getsubmodulescount(2).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in Fraud and Compliance Page")
	public void the_page_should_display_accurate_and_relevant_content_in_fraud_and_compliance_page() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.FraudandCompliance);
			Commonutilities.Bodycontent210(Excelnames.FraudandCompliance);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////===============scenairo 24=========/////////////////////////
	@Then("I should be redirected to the correct capital market page")
	public void i_should_be_redirected_to_the_correct_capital_market_page() {
		try {
			Commonutilities.Dynamicscrolldown(850);
			Thread.sleep(2000);
			CodeboardtechElements.getsubmodulescount(3).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("the page should display accurate and relevant content in capital market")
	public void the_page_should_display_accurate_and_relevant_content_in_capital_market() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.CapitalMarkert);
			Commonutilities.Bodycontent210(Excelnames.CapitalMarkert);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////================scenario 25======/////////////////////
	@Given("I click on View More in third side")
	public void i_click_on_view_more_in_third_side() {
		try {
			Thread.sleep(1500);
			CodeboardtechElements.getClickoneonHeader(3).click();
			Thread.sleep(900);
			CodeboardtechElements.getViewmorebutton(3).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should be navigated to the App Modernization page")
	public void i_should_be_navigated_to_the_app_modernization_page() {
		try {
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains("app-mordenization")) {
				System.err.println("The user is navigate to App Modernization page");
			}else {
				System.err.println("The user is not navigate to App Modernization page");
				fail();
			}

			int i=80;
			int j=1;
			for (WebElement element : CodeboardtechElements.getAppmordenization()) {
				String u1 = element.getText();
				System.err.println(u1);
				String uw2 = Commonutilities.readExcelData(Excelnames.AppMordenization).get(j).get(0);
				System.err.println(uw2);
				assertEquals(u1, Commonutilities.readExcelData(Excelnames.AppMordenization).get(j).get(0));
				Commonutilities.Dynamicscrolldown(i);
				i=i+80;
				j++;
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	@Then("I should see the correct content for the App Modernization page")
	public void i_should_see_the_correct_content_for_the_app_modernization_page() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Headingcontentwith00(Excelnames.AppMordenization);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("all relevant pictures should be displayed in App Modernization page")
	public void all_relevant_pictures_should_be_displayed_in_app_modernization_page() {
		try {
			Commonutilities.Relaventcontentisshowing(Excelnames.AppMordenization);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////==================scenario 26==========/////////////////////////////
	@Given("I click on View More in fourth side")
	public void i_click_on_view_more_in_fourth_side() {
		try {
			Thread.sleep(1500);
			CodeboardtechElements.getClickoneonHeader(4).click();
			Thread.sleep(900);
			CodeboardtechElements.getViewmorebutton(4).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should be navigated to the SuperCharge your Development page")
	public void i_should_be_navigated_to_the_super_charge_your_development_page() {
		try {
			Thread.sleep(5000);
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains("supercharge")) {
				System.err.println("The user is navigate to App Modernization page");
			}else {
				System.err.println("The user is not navigate to App Modernization page");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////////===============scenario 27===========///////////////////////////
	@Then("The content and pictures on the Supercharge page should be accurate and displayed correctly")
	public void the_content_and_pictures_on_the_supercharge_page_should_be_accurate_and_displayed_correctly() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Supercharge);
			Commonutilities.Bodycontent110(Excelnames.Supercharge);	
			Commonutilities.Relaventcontentisshowing(Excelnames.Supercharge);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////===============scenario 28=======//////////////////////
	@Given("The user is on the Functional Features section of the page")
	public void the_user_is_on_the_functional_features_section_of_the_page() {
		try {
			Commonutilities.Dynamicscrolldown(250);
			if (CodeboardtechElements.getFunctionalfeatureinsupercharge().isDisplayed()) {
				System.err.println("The Functional Feature is getting displayed");
			} else {
				System.err.println("The Functional Feature is not getting displayed");
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should see the following features like User Management, Role Management, Data Access Management, LDAP\\/SSO Medium")
	public void the_user_should_see_the_following_features_like_user_management_role_management_data_access_management_ldap_sso_medium() {
		try {
			Commonutilities.Bodycontent200(Excelnames.SuperchargeFeature);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////////=======================scenario 29==============////////////////////////

	@Given("The user is on the Technical Features section of the page")
	public void the_user_is_on_the_technical_features_section_of_the_page() {
		try {
			Commonutilities.Dynamicscrolldown(1650);
			if (CodeboardtechElements.getTechinicalfeatureinsupercharge().isDisplayed()) {
				System.err.println("The Techinical Feature is getting displayed");
			} else {
				System.err.println("The Techinical Feature is not getting displayed");
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should see eight technical features with correct content")
	public void the_user_should_see_eight_technical_features_with_correct_content() {
		try {
			String user = CodeboardtechElements.getTechinicalfeaturecontent().getText();
			System.err.println(user);
			String user1 = Commonutilities.readExcelData(Excelnames.SuperchargeFeature).get(1).get(0);
			System.err.println(user1);
			assertEquals(user,user1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	////////////////================scenario 30============//////////////////////////
	@Given("The user is on the Advantages and Metrics section of the page")
	public void the_user_is_on_the_advantages_and_metrics_section_of_the_page() {
		try {
			Commonutilities.Dynamicscrolldown(2650);
			if (CodeboardtechElements.getAdvantageandmetricsinsupercharge().isDisplayed()) {
				System.err.println("The Advantage and metrics is getting displayed");
			} else {
				System.err.println("The Advantage and metrics is not getting displayed");
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should see five Advantages and Metrics with correct content")
	public void the_user_should_see_five_advantages_and_metrics_with_correct_content() {
		try {
			String user = CodeboardtechElements.getAdvantageandmetriccontent().getText();
			System.err.println(user);
			String user1 = Commonutilities.readExcelData(Excelnames.SuperchargeFeature).get(2).get(0);
			System.err.println(user1);
			assertEquals(user,user1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	//////////////=============scenario 31=========////////////////////////
	@Given("I click on View More in fifth slide")
	public void i_click_on_view_more_in_fifth_slide() {
		try {
			Thread.sleep(2000);
			CodeboardtechElements.getClickoneonHeader(5).click();
			Thread.sleep(900);
			CodeboardtechElements.getViewmorebutton(5).click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("I should be navigated to the Hyper Scaling Business page")
	public void i_should_be_navigated_to_the_hyper_scaling_business_page() {
		try {
			Thread.sleep(5000);
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains("hyper-scalling")) {
				System.err.println("The user is navigate to Hyper Scalling Business page");
			}else {
				System.err.println("The user is not navigate to Hyper Scalling Business page");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}

	///////==============scenrario 32=========////////////////////
	@Then("The content and pictures on the Hyper Scaling Business page should be accurate and displayed correctly")
	public void the_content_and_pictures_on_the_hyper_scaling_business_page_should_be_accurate_and_displayed_correctly() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.HyperScalling);
			Commonutilities.Bodycontent210(Excelnames.HyperScalling);		
			Commonutilities.Relaventcontentisshowing(Excelnames.HyperScalling);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////===================sceanrio 33===========///////////////////////
	@When("The user clicks on Product Engineer Service")
	public void the_user_clicks_on_product_engineer_service() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getProductengineeringservices().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the corresponding Product Engineer Service page")
	public void the_user_should_be_navigated_to_the_corresponding_product_engineer_service_page() {
		try {
			Thread.sleep(2000);
			String user = Webdrivermanager.getDriver().getCurrentUrl();
			System.err.println(user);
			if (user.contains("product-engineering")) {
				System.err.println("The user is navigate to product-engineering page");
			}else {
				System.err.println("The user is not navigate to product-engineering page");
				fail();
			}
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////===========sceanrio 34=========///////////////////////////
	@Then("The content and pictures on the Product Engineer Service page should be accurate and displayed correctly")
	public void the_content_and_pictures_on_the_product_engineer_service_page_should_be_accurate_and_displayed_correctly() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.PrductEngineeringServices);
			Commonutilities.Bodycontent102(Excelnames.PrductEngineeringServices);
			Commonutilities.Image01(Excelnames.PrductEngineeringServices);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////===============scenario 35===========////////////////////////////
	@Then("I should see {int} separate pages listed under the Product Engineer Service section")
	public void i_should_see_separate_pages_listed_under_the_product_engineer_service_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having"+ int1 +"sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////////===============scenario 35===========/////////////////////////
	@Then("The user should be navigated to the Application Modernization page")
	public void the_user_should_be_navigated_to_the_application_modernization_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Application Modernization page should be accurate")
	public void the_content_and_picture_on_the_application_modernization_page_should_be_accurate() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Headingcontentwith00(Excelnames.ApplicationModernization);
			int i=80;
			int j=1;
			for (WebElement element : CodeboardtechElements.getAppmordenization()) {
				String u1 = element.getText();
				System.err.println(u1);
				String uw2 = Commonutilities.readExcelData(Excelnames.AppMordenization).get(j).get(0);
				System.err.println(uw2);
				assertEquals(u1, Commonutilities.readExcelData(Excelnames.AppMordenization).get(j).get(0));
				Commonutilities.Dynamicscrolldown(i);
				i=i+80;
				j++;
			}
			Commonutilities.Image01(Excelnames.ApplicationModernization);

			System.err.println("The all the content has been correct in the module");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////=================scenario 36=====================//////////////////////////
	@Then("The user should be navigated to the Accelerated developement page")
	public void the_user_should_be_navigated_to_the_accelerated_developement_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Accelerated developement page should be accurate")
	public void the_content_and_picture_on_the_accelerated_developement_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Supercharge);
			Commonutilities.Bodycontent110(Excelnames.Supercharge);		
			Commonutilities.Relaventcontentisshowing(Excelnames.Supercharge);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////======================sceanrio 37=============/////////////////////
	@Then("The user should be navigated to the Engineering page")
	public void the_user_should_be_navigated_to_the_engineering_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Engineering page should be accurate")
	public void the_content_and_picture_on_the_engineering_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.HyperScalling);
			Commonutilities.Bodycontent210(Excelnames.HyperScalling);	
			Commonutilities.Relaventcontentisshowing(Excelnames.HyperScalling);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////============scenario 38========/////////////////////

	@When("The user clicks on Cloud Engineering")
	public void the_user_clicks_on_cloud_engineering() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getCloudEngineering().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the corresponding Cloud Engineering page")
	public void the_user_should_be_navigated_to_the_corresponding_cloud_engineering_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.CloudEngineering);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////==============scenario 39=============////////////////////
	@Then("The content and pictures on the Cloud Engineering page should be accurate and displayed correctly")
	public void the_content_and_pictures_on_the_cloud_engineering_page_should_be_accurate_and_displayed_correctly() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.CloundEngineering1);
			Commonutilities.Bodycontent101(Excelnames.CloundEngineering1);
			Commonutilities.Image02(Excelnames.CloundEngineering1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////=============scenario 40==============//////////////////
	@Then("I should see {int} separate pages listed under the Cloud Engineering section")
	public void i_should_see_separate_pages_listed_under_the_cloud_engineering_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////====================scenario 40===============///////////////////////////

	@Then("The user should be navigated to the Cloud Consulting and Migration page")
	public void the_user_should_be_navigated_to_the_cloud_consulting_and_migration_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Cloud Consulting and Migration page should be accurate")
	public void the_content_and_picture_on_the_cloud_consulting_and_migration_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.CloudConsultingandMigration);
			Commonutilities.Bodycontent201(Excelnames.CloudConsultingandMigration);
			Commonutilities.Image02(Excelnames.CloudConsultingandMigration);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////==============sceanrio 41================////////////////////////////
	@Then("The user should be navigated to the Hybrid Development page")
	public void the_user_should_be_navigated_to_the_hybrid_development_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Hybrid Development page should be accurate")
	public void the_content_and_picture_on_the_hybrid_development_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.HybridDevelopement);
			Commonutilities.Dynamictextcontent(Excelnames.HybridDevelopement);
			Commonutilities.Image202(Excelnames.HybridDevelopement);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////===============scenario 42===========/////////////////////////
	@Then("The user should be navigated to the Native Development page")
	public void the_user_should_be_navigated_to_the_native_development_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Native Development page should be accurate")
	public void the_content_and_picture_on_the_native_development_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.NativeDevelopement);
			Commonutilities.Bodycontent201(Excelnames.NativeDevelopement);
			Commonutilities.Image202(Excelnames.NativeDevelopement);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////====================scenario 43======================//////////////////////////////
	@When("The user clicks on API Economy and Integration Services")
	public void the_user_clicks_on_api_economy_and_integration_services() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getAPIEconomyandIntegrationServices().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the corresponding API Economy and Integration Services page")
	public void the_user_should_be_navigated_to_the_corresponding_api_economy_and_integration_services_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.API);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////==============scenario 44================/////////////////////
	@Then("The content and pictures on the API Economy and Integration Services page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_api_economy_and_integration_services_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.API);
			Commonutilities.Image201(Excelnames.API);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////====================scenario 45=======================/////////////////////////////
	@Then("I should see {int} separate pages listed under the API Economy and Integration Services section")
	public void i_should_see_separate_pages_listed_under_the_api_economy_and_integration_services_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////=============scenairo 45==================///////////
	@Then("The user should be navigated to the API Economy page")
	public void the_user_should_be_navigated_to_the_api_economy_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the API Economy page should be accurate")
	public void the_content_and_picture_on_the_api_economy_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.APIEconomy);
			Commonutilities.Bodycontent101(Excelnames.APIEconomy);
			Commonutilities.Image02(Excelnames.APIEconomy);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////==========================scenario 46========////////////////////////////
	@Then("The user should be navigated to the Microservice Architecture page")
	public void the_user_should_be_navigated_to_the_microservice_architecture_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Microservice Architecture page should be accurate")
	public void the_content_and_picture_on_the_microservice_architecture_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.MicroserviceArchitecture);
			Commonutilities.MicrosericeContainer(Excelnames.MicroserviceArchitecture);
			Commonutilities.Image02(Excelnames.MicroserviceArchitecture);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////========================scenario 47==============///////////////////////
	@When("The user clicks on Testing and Services")
	public void the_user_clicks_on_testing_and_services() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getTestingasService().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Testing and Services pages")
	public void the_user_should_be_navigated_to_the_testing_and_services_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.Testing);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////================scenario 48================////////////////////
	@Then("The content and pictures on the Testing and Services page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_testing_and_services_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.TestingandServices);
			Commonutilities.Bodycontent101(Excelnames.TestingandServices);
			Commonutilities.Multiplewrongcontainer(Excelnames.TestingandServices);
			Commonutilities.Image02(Excelnames.TestingandServices);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////================scenario 49=============////////////////////
	@When("The user clicks on Devops")
	public void the_user_clicks_on_devops() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getDevops().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Devops pages")
	public void the_user_should_be_navigated_to_the_devops_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.Devops);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////////=================scenario 50============////////////////////
	@Then("The content and pictures on the Devops page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_devops_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Devops);
			Commonutilities.MicrosericeContainer(Excelnames.Devops);
			Commonutilities.Image02(Excelnames.Devops);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////==sceanrio 51=======//////////////////////////
	@When("The user clicks on Data Engineering and Intelligence")
	public void the_user_clicks_on_data_engineering_and_intelligence() {
		try {
			CodeboardtechElements.getOfferingdropdown().click();
			CodeboardtechElements.getDataEngineeringIntelligence().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Data Engineering and Intelligence pages")
	public void the_user_should_be_navigated_to_the_data_engineering_and_intelligence_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.DataEngineeringH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////==============scenario 52=============//////////////////
	@When("The content and pictures on the Data Engineering and Intelligence page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_data_engineering_and_intelligence_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.DataEngineer);	
			Commonutilities.Bodycontent101(Excelnames.DataEngineer);
			Commonutilities.Image02(Excelnames.DataEngineer);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////=============scenario 53=======/////////////////////
	@Then("I should see {int} separate pages listed under the Data Engineering and Intelligence section")
	public void i_should_see_separate_pages_listed_under_the_data_engineering_and_intelligence_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////==============scenario 53==============////////////////////////
	@Then("The user should be navigated to the Data Streaming and Transformation page")
	public void the_user_should_be_navigated_to_the_data_streaming_and_transformation_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Data Streaming and Transformation page should be accurate")
	public void the_content_and_picture_on_the_data_streaming_and_transformation_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.DataStreamandTransfer);
			Commonutilities.Bodycontent101(Excelnames.DataStreamandTransfer);
			Commonutilities.Image202(Excelnames.DataStreamandTransfer);	
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////===============scenario 54============///////////////////////////
	@Then("The user should be navigated to the Analytics page")
	public void the_user_should_be_navigated_to_the_analytics_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Analytics page should be accurate")
	public void the_content_and_picture_on_the_analytics_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Analytics);
			Commonutilities.Bodycontent101(Excelnames.Analytics);
			Commonutilities.Image02(Excelnames.Analytics);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////==================scenario 55=========/////////////////////////
	@Then("The user should be navigated to the AI\\/ML page")
	public void the_user_should_be_navigated_to_the_ai_ml_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the AI\\/ML page should be accurate")
	public void the_content_and_picture_on_the_ai_ml_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.AIML);
			Commonutilities.Bodycontent101(Excelnames.AIML);
			Commonutilities.Image02(Excelnames.AIML);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//==========================scenario 56=========////////////////////////////
	@Then("The user should be navigated to the Data visualization page")
	public void the_user_should_be_navigated_to_the_data_visualization_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 4);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Data visualization page should be accurate")
	public void the_content_and_picture_on_the_data_visualization_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.DataVisualization);
			Commonutilities.Dynamictextcontent(Excelnames.DataVisualization);
			Commonutilities.Image02(Excelnames.DataVisualization);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////=====================scenario 57=================////////////////
	@Then("The user should be navigated to the Hyper Automation page")
	public void the_user_should_be_navigated_to_the_hyper_automation_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 5);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Hyper Automation page should be accurate")
	public void the_content_and_picture_on_the_hyper_automation_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.HyperAutomation);
			Commonutilities.Dynamictextcontent(Excelnames.HyperAutomation);

			String act12 = CodeboardtechElements.getWrongimage().getAttribute("src");
			System.err.println(act12);
			String Exp1 = Commonutilities.readExcelData(Excelnames.HyperAutomation).get(0).get(2);
			assertEquals(act12,Exp1);

		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////======================scenario 58=============//////////////////////////
	@When("The user clicks on Insurance from the industries dropdown")
	public void the_user_clicks_on_insurance_from_the_industries_dropdown() {
		try {
			CodeboardtechElements.getIndustriesdropdown().click();
			CodeboardtechElements.getInsuranceunderindustries().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Insurance pages")
	public void the_user_should_be_navigated_to_the_insurance_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.Insurance);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////===========scenairo 59==============//////////////////////////
	@When("The user clicks on Fintech from the industries dropdown")
	public void the_user_clicks_on_fintech_from_the_industries_dropdown() {
		try {
			CodeboardtechElements.getIndustriesdropdown().click();
			CodeboardtechElements.getFintechunderindustries().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Fintech pages")
	public void the_user_should_be_navigated_to_the_fintech_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.Fintech);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////==============scenario 60==================//////////////////////////////
	@When("The user clicks on ISV from the industries dropdown")
	public void the_user_clicks_on_isv_from_the_industries_dropdown() {
		try {
			CodeboardtechElements.getIndustriesdropdown().click();
			CodeboardtechElements.getISVunderindustries().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the ISV pages")
	public void the_user_should_be_navigated_to_the_isv_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.ISV);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////////===============scenario 61=================/////////////////
	@Then("The content and pictures on the ISV page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_isv_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.ISV);
			Commonutilities.Bodycontent101(Excelnames.ISV);
			Commonutilities.Image202(Excelnames.ISV);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////================scenario 62=================/////////////////////////
	@Then("I should see {int} separate pages listed under the ISV section")
	public void i_should_see_separate_pages_listed_under_the_isv_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////==============scenairo 63==============/////////////////////////
	@Then("The user should be navigated to the Architecture and Evaluation service page")
	public void the_user_should_be_navigated_to_the_architecture_and_evaluation_service_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Architecture and Evaluation service page should be accurate")
	public void the_content_and_picture_on_the_architecture_and_evaluation_service_page_should_be_accurate() {
		try {	
			Commonutilities.Headingcontentwith00(Excelnames.ArchitectureandEvaluation);
			Commonutilities.Bodycontent101(Excelnames.ArchitectureandEvaluation);
			Commonutilities.Image02(Excelnames.ArchitectureandEvaluation);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail(); 
		}
	}
	////////////===========scenario 64================////////////////////////
	@Then("The user should be navigated to the Extended Engineering service page")
	public void the_user_should_be_navigated_to_the_extended_engineering_service_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Extended Engineering service page should be accurate")
	public void the_content_and_picture_on_the_extended_engineering_service_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.Extendedengineeringandservices);
			Commonutilities.Dynamictextcontent(Excelnames.Extendedengineeringandservices);
			Commonutilities.Image02(Excelnames.Extendedengineeringandservices);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////////==================scenario 65============//////////////////////////////
	@Then("The user should be navigated to the Co-Owned R and D Labs page")
	public void the_user_should_be_navigated_to_the_co_owned_r_and_d_labs_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Co-Owned R and D Labs page should be accurate")
	public void the_content_and_picture_on_the_co_owned_r_and_d_labs_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.CoRandD);
			Commonutilities.Dynamictextcontent(Excelnames.CoRandD);
			Commonutilities.Image202(Excelnames.CoRandD);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////////=================scenairo 66==============/////////////////
	@When("The user clicks on Logistics from the industries dropdown")
	public void the_user_clicks_on_logistics_from_the_industries_dropdown() {
		try {
			CodeboardtechElements.getIndustriesdropdown().click();
			CodeboardtechElements.getLogisticsunderindustries().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Logistics pages")
	public void the_user_should_be_navigated_to_the_logistics_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.logesticsH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////=================scenario 67================///////////////////////////
	@Then("The content and pictures on the Logistics page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_logistics_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentonpage(Excelnames.Logistics);
			Commonutilities.Bodycontent101(Excelnames.Logistics);
			Commonutilities.Image202(Excelnames.Logistics);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////////=================scenario  68================////////////////////////
	@Then("I should see {int} separate pages listed under the Logistics section")
	public void i_should_see_separate_pages_listed_under_the_logistics_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////=====================scenario 69======================////////////////////
	@Then("The user should be navigated to the Aggregator Solution page")
	public void the_user_should_be_navigated_to_the_aggregator_solution_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Aggregator Solution page should be accurate")
	public void the_content_and_picture_on_the_aggregator_solution_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Aggregatorsolutions);
			Commonutilities.Bodycontent101(Excelnames.Aggregatorsolutions);
			Commonutilities.Image02(Excelnames.Aggregatorsolutions);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////=====================scenario 70===========////////////////////////
	@Then("The user should be navigated to the Logistic Solution page")
	public void the_user_should_be_navigated_to_the_logistic_solution_page() {
		try {	
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Logistic Solution page should be accurate")
	public void the_content_and_picture_on_the_logistic_solution_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Logesticandsolution);
			Commonutilities.Bodycontent101(Excelnames.Logesticandsolution);
			Commonutilities.Image202(Excelnames.Logesticandsolution);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////////=====================scenario 71==============//////////////////////////
	@When("The user clicks on Payment from the industries dropdown")
	public void the_user_clicks_on_payment_from_the_industries_dropdown() {
		try {
			CodeboardtechElements.getIndustriesdropdown().click();
			CodeboardtechElements.getPaymentunderindustries().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Payment pages")
	public void the_user_should_be_navigated_to_the_payment_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.PaymentH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////==============scenario 72================//////////////////////
	@Then("The content and pictures on the Payment page should be accurate and displayed correct")
	public void the_content_and_pictures_on_the_payment_page_should_be_accurate_and_displayed_correct() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Payment);
			Commonutilities.Bodycontent101(Excelnames.Payment);
			Commonutilities.Image02(Excelnames.Payment);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////////============scenario 73==============///////////////////////
	@Then("I should see {int} separate pages listed under the Payment section")
	public void i_should_see_separate_pages_listed_under_the_payment_section(int int1) {
		try {
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////===============scenario 73==============///////////////////////
	@Then("The user should be navigated to the Payment subpage page")
	public void the_user_should_be_navigated_to_the_payment_subpage_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Payment page should be accurate")
	public void the_content_and_picture_on_the_payment_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Paymentsubpage);
			Commonutilities.Bodycontent101(Excelnames.Paymentsubpage);
			Commonutilities.Image02(Excelnames.Paymentsubpage);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////=============scenario 74==========//////////////////////////
	@Then("The user should be navigated to the Chargeback subpage page")
	public void the_user_should_be_navigated_to_the_chargeback_subpage_page() {
		try {
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Chargeback page should be accurate")
	public void the_content_and_picture_on_the_chargeback_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.Chargeback);
			Commonutilities.Dynamictextcontent(Excelnames.Chargeback);
			Commonutilities.Image02(Excelnames.Chargeback);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////============scenario 75====================/////////////////////////
	@When("The user clicks on case studies from the insights dropdown")
	public void the_user_clicks_on_case_studies_from_the_insights_dropdown() {
		try {
			CodeboardtechElements.getInsightdropdown().click();
			CodeboardtechElements.getCasestudiesunderinsight().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Case studies pages")
	public void the_user_should_be_navigated_to_the_case_studies_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.CasestudyH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////============scenairo 76=======================//////////////
	@Then("The content and picture on the Case studies page should be accurate")
	public void the_content_and_picture_on_the_case_studies_page_should_be_accurate() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Headingcontentwith00(Excelnames.Casestudies);
			Commonutilities.Image01(Excelnames.Casestudies);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////==============scenairo 77=============/////////////////////
	@Then("I should see {int} separate pages listed under the Case studies section")
	public void i_should_see_separate_pages_listed_under_the_case_studies_section(int int1) {
		try {
			Commonutilities.switchtoIDframe();
			int used = CodeboardtechElements.getChildsubmodules().size();
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////==============scenario 78================////////////////////
	@Then("The user should be navigated to the Automating and Reducing Risk in Insurance Underwriting subpage")
	public void the_user_should_be_navigated_to_the_automating_and_reducing_risk_in_insurance_underwriting_subpage() {
		try {
			Commonutilities.switchtoIDframe();	
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Automating and Reducing Risk in Insurance Underwriting page should be accurate")
	public void the_content_and_picture_on_the_automating_and_reducing_risk_in_insurance_underwriting_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies1);
	}
	///////////==========================scenario 79================////////////////////
	@Then("The user should be navigated to the Credit Risk with Precision subpage")
	public void the_user_should_be_navigated_to_the_credit_risk_with_precision_subpage() {
		try {
			Commonutilities.switchtoIDframe();	
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Credit Risk with Precision page should be accurate")
	public void the_content_and_picture_on_the_credit_risk_with_precision_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies2);
	}
	////////////================scenairo 80==================///////////////////////
	@Then("The user should be navigated to the Platform Engineering and Development Acceleration subpage")
	public void the_user_should_be_navigated_to_the_platform_engineering_and_development_acceleration_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Platform Engineering and Development Acceleration page should be accurate")
	public void the_content_and_picture_on_the_platform_engineering_and_development_acceleration_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies3);
	}
	////////============scenario 81========////////////
	@Then("The user should be navigated to the Rapid Portal Development; minimizing failures and maximize ROI subpage")
	public void the_user_should_be_navigated_to_the_rapid_portal_development_minimizing_failures_and_maximize_roi_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 4);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Rapid Portal Development; minimizing failures and maximize ROI page should be accurate")
	public void the_content_and_picture_on_the_rapid_portal_development_minimizing_failures_and_maximize_roi_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.CaseStudies4);
	}
	/////////================scenario 82===========/////////////////////
	@Then("The user should be navigated to the Re-Architecting and Modernizing to cater fast growing Insurance Market subpage")
	public void the_user_should_be_navigated_to_the_re_architecting_and_modernizing_to_cater_fast_growing_insurance_market_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 5);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Re-Architecting and Modernizing to cater fast growing Insurance Market page should be accurate")
	public void the_content_and_picture_on_the_re_architecting_and_modernizing_to_cater_fast_growing_insurance_market_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.CaseStudies5);
	}
	///////////===============scenario 83==============////////////////////
	@Then("The user should be navigated to the  Cloud Native Development enabled real time visibility and complex integrations subpage")
	public void the_user_should_be_navigated_to_the_cloud_native_development_enabled_real_time_visibility_and_complex_integrations_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 6);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the  Cloud Native Development enabled real time visibility and complex integrations page should be accurate")
	public void the_content_and_picture_on_the_cloud_native_development_enabled_real_time_visibility_and_complex_integrations_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.CaseStudies6);
	}
	////////////=============scenario 84===============//////////////////////
	@Then("The user should be navigated to the  Hybrid Cloud Development for a Core Banking Solution subpage")
	public void the_user_should_be_navigated_to_the_hybrid_cloud_development_for_a_core_banking_solution_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 7);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the  Hybrid Cloud Development for a Core Banking Solution page should be accurate")
	public void the_content_and_picture_on_the_hybrid_cloud_development_for_a_core_banking_solution_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies7);
	}
	///////////////////==============scenario 85===========/////////////////////
	@Then("The user should be navigated to the  API Integration made easy subpage")
	public void the_user_should_be_navigated_to_the_api_integration_made_easy_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 8);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the API Integration made easy page should be accurate")
	public void the_content_and_picture_on_the_api_integration_made_easy_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies8);
	}
	/////////////=============scenario 86=================//////////////////////
	@Then("The user should be navigated to the  Open-source API integration bringing flexibility and agility subpage")
	public void the_user_should_be_navigated_to_the_open_source_api_integration_bringing_flexibility_and_agility_subpage() {
		try {
			Commonutilities.switchtoIDframe();		
			Commonutilities.Dynamicscrollandsubmodules(650, 9);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Open-source API integration bringing flexibility and agility page should be accurate")
	public void the_content_and_picture_on_the_open_source_api_integration_bringing_flexibility_and_agility_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies9);
	}
	///////////=============scenario 87==============///////////////////////
	@Then("The user should be navigated to the Extended Testing as Service Team subpage")
	public void the_user_should_be_navigated_to_the_extended_testing_as_service_team_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 10);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Extended Testing as Service Team page should be accurate")
	public void the_content_and_picture_on_the_extended_testing_as_service_team_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies10);
	}
	///=============scenario 88================/////////////////////
	@Then("The user should be navigated to the Automation Testing fostering agility subpage")
	public void the_user_should_be_navigated_to_the_automation_testing_fostering_agility_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 11);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Automation Testing fostering agility page should be accurate")
	public void the_content_and_picture_on_the_automation_testing_fostering_agility_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies11);
	}
	/////////////////////============scenario 89===========//////////////////////
	@Then("The user should be navigated to the CI\\/CD Automation and Process Streamlining subpage")
	public void the_user_should_be_navigated_to_the_ci_cd_automation_and_process_streamlining_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 12);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the CI\\/CD Automation and Process Streamlining page should be accurate")
	public void the_content_and_picture_on_the_ci_cd_automation_and_process_streamlining_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies12);
	}
	//////////////===================scenario 90===============////////////////////////
	@Then("The user should be navigated to the Data Visualization for Revenue Consolidation subpage")
	public void the_user_should_be_navigated_to_the_data_visualization_for_revenue_consolidation_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 13);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Data Visualization for Revenue Consolidation page should be accurate")
	public void the_content_and_picture_on_the_data_visualization_for_revenue_consolidation_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Casestudies13);
	}
	///////////===============scenario 91========///////////////////
	@When("The user clicks on white paper from the insights dropdown")
	public void the_user_clicks_on_white_paper_from_the_insights_dropdown() {
		try {
			CodeboardtechElements.getInsightdropdown().click();
			CodeboardtechElements.getWhitepaperunderinsight().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the white paper pages")
	public void the_user_should_be_navigated_to_the_white_paper_pages() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.PerspectiveH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////////////=================scenairo 92=============////////////////
	@Then("The content and picture on the white paper page should be accurate")
	public void the_content_and_picture_on_the_white_paper_page_should_be_accurate() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Headingcontentwith00(Excelnames.Whitepaper);
			Commonutilities.Image01(Excelnames.Whitepaper);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////============scenario 93========/////////////////
	@Then("I should see {int} separate pages listed under the white paper section")
	public void i_should_see_separate_pages_listed_under_the_white_paper_section(int int1) {
		try {
			Commonutilities.switchtoIDframe();
			int used = CodeboardtechElements.getChildsubmodules().size();
			assertEquals(int1, CodeboardtechElements.getChildsubmodules().size());
			System.err.println("There are having "+ int1 +" sudmobules");
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	/////==================scenairo 94============////////////////
	@Then("The user should be navigated to the Leveraging an Extended Engineering Team for Insuretech Innovation subpage")
	public void the_user_should_be_navigated_to_the_leveraging_an_extended_engineering_team_for_insuretech_innovation_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 1);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Leveraging an Extended Engineering Team for Insuretech Innovation page should be accurate")
	public void the_content_and_picture_on_the_leveraging_an_extended_engineering_team_for_insuretech_innovation_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper1);
	}
	////////////============scenairo 95============//////////////////
	@Then("The user should be navigated to the Easy to start, even easier to implement subpage")
	public void the_user_should_be_navigated_to_the_easy_to_start_even_easier_to_implement_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 2);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Easy to start, even easier to implement page should be accurate")
	public void the_content_and_picture_on_the_easy_to_start_even_easier_to_implement_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper2);
	}
	/////////============scenario 96===========//////////////////
	@Then("The user should be navigated to the How we approached successful projects subpage")
	public void the_user_should_be_navigated_to_the_how_we_approached_successful_projects_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 3);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the How we approached successful projects page should be accurate")
	public void the_content_and_picture_on_the_how_we_approached_successful_projects_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper3);
	}
	///////////=============scenario 97==============//////////////
	@Then("The user should be navigated to the Rapid Portal Development subpage")
	public void the_user_should_be_navigated_to_the_rapid_portal_development_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 4);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Rapid Portal Development page should be accurate")
	public void the_content_and_picture_on_the_rapid_portal_development_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper4);
	}
	//////////===============scenairo 98=============//////////////////////
	@Then("The user should be navigated to the Unlocking the Power of Application Modernization: Transform Your Business for the Digital Era subpage")
	public void the_user_should_be_navigated_to_the_unlocking_the_power_of_application_modernization_transform_your_business_for_the_digital_era_subpage() {
		try {
			Commonutilities.switchtoIDframe();			
			Commonutilities.Dynamicscrollandsubmodules(650, 5);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Unlocking the Power of Application Modernization: Transform Your Business for the Digital Era page should be accurate")
	public void the_content_and_picture_on_the_unlocking_the_power_of_application_modernization_transform_your_business_for_the_digital_era_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.ApplicationModernization);
			Commonutilities.Relaventcontentisshowing(Excelnames.AppMordenization);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}	
	}
	///////========scenairo 99==========///////////////////
	@Then("The user should be navigated to the Solving Problems during Product Life Cycle for Software Vendors subpage")
	public void the_user_should_be_navigated_to_the_solving_problems_during_product_life_cycle_for_software_vendors_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 6);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Solving Problems during Product Life Cycle for Software Vendors page should be accurate")
	public void the_content_and_picture_on_the_solving_problems_during_product_life_cycle_for_software_vendors_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper6);
	}
	////////==============scenario 100===========///////////////////
	@Then("The user should be navigated to the Grow with the growth subpage")
	public void the_user_should_be_navigated_to_the_grow_with_the_growth_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 7);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the SGrow with the growth page should be accurate")
	public void the_content_and_picture_on_the_s_grow_with_the_growth_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper7);
	}
	//////////==============scenairo 101======//////////////////////
	@Then("The user should be navigated to the How Fruitful Are AI & Blockchain In Insurance Claims Management? subpage")
	public void the_user_should_be_navigated_to_the_how_fruitful_are_ai_blockchain_in_insurance_claims_management_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 8);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the How Fruitful Are AI & Blockchain In Insurance Claims Management? page should be accurate")
	public void the_content_and_picture_on_the_how_fruitful_are_ai_blockchain_in_insurance_claims_management_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper8);
	}
	///////////============scenairo 102=============//////////////////
	@Then("The user should be navigated to the Identifying Credit Card Frauds Using AI subpage")
	public void the_user_should_be_navigated_to_the_identifying_credit_card_frauds_using_ai_subpage() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Dynamicscrollandsubmodules(650, 10);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Identifying Credit Card Frauds Using AI page should be accurate")
	public void the_content_and_picture_on_the_identifying_credit_card_frauds_using_ai_page_should_be_accurate() {
		Commonutilities.HeadingPicandContextvalidatorincasestudies(Excelnames.Whitepaper10);
	}
	/////////////////=========================scenario 103========///////////////////////
	@When("The user clicks on culture from the about us dropdown")
	public void the_user_clicks_on_culture_from_the_about_us_dropdown() {
		try {
			CodeboardtechElements.getAboutus().click();
			CodeboardtechElements.getCulture().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the culture page")
	public void the_user_should_be_navigated_to_the_culture_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.CultureH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the culture page should be accurate")
	public void the_content_and_picture_on_the_culture_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Culture);
			Commonutilities.Bodycontent101(Excelnames.Culture);	
			Commonutilities.Image02(Excelnames.Culture);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////================scenario 104========///////////////////////////
	@When("The user clicks on Work with us from the about us dropdown")
	public void the_user_clicks_on_work_with_us_from_the_about_us_dropdown() {
		try {
			CodeboardtechElements.getAboutus().click();
			CodeboardtechElements.getWorkwithus().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Work with us page")
	public void the_user_should_be_navigated_to_the_work_with_us_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.WorkwithusH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Work with us page should be accurate")
	public void the_content_and_picture_on_the_work_with_us_page_should_be_accurate() {
		try {
			Commonutilities.switchtoIDframe();
			Commonutilities.Headingcontentwith00(Excelnames.Workwithus);

			Commonutilities.Bodycontent110(Excelnames.Workwithus);

			Commonutilities.Bodycontent201(Excelnames.Workwithus);

			String usess = CodeboardtechElements.getImageincasestudies().getAttribute("src");
			System.err.println(usess);
			String usededf = Commonutilities.readExcelData(Excelnames.Workwithus).get(0).get(2);
			assertEquals(usess,usededf);

		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	//////////================scenario 105==============///////////////////////////
	@When("The user clicks on Tools and Technology from the about us dropdown")
	public void the_user_clicks_on_tools_and_technology_from_the_about_us_dropdown() {
		try {
			CodeboardtechElements.getAboutus().click();
			CodeboardtechElements.getToolandTechnology().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Tools and Technology page")
	public void the_user_should_be_navigated_to_the_tools_and_technology_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.TechnologyH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Tools and Technology page should be accurate")
	public void the_content_and_picture_on_the_tools_and_technology_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.Toolsandtechnology);
			int i=0;
			for (WebElement element : CodeboardtechElements.getToolsandTechnologyused()) {
				String s12 = element.getText();
				System.err.println(s12);
				String sss12 = Commonutilities.readExcelData(Excelnames.Toolsandtechnology).get(i).get(0);
				System.err.println(sss12);
				assertEquals(s12,sss12);
				i++;
			}
			Commonutilities.Image02(Excelnames.Toolsandtechnology);	
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	///////////=================sceanrio 106==============////////////////////////////////////////
	@When("The user clicks on Engagement Model from the about us dropdown")
	public void the_user_clicks_on_engagement_model_from_the_about_us_dropdown() {
		try {
			CodeboardtechElements.getAboutus().click();
			CodeboardtechElements.getEngagementmodel().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Engagement Model page")
	public void the_user_should_be_navigated_to_the_engagement_model_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.EngagementH);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Engagement Model page should be accurate")
	public void the_content_and_picture_on_the_engagement_model_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith01(Excelnames.Engagementmodel);
			Commonutilities.Bodycontent100(Excelnames.Engagementmodel);
			Commonutilities.Bodycontent210(Excelnames.Engagementmodel);
			Commonutilities.Image02(Excelnames.Engagementmodel);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	////////////==================scenario 107=============/////////////////////
	@When("The user clicks on Team from the about us dropdown")
	public void the_user_clicks_on_team_from_the_about_us_dropdown() {
		try {
			CodeboardtechElements.getAboutus().click();
			CodeboardtechElements.getTeam().click();
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The user should be navigated to the Team page")
	public void the_user_should_be_navigated_to_the_team_page() {
		try {
			Commonutilities.navigatesuccessfullornot(Excelnames.TeamH);	
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
	@Then("The content and picture on the Team page should be accurate")
	public void the_content_and_picture_on_the_team_page_should_be_accurate() {
		try {
			Commonutilities.Headingcontentwith00(Excelnames.Team);
			Commonutilities.Bodycontent101(Excelnames.Team);
			Commonutilities.Image02(Excelnames.Team);
		} catch (Exception e) {
			Commonutilities.screenshot();
			fail();
		}
	}
}
