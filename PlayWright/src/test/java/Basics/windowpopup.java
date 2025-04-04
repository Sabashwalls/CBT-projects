package Basics;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class windowpopup {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
		Browser browser = playwright.chromium().launch(headless);
		Page page = browser.newPage();
		
		page.navigate("https://letcode.in/window");
		Page popupwindow = page.waitForPopup(()->{
			page.locator("id=home").click();
		});
		System.out.println(popupwindow.title());
		System.out.println(popupwindow.url());
		
		popupwindow.close();
		playwright.close();
	}

}
