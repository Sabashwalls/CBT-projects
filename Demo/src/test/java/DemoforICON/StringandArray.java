package DemoforICON;

public class StringandArray {

	public static void main(String[] args) {
		String Value1="1234564ADVSasada";
		String letters ="";
		String numbers="";
		String smallletters="";
		
		for (int i = 0; i < Value1.length(); i++) {
			char ch=Value1.charAt(i);
			if (ch>='A'&& ch<='Z') {
				letters+=ch;
			} else if(ch>='a'&& ch<='z'){
				smallletters+=ch;
			}else if(ch>='0'&& ch<='9') {
				numbers+=ch;
			}
		}
		String after = letters+smallletters+numbers;
		System.out.println(after);
	}

}
