package DemoforICON;

public class distanctnumbers {

	public static void main(String[] args) {
		int [] list= {3,8,15,7};
		int [] list2= {1,2,3,4};
		System.out.println(DistinctNumber(list, 10));
		System.out.println(DistinctNumber(list2, 8));
	}

	public static boolean DistinctNumber(int [] Value, int Targetnumber) {
		
		int n = Value.length;
		int valueoftwo = Value[0]+Value[n-1];
		if (Targetnumber==valueoftwo) {
			return true;
		}else {
			return false;
		}
	}
}
