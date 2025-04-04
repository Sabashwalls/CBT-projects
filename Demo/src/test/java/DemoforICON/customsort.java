package DemoforICON;

import java.util.Iterator;

public class customsort {
	
	public static void main(String[] args) {
		String str = "A4B32C1";
		System.out.println(customsort1(str));
	}
	
	public static String customsort1(String str) {
		
		char[] chars = str.toCharArray();
		int n = str.length();
		
		for (int i = 0; i < n-1; i++) {
			for (int j = 0; j < n-1; j++) {
				
				char Currentlower=Character.toLowerCase(chars[j]);
				char nextlower=Character.toLowerCase(chars[j+1]);
				
				if (Currentlower>nextlower) {
					char temp=chars[j];
					chars[j]=chars[j+1];
					chars[j+1]=temp;
				}else if (Currentlower==nextlower) {
					if (chars[j]<chars[j+1] && Character.isUpperCase(chars[j])) {
						
						char temp=chars[j];
						chars[j]=chars[j+1];
						chars[j+1]=temp;
					}
				}
				
			}
		}
		return new String(chars);
	}

}
