package DemoforICON;

public class array {

	public static void main(String[] args) {
		int [] arr= {9,7,15,1,5,0};
		for (int i = 0; i < arr.length-1; i++) {
			for (int j = 0; j < arr.length-i-1; j++) {
				if (arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		int n = arr.length;
		System.out.println(arr[n-2]);
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[n-1]);
//		}
	}
}
