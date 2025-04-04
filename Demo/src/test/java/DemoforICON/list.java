package DemoforICON;

import java.util.ArrayList;
import java.util.List;

public class list {
	
    public static List listtype() {
        // Create a list of strings
        List<String> stringList = new ArrayList<>();

        // Add elements to the list
        stringList.add("Apple");
        stringList.add("Banana");
        stringList.add("Orange");
        stringList.add("Grapes");

        // Print the elements of the list
        System.out.println("List of Strings:");
        for (String str : stringList) {
            System.out.println(str);
        }
		return stringList;
    }
    
    public static void main(String[] args) {
    	
    }
}