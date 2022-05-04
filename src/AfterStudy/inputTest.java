package AfterStudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class inputTest {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("src/AfterStudy/inputTest.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		for(int i=0;i<N;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(a+" "+b);
		}
		
		
	}

}
