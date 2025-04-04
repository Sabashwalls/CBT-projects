package Basics;

import org.openqa.selenium.devtools.v120.tracing.Tracing;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class browsercontext {

	public static void main(String[] args) {
		
		Playwright create = Playwright.create();
		BrowserType.LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
		Browser browser = create.chromium().launch(headless);

		// Uncomment and use if video recording is needed
		// BrowserContext context1 = browser.newContext(
//		     new Browser.NewContextOptions()
//		         .setRecordVideoDir(Paths.get("videos/"))
//		         .setRecordVideoSize(1280, 720)
		// );

		BrowserContext newq = browser.newContext();
		
//		newq.tracing().start(new Tracing.StartOptions()
//	                .setScreenshots(true)
//	                .setSnapshots(true));
		
		// Uncomment and use if multiple contexts/pages are needed
		// BrowserContext context2 = browser.newContext();

		// Page page1 = context1.newPage();
		// page1.navigate("https://www.google.com");

		// Page page11 = context2.newPage();
		// page11.navigate("https://naukri.com");

		// Page page22 = context2.newPage();
		// page22.navigate("https://wonderla.com");

		// Page page2 = context1.newPage();
		// page2.navigate("https://www.amazon.com");

		// context1.close();
//		browser.close();
		create.close();

	}

}
