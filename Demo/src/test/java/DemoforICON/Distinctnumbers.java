package DemoforICON;
import java.util.HashSet;
public class Distinctnumbers {
	

	public static class SumOfTwoDistinctNumbers {
	    public static boolean checkIfSumExists(int[] arr, int targetNumber) {
	        // Create a set to store the numbers we have already seen
	        HashSet<Integer> seenNumbers = new HashSet<>();

	        // Traverse the array
	        for (int num : arr) {
	            // If the complement (targetNumber - num) is already in the set, return true
	            if (seenNumbers.contains(targetNumber - num)) {
	                return true;
	            }
	            // Add the current number to the set
	            seenNumbers.add(num);
	        }

	        // If no such pair is found, return false
	        return false;
	    }

	    public static void main(String[] args) {
	        int[] values = {9, 7, 15, 1, 5, 0}; // Input list
	        int target = 10; // Target number

	        if (checkIfSumExists(values, target)) {
	            System.out.println("The given number can be formed by the sum of two distinct numbers in the list.");
	        } else {
	            System.out.println("The given number cannot be formed by the sum of two distinct numbers in the list.");
	        }
	    }
	}


}
