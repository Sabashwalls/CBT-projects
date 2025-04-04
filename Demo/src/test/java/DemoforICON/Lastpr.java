package DemoforICON;

public class Lastpr {

	public static void main(String[] args) {
		String str="Try Reverse String";
		System.out.println(Reverse(str));
		
	}
	
	public static String Reverse(String str) {
		
		char [] ch=str.toCharArray();
		
		int n=ch.length-1;
		
		int left=0, right=n;
		
		while (left < right) {
			if (ch[left]==' ') {
				left++;
			}else if (ch[right]==' ') {
				right--;
			}else {
				char temp=ch[left];
				ch[left]=ch[right];
				ch[right]=temp;
				left++;
				right--;
			}
		}
		return new String(ch);
	}
}
