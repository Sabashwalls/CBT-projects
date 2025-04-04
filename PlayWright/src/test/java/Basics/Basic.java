package Basics;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.SelectOption;

public class Basic {
	
	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(
				new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome"));

		Page page = browser.newPage();
		page.navigate("https://testsheepnz.github.io/BasicCalculator.html");
		System.out.println("Page Title: " + page.title());
		page.mouse().wheel(0, 700);
		
		
//		Locator Firstname = page.locator("//input[@id='number1Field']");
//		Firstname.fill("Demo1");
//		Locator dropdown = page.locator("id=selectOperationDropdown");
//		List<String> lists = dropdown.allInnerTexts();
//		for (String string : lists) {
//			System.out.println(string);
//		}
//		dropdown.selectOption(new SelectOption().setIndex(2));	
//		page.selectOption("id=selectOperationDropdown", "2");
		
		
		browser.close();
		playwright.close();
	}
}
