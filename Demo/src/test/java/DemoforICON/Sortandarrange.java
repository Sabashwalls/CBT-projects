package DemoforICON;

import java.util.Iterator;

public class Sortandarrange {

	public static void main(String[] args) {
		String str = "A4B32C1";
		sortandseperate(str);
	}
	
	public static void sortandseperate(String str) {
		
		int length = str.length();
		
		char[] letters= new char[length];
		char[] numbers = new char [length];
		
		int letterindex=0, numberinde=0;
		
		for (int i = 0; i < str.length(); i++) {
				char ch= str.charAt(i);
				if (ch>='A' && ch<='Z') {
					letters[letterindex++]=ch;
			}else if(ch>='0'&& ch <='9') {
				numbers[numberinde++]=ch;
			}
		}
		for (int i = 0; i < numberinde; i++) {
			for (int j = 0; j < numberinde-i-1; j++) {
				if (numbers[j] > numbers[j+1]) {
					char temp=numbers[j];
					numbers[j]=numbers[j+1];
					numbers[j+1]=temp;
				}
			}
		}
		for (int i = 0; i < letterindex; i++) {
			for (int j = 0; j < letterindex-i-1; j++) {
				if (letters[j]>letters[j+1]) {
					char temp=letters[j];
					letters[j]=letters[j+1];
					letters[j+1]=temp;
				}
			}
		}
		
		for (int i=0; i<letterindex; i++) {
			System.out.print(letters[i]);
		}
		for (int i=0; i<numberinde; i++) {
			System.out.print(numbers[i]);
		}
		
		
	}

}
