//      *****
//      ****
//      ***
//      **
//      *

//      *****
//       ****
//        ***
//         **
//          *

package test.practice;

public class Star3 {
	public static void main(String[] args) {

		int rows = 5;

		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("------------------");

//		int rows = 5;

		for (int i = rows; i >= 1; i--) {
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
