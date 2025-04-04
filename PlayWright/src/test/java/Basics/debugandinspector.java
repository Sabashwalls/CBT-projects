package Basics;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.BrowserType.LaunchOptions;

import java.nio.file.Paths;

import com.microsoft.playwright.*;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class debugandinspector {

	public static void main(String[] args) {

		try (Playwright playwright = Playwright.create()) {
			LaunchOptions headless = new BrowserType.LaunchOptions().setHeadless(false).setChannel("chrome");
			Browser broswer = playwright.chromium().launch(headless);
			Page page1 = broswer.newPage();
			page1.navigate("https://www.google.com");

			page1.pause();
			page1.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).click();
			page1.getByLabel("Search", new Page.GetByLabelOptions().setExact(true)).fill("sa");
			page1.getByText("Sanam Teri Kasam").click();
			page1.locator("").click();
			
			Download download = page1.waitForDownload(() -> {
			    page1.locator("your-locator-here").click();
			});

			System.out.println("Downloaded file path: " + download.path());
			System.out.println("Download URL: " + download.url());
			System.out.println("Download failure (if any): " + download.failure());
			System.out.println("Suggested filename: " + download.suggestedFilename());
			download.saveAs(Paths.get("downloads/" + download.suggestedFilename()));

			
			page1.close();
			playwright.close();


		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
