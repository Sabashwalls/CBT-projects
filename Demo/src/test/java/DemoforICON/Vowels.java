package DemoforICON;

import java.util.Iterator;

public class Vowels {

	public static void main(String[] args) {
		String str = "hello";
		System.out.println(vowelscount(str));
	}
	public static int vowelscount(String str) {
		String str1 = str.toLowerCase();
		int count = 0;
		for (int i = 0; i < str1.length(); i++) {
			char ch = str1.charAt(i);
			if (ch== 'a'|| ch=='e'|| ch =='i'||ch == 'o'|| ch =='u') {
				count++;
			}
		}
		return count;
	}
}
