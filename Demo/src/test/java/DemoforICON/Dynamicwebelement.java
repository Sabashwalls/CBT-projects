package DemoforICON;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Dynamicwebelement {
//	public static String Palindromeornot(String str) {
//		int left=0; int right=str.length()-1;
//		
//		if (left<right) {
//			if (str.charAt(left) != str.charAt(right)) {
//				return "The given "+str+" is not palindrome";
//			}
//			left++;
//			right--;
//		}
//		return "The given "+str+" is palindrome";	
//	}
	
	public static void main(String[] args) {
		        String str = "Try Reverse String";
		        char[] arry = str.toCharArray();
		        
		        for(int i=0;i<=arry.length-1;i++) {
		        	if (arry[i] == ' ') {
						arry[i] = 1;
					}
		        }
		        System.out.println(arry);
		        
//		        List<Integer> numbers = new ArrayList<>();
//		        // Convert string to char array
//		        for (int i = 0; i < str.length(); i++) {
//		            if (str.charAt(i) == ' ') { // Check if character is a space
//		            	numbers.add(i);
//		                System.out.println(i + " these are the indexex with space"); // Print space index
//		            }       
//		    }
//		      System.out.println(numbers);
		}
	}


//		System.out.println(Palindromeornot(str));	
		
		
//			ChromeOptions opt = new ChromeOptions();
//			opt.setAcceptInsecureCerts(true);
//			opt.addArguments("--incognito");
//			opt.addArguments("--start-maximized");
//			opt.addArguments("--window-size=200,400");
//		ChromeDriver driver = new ChromeDriver(opt);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//		driver.manage().window().maximize();
//		
				
		/*
		 * try {
		 * 
		 * driver.get("https://www.moneycontrol.com/stocksmarketsindia/");
		 * driver.manage().deleteAllCookies(); WebElement element =
		 * driver.findElement(By.xpath("//div[text()='Stock Action']"));
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", element);
		 * 
		 * WebElement table =
		 * driver.findElement(By.xpath("(//table[@class='mctable1'])[9]/self::table"));
		 * 
		 * List<WebElement> tableheader = table.findElements(By.xpath(
		 * "(//table[@class='mctable1'])[9]/self::table/thead/tr/th/self::th"));
		 * List<WebElement> tablerow = table.findElements(By.xpath(
		 * "(//table[@class='mctable1'])[9]/self::table/tbody/tr"));
		 * 
		 * for (WebElement head : tableheader) { String column = head.getText();
		 * System.out.println(column + " ");
		 * 
		 * } for (WebElement row : tablerow) { String rows = row.getText();
		 * System.out.println(rows+ " "); } WebElement rrow =
		 * driver.findElement(By.xpath(
		 * "((//table[@class='mctable1'])[9]/self::table/tbody/tr/td)[3]"));
		 * System.out.println(rrow.getText());
		 * 
		 * driver.close();
		 * 
		 * } catch (Exception e) { System.out.println("cant able to intracted"); }
		 */
		

