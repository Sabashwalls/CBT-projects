package DemoforICON;

import io.cucumber.core.cli.Main;

public class withoutswapping {

	public static void main(String[] args) {
		
		String str="Try Reverse String";
		System.out.println(str);
		System.out.println(multimethods(str));
	}
	
	public static String multimethods(String str) {
		
		char[] chars=str.toCharArray();
		int left=0;
		int right=chars.length-1;
		while (left < right) {
			if(chars[left]==' ') {
				left++;
				continue;
			}else if(chars[right]==' ') {
				right--;
				continue;
			}else {
				char temp=chars[left];
				chars[left]=chars[right];
				chars[right]=chars[left];
				
				left++;
				right--;
			}
		}
		return new String(chars);
	}

}
