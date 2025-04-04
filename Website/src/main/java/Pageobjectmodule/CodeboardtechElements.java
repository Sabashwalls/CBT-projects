package Pageobjectmodule;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import Webdrivermanager.Webdrivermanager;

public class CodeboardtechElements {
	
	private static CodeboardtechElements CodeboardtechElements;

	private CodeboardtechElements() {}

	public static CodeboardtechElements getprojectinstance() {

		if (CodeboardtechElements==null) {
			CodeboardtechElements = new CodeboardtechElements();
		}
		return CodeboardtechElements;
	}
	
	@FindBy(xpath = "//div[@class='col-lg-5 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column  justify-content-center']/img")
	private static WebElement pictures;
	
	public static WebElement getPictures() {
		return pictures;
	}

	@FindAll({
		@FindBy(xpath = "//nav[@id='navbar']/child::ul/child::li/a")
	})
	private static List<WebElement> Headerdropdowns;
	
	@FindBy(xpath = "//div[@class='wrapper show']")
	private static WebElement cookies;
	
	@FindBy(xpath = "//button[@id='acceptBtn']")
	private static WebElement cookiesacceptbuton;
	
	@FindBy(xpath = "//div[@class='content']/p")
	private static WebElement cookiescontent;
	
	@FindBy(xpath = "//a[@class='footer-logo']")
	private static WebElement footerlogo;
	
	public static WebElement getFooterlogo() {
		return footerlogo;
	}	
	
	
	@FindAll({
		@FindBy(xpath = "//div[@class='container ']")
	})
	private static List<WebElement> multiplewrongcontainer;
	
	public static List<WebElement> getMultiplewrongcontainer() {
		return multiplewrongcontainer;
	}

	@FindBy(xpath = "//div[@class='container ']")
	private static WebElement microsercontainer;
	
	public static WebElement getMicrosercontainer() {
		return microsercontainer;
	}

	@FindBy(xpath = "//div[contains(@class, 'justify-content-center')]/h1")
	private static WebElement headingcontent;
	
	@FindBy(xpath = "(//div[@class='container'])[1]/div[2]")
	private static WebElement InsuranceContainer;
	
	@FindBy(xpath = "(//div[@class='container'])[2]")
	private static WebElement Fraudandcompliance;
	
	@FindBy(xpath = "(//div[@class='container'])[2]")
	private static WebElement Bodycontent2;
	
	public static WebElement getBodycontent2() {
		return Bodycontent2;
	}

	@FindAll({
		@FindBy(xpath = "((//div[@class='container'])[2]/div)[position()<3]")	
	})
	private static List<WebElement> Dynamiccontent;
	
	@FindBy(xpath = "//ul[@class='ul-line-height-2']")
	private static WebElement workwithuscontent;
	
	
	public static WebElement getWorkwithuscontent() {
		return workwithuscontent;
	}

	public static List<WebElement> getDynamiccontent() {
		return Dynamiccontent;
	}

	public static WebElement getFraudandcompliance() {
		return Fraudandcompliance;
	}
	
	@FindBy(xpath = "(//div[@class='container'])[3]")
	private static WebElement techinicalfeaturecontent;
	
	@FindBy(xpath = "(//div[@data-element_type='container'])[2]")
	private static WebElement iframecontent;
	
	public static WebElement getIframecontent() {
		return iframecontent;
	}

	@FindBy(xpath = "(//div[@class='container'])[4]")
	private static WebElement advantageandmetriccontent;
	
	public static WebElement getAdvantageandmetriccontent() {
		return advantageandmetriccontent;
	}

	public static WebElement getTechinicalfeaturecontent() {
		return techinicalfeaturecontent;
	}

	@FindAll({
		@FindBy(xpath = "//div[@class='member-img']")	
	})
	private static List<WebElement> Childsubmodules;


	public static List<WebElement> getChildsubmodules() {
		return Childsubmodules;
	}

	public static WebElement getInsuranceContainer() {
		return InsuranceContainer;
	}

	public static WebElement getHeadingcontent() {
		return headingcontent;
	}

	@FindBy(xpath = "(//div[@class='section-title'])[2]")
	private static WebElement functionalfeatureinsupercharge;
	
	@FindBy(xpath = "(//div[@class='section-title card-full-bottom-services'])")
	private static WebElement Techinicalfeatureinsupercharge;
	
	@FindBy(xpath = "(//div[@class='section-title'])[4]")
	private static WebElement Advantageandmetricsinsupercharge;
	
	@FindBy(xpath = "(//div[@class='section-title'])[5]")
	private static WebElement Howtostartinsupercharge;
	
	public static WebElement getHowtostartinsupercharge() {
		return Howtostartinsupercharge;
	}

	public static WebElement getAdvantageandmetricsinsupercharge() {
		return Advantageandmetricsinsupercharge;
	}

	public static WebElement getTechinicalfeatureinsupercharge() {
		return Techinicalfeatureinsupercharge;
	}

	public static WebElement getFunctionalfeatureinsupercharge() {
		return functionalfeatureinsupercharge;
	}

	@FindBy(xpath = "(//div[@class='row'])[3]")
	private static WebElement salesandquotescontent;
	
	@FindBy(xpath = "(//div[@class='row'])[2]")
	private static WebElement Reinsurance;
	
	@FindBy(xpath = "(//div[@class='row'])[2]")
	private static WebElement Bodycontent1;
	
	public static WebElement getBodycontent1() {
		return Bodycontent1;
	}

	@FindBy(xpath = "//iframe[@id='idIframe']")
	private static WebElement IDframe;
	
	public static WebElement getIDframe() {
		return IDframe;
	}

	public static WebElement getReinsurance() {
		return Reinsurance;
	}

	public static WebElement getSalesandquotescontent() {
		return salesandquotescontent;
	}

	@FindBy(xpath = "//div[@class='col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column  justify-content-center'][2]/img")
	private static WebElement headingimage;

	public static WebElement getHeadingimage() {
		return headingimage;
	}

	public static WebElement getSlideheadingOfHomePage(int numberOfTheSlide) {
        String dynamicXpath = "(//div[@class='col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column   justify-content-center']/h1)[" 
                              + numberOfTheSlide + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	public static WebElement getsubmodulescount(int numberOfTheSlide) {
        String dynamicXpath = "(//div[@class='member-img'])[" 
                              + numberOfTheSlide + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	public static WebElement getSlidecontentOfHomePage(int numberOfTheSlide) {
        String dynamicXpath = "(//div[@class='col-lg-6 pt-5 pt-lg-0 order-2 order-lg-1 d-flex flex-column   justify-content-center']/h2)[" 
                              + numberOfTheSlide + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	public static WebElement getSlideimageOfHomePage(int numberOfTheSlide) {
        String dynamicXpath = "(//div[@class='col-lg-6 pt-5 pt-lg-0 order-1 order-lg-1 d-flex flex-column justify-content-center']/img)[" 
                              + numberOfTheSlide + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	public static WebElement getSlideimageOfHomePagefooter(int numberOfTheSlide) {
        String dynamicXpath = "(//img[@class='img-fluid animated'])[" 
                              + numberOfTheSlide + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	
	@FindBy(xpath = "//div[@class='footer-content']/descendant::p[1]")
	private static WebElement footercontent;
	
	public static WebElement getFootercontent() {
		return footercontent;
	}
	
	@FindBy(xpath = "//img[@class='img-fluid animated']")
	private static WebElement image;
	
	@FindBy(xpath = "//img[@class='img-fluid animated head-img-top']")
	private static WebElement image2;
	
	@FindBy(xpath = "//img[@class='img-fluid animated ']")
	private static WebElement wrongimage;
	
	@FindBy(xpath = "//img[@decoding='async']")
	private static WebElement Imageincasestudies;
	
	@FindAll({
		@FindBy(xpath = "//section[@class='features']")
	})
	private static List<WebElement> ToolsandTechnologyused;
	

	public static List<WebElement> getToolsandTechnologyused() {
		return ToolsandTechnologyused;
	}

	public static WebElement getImageincasestudies() {
		return Imageincasestudies;
	}

	public static WebElement getWrongimage() {
		return wrongimage;
	}

	public static WebElement getImage2() {
		return image2;
	}

	public static WebElement getImage() {
		return image;
	}

	@FindAll({
		@FindBy(xpath = "//div[@class='footer-content']/descendant::ul[1]")
	})
	private static List<WebElement> Quicklinks;

	public static List<WebElement> getQuicklinks() {
		return Quicklinks;
	}
	
	
	@FindAll({
		@FindBy(xpath = "//div[@class='footer-content']/descendant::div[13]/div/a/p")
	})
	private static List<WebElement> ournewsletter;
	
	public static List<WebElement> getOurnewsletter() {
		return ournewsletter;
	}

	@FindAll({
		@FindBy(xpath = "//div[@class='footer-content']/descendant::ul[2]")
	})
	private static List<WebElement> Otherlinks;	

	public static List<WebElement> getOtherlinks() {
		return Otherlinks;
	}

	@FindAll({
		@FindBy(xpath = "(//div[@class='carousel-inner'])[1]/div/div/div[1]/h1")
	})
	private static List<WebElement> Headerslides; 
	
	@FindAll({
		@FindBy(xpath = "(//div[@class='carousel-inner'])[2]/div/div/div[1]/h1")
	})
	private static List<WebElement> Footerslides; 
	
	
	public static List<WebElement> getFooterslides() {
		return Footerslides;
	}

	@FindAll({
		@FindBy(xpath = "//p[@class='card-title']")
	})
	private static List<WebElement> fourcardsname; 
	
	
	
	public static WebElement getcardcontentforfour(int numberOfThecard) {
        String dynamicXpath = "(//ul[@class='card-content-list'])[" 
                              + numberOfThecard + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	@FindAll(
			{
				@FindBy(xpath = "(//div[@class='icon-box'])")
			})
	private static List<WebElement> whyustextbox;
	
	
	public static WebElement getClickoneonfooter(int numberofclick) {
        String dynamicXpath = "(//ol[@id='carousel-indicators'])[2]/li[" 
                              + numberofclick + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	
	public static WebElement getViewmorebutton(int viewmorenumber) {
        String dynamicXpath = "(//a[@class='btn-get-started scrollto']) [" 
                              + viewmorenumber + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	public static WebElement getClickoneonHeader(int numberofclick) {
        String dynamicXpath = "(//ol[@id='carousel-indicators'])[1]/li[" 
                              + numberofclick + "]";
        return Webdrivermanager.getDriver().findElement(By.xpath(dynamicXpath));
    }
	
	
	public static List<WebElement> getWhyustextbox() {
		return whyustextbox;
	}
	
	@FindBy(xpath = "(//ol[@id='carousel-indicators'])[2]/li[1]")
	private static WebElement clickone;

	public static WebElement getClickone() {
		return clickone;
	}

	@FindBy(xpath = "//ul[@class='card-content-list']")
	private static WebElement cardcontent;
	

	public static WebElement getCardcontent() {
		return cardcontent;
	}

	public static List<WebElement> getFourcardsname() {
		return fourcardsname;
	}

	@FindBy(xpath = "//div[@class='col-lg-12']")
	private static WebElement aboutuscontent;
	
	@FindBy(xpath = "//a[@class='getstarted scrollto']")
	private static WebElement contactinheader;
	
	@FindBy(xpath = "(//div[@class='section-title'])[2]")
	private static WebElement whatweoffersection;
	
	@FindBy(xpath = "(//div[@class='section-title'])[3]")
	private static WebElement Whyussection;
	
	public static WebElement getWhyussection() {
		return Whyussection;
	}
	
	
	////////////////////////////////////////underwriting page///////////////////////////////////////////////
	
	@FindAll({
		@FindBy(xpath = "(//div[@class='elementor-widget-container'])[position()>1]")
	})
	private static List<WebElement> underwritingcontent;
	
	public static List<WebElement> getUnderwritingcontent() {
		return underwritingcontent;
	}
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
			
	@FindAll({
		@FindBy(xpath = "(//div[@class='elementor-widget-container'])[position()>1 and position()<14]")
	})
	private static List<WebElement> appmordenization;
				
	public static List<WebElement> getAppmordenization() {
		return appmordenization;
	}

	public static WebElement getWhatweoffersection() {
		return whatweoffersection;
	}

	public static WebElement getContactinheader() {
		return contactinheader;
	}

	public static WebElement getAboutuscontent() {
		return aboutuscontent;
	}

	public static List<WebElement> getHeaderslides() {
		return Headerslides;
	}

	public static WebElement getCookiescontent() {
		return cookiescontent;
	}

	public static WebElement getCookiesacceptbuton() {
		return cookiesacceptbuton;
	}

	public static WebElement getCookiesdeclinebuton() {
		return cookiesdeclinebuton;
	}

	@FindBy(xpath = "//button[@id='declineBtn']")
	private static WebElement cookiesdeclinebuton;
	
	
	@FindBy(xpath = "//nav[@id='navbar']/ul/li[2]")
	private static WebElement offeringdropdown;
	
	@FindBy(xpath = "//nav[@id='navbar']/ul/li[3]")
	private static WebElement Industriesdropdown;
	
	@FindBy(xpath = "//nav[@id='navbar']/ul/li[4]")
	private static WebElement Insightdropdown;
	
	@FindBy(xpath = "//nav[@id='navbar']/ul/li[5]")
	private static WebElement aboutus;
	
	public static WebElement getAboutus() {
		return aboutus;
	}

	public static WebElement getInsightdropdown() {
		return Insightdropdown;
	}

	public static WebElement getIndustriesdropdown() {
		return Industriesdropdown;
	}

	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[2]")
	private static WebElement CloudEngineering;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[3]")
	private static WebElement APIEconomyandIntegrationServices;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[4]")
	private static WebElement TestingasService;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[5]")
	private static WebElement Devops;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[6]")
	private static WebElement DataEngineeringIntelligence;
	
	public static WebElement getCloudEngineering() {
		return CloudEngineering;
	}

	public static WebElement getAPIEconomyandIntegrationServices() {
		return APIEconomyandIntegrationServices;
	}

	public static WebElement getTestingasService() {
		return TestingasService;
	}

	public static WebElement getDevops() {
		return Devops;
	}

	public static WebElement getDataEngineeringIntelligence() {
		return DataEngineeringIntelligence;
	}

	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[2]/ul/li/a[1])[1]")
	private static WebElement Productengineeringservices;
	
	public static WebElement getProductengineeringservices() {
		return Productengineeringservices;
	}

	public static WebElement getOfferingdropdown() {
		return offeringdropdown;
	}

	public static WebElement getCookies() {
		return cookies;
	}

	public static List<WebElement> getHeaderdropdowns() {
		return Headerdropdowns;
	}

	
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[3]/ul/li/a[1])[1]")
	private static WebElement insuranceunderindustries;

	public static WebElement getInsuranceunderindustries() {
		return insuranceunderindustries;
	}
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[3]/ul/li/a[1])[2]")
	private static WebElement fintechunderindustries;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[5]/ul/li/a[1])[1]")
	private static WebElement culture;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[5]/ul/li/a[1])[2]") 
	private static WebElement workwithus;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[5]/ul/li/a[1])[3]")
	private static WebElement ToolandTechnology;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[5]/ul/li/a[1])[5]")
	private static WebElement Team;
	
	public static WebElement getTeam() {
		return Team;
	}

	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[5]/ul/li/a[1])[4]")
	private static WebElement engagementmodel;
	
	public static WebElement getEngagementmodel() {
		return engagementmodel;
	}

	public static WebElement getToolandTechnology() {
		return ToolandTechnology;
	}

	public static WebElement getWorkwithus() {
		return workwithus;
	}

	public static WebElement getCulture() {
		return culture;
	}

	public static WebElement getFintechunderindustries() {
		return fintechunderindustries;
	}
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[3]/ul/li/a[1])[3]")
	private static WebElement ISVunderindustries;

	public static WebElement getISVunderindustries() {
		return ISVunderindustries;
	}
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[3]/ul/li/a[1])[4]")
	private static WebElement Logisticsunderindustries;

	public static WebElement getLogisticsunderindustries() {
		return Logisticsunderindustries;
	}
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[3]/ul/li/a[1])[5]")
	private static WebElement Paymentunderindustries;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[4]/ul/li/a[1])[1]")
	private static WebElement casestudiesunderinsight;
	
	@FindBy(xpath = "(//nav[@id='navbar']/ul/li[4]/ul/li/a[1])[2]")
	private static WebElement whitepaperunderinsight;

	public static WebElement getWhitepaperunderinsight() {
		return whitepaperunderinsight;
	}

	public static WebElement getCasestudiesunderinsight() {
		return casestudiesunderinsight;
	}

	public static WebElement getPaymentunderindustries() {
		return Paymentunderindustries;
	}
	
}
