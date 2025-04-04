package DemoforICON;
import java.util.ArrayList;
import java.util.Arrays;
	 
	public class Alphabetic {
	 
		 public static void main(String[] args) {
		        String input = "DBacCAbd";
		        String sortedString = customSort(input);
		        System.out.println(sortedString); // Output: aAbBcCdD
		    }//B
		    public static String customSort(String input) {
		        char[] chars = input.toCharArray();
		        int n = chars.length;
		        for (int i = 0; i < n - 1; i++) {
		            for (int j = 0; j < n - i - 1; j++) {
		                char currentLower = Character.toLowerCase(chars[j]);
		                char nextLower = Character.toLowerCase(chars[j + 1]);
		                if (currentLower > nextLower) {
		                    // Swap characters
		                    char temp = chars[j];
		                    chars[j] = chars[j + 1];
		                    chars[j + 1] = temp;
		                }
		                else if (currentLower == nextLower) {
		                    if (chars[j] < chars[j + 1] && Character.isUpperCase(chars[j])) {
		                        char temp = chars[j];
		                        chars[j] = chars[j + 1];
		                        chars[j + 1] = temp;
		                    }
		                }
		            }
		        }
		        return new String(chars);
		    }
	}
