import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

//	public static void checkEqual(int a, int b) {
//		System.out.println("First value: " + a); 
//		System.out.println("Second value: " + b); 
//		System.out.println("Are they equal?"); 
//		if (a == b) {
//			System.out.println(true); 
//		} else {
//		System.out.println(false);
//		}
//		return;
//	}
	
//	public static void printfFile(String filename) {
//		File file = new File(filename);
//		Scanner fs = new Scanner(file);
//		while(fs.hasNextLine()) {
//			String line = fs.nextLine();
//			System.out.println(line);
//		}
//	}
	
//	public static boolean searchForKey(int key, int[] values) {
//		for(int value: values) {
//			if(value == key)
//				return true;
////			else 
////				return false;
//		}
//		return false;
//	}
	
//	public static int perimeter(int side) throws IllegalArguementException {
//		return 4 * side;
//	}
	
	public static int mystery(int n) {
		System.out.println("O");
		if (n <= 1)
			return 2;
		return n + mystery(n-1);
	}

	public static void main(String[] args) {
//		System.out.print();
//		checkEqual(1, null);
		
//		int[] mytest = new int[] {1, 3, 4, 5};
//		System.out.println(searchForKey(2, mytest));
		
		
//		System.out.println(perimeter(2));
		
		System.out.println(mystery(3));
	}
}
