package DemoforICON;

import java.util.Iterator;

public class distinctnumber1 {
	public static void main(String[] args) {
		int [] list= {3,8,15,7};
		int [] list1= {1,2,3,4};
		System.out.println(Distinctnumber(list, 10));
		System.out.println(Distinctnumber(list1, 8));
	}
	public static boolean Distinctnumber(int [] array,int targetnumber) {
		for (int i = 0; i < array.length; i++) {
			for (int j = i+1; j < array.length-1; j++) {
			if (array[i]+array[j]==targetnumber) {
				return true;
			}	
			}
		}
		return false;
	}
}
