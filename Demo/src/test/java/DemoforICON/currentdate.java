package DemoforICON;
//import java.time.LocalDate;
//public class currentdate {
//	
//
//	    public static void main(String[] args) {
//	        // Get the current date
//	        LocalDate currentDate = LocalDate.now();
//	        
//	        // Define the number of days to add
//	        int numberOfDaysToAdd = 35; // Change this to the desired number of days
//	        
//	        // Calculate the future date by adding the number of days to the current date
//	        LocalDate futureDate = currentDate.plusDays(numberOfDaysToAdd);
//	        
//	        // Print the future date
//	        System.out.println("Current Date: " + currentDate);
//	        System.out.println("Future Date: " + futureDate);
//	    }
//	}
//
//import java.time.LocalDate;
//import java.time.format.DateTimeFormatter;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//    public static void main(String[] args) {
//
//
//        // Navigate to the web page where the leave balance is displayed
//        driver.get("url_of_the_leave_balance_page");
//
//        // Find the WebElement containing the leave balance date
//        WebElement leaveBalanceDateElement = driver.findElement(By.id("leaveBalanceDateId")); // Replace with the actual ID of the element
//
//        // Get the text of the leave balance date
//        String leaveBalanceDateString = leaveBalanceDateElement.getText();
//
//        // Parse the leave balance date string into a LocalDate object
//        LocalDate leaveBalanceDate = LocalDate.parse(leaveBalanceDateString, DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Adjust the date format as per your web page
//
//        // Get the current date
//        LocalDate currentDate = LocalDate.now();
//
//        // Compare the leave balance date with the current date
//        if (leaveBalanceDate.isEqual(currentDate)) {
//            System.out.println("Leave balance date matches the current date.");
//        } else {
//            System.out.println("Leave balance date does not match the current date.");
//        }
//
//        // Close the browser
//        driver.quit();
//    }
//}

//public class StringSubtraction {
//    public static void main(String[] args) {
//        // Two strings representing numbers
//        String str1 = "10";
//        String str2 = "5";
//
//        // Parse the strings into integers
//        int num1 = Integer.parseInt(str1);
//        int num2 = Integer.parseInt(str2);
//
//        // Perform subtraction
//        int result = num1 - num2;
//
//        // Output the result
//        System.out.println("Result of subtraction: " + result);
//    }
//}



