package DemoforICON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;

public class sorted01 {

	public static void main(String[] args) throws SQLException {
		
		int a=10;
		System.out.println(a);
		
		Connection con = DriverManager.getConnection("jdbc:mysql://10.10.15.99:3306/hrms_comp_off","hrms_user","cbt123" );

		String query="SELECT relations FROM hrms_comp_off.relations where relations='Father'";

		Statement stm = con.createStatement();
		ResultSet rs = stm.executeQuery(query);

		String news = rs.getString(0);

		System.out.println(news);

		
//		int [] input= {4,4,56,2,34,5,2,2,4,3};
//		int[] arry = sortedprogram(input);
//		for (int i : arry) {
//			System.out.print(i);
//		}
	}
//	public static int [] sortedprogram(int[] array) {
//		int n = array.length;
//		for (int i = 0; i < n-1; i++) {
//			for (int j = 0; j < n-1; j++) {
//				if (array[j]>array[j+1]) {
//					int temp = array[j];
//					array[j]=array[j+1];
//					array[j+1]=temp;
//				}
//			}
//		}
//		return array;
//	}
}
