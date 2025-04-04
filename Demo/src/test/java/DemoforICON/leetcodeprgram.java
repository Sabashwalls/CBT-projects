package DemoforICON;

import java.util.ArrayList;
import java.util.Iterator;

public class leetcodeprgram {

	public static void main(String[] args) {

		int [] num= {3,2,4};
		System.out.println(sumofnumbers(num, 6));	
	}
	
	public static ArrayList<Integer> sumofnumbers(int[] array, int targetnumber) {
	
		int length = array.length;
		
		ArrayList<Integer> number22 = new ArrayList<Integer>();
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array.length; j++) {
				if (i!=j && array[i]+array[j]==targetnumber) {
					number22.add(i);
				}
			}
		}
		return number22;
	}

}
