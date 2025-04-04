package DemoforICON;

import java.util.Iterator;

public class NOnrepeating {

	public static void main(String[] args) {
		 String str = "swiss";
	        char[] used = str.toCharArray();
	        
	        for (int i = 0; i < used.length; i++) {
	            int count = 0;
	            
	            for (int j = 0; j < used.length; j++) {
	                if (i != j && used[i] == used[j]) { 
	                    count++;
	                    break; // Exit loop as soon as a duplicate is found
	                }
	            }
	            if (count == 0) { // If no duplicate found, print the first non-repeating character
	                System.out.println("First non-repeating character: " + used[i]);
	                return;
	            }
	        }
	        System.out.println("No non-repeating character found.");
	    }
	}
