package YoutubeStrudy;

import java.util.Scanner;

public class DP1_FibonacciTest {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] D = new long[n+1]; //동적테이블 생성
		// 베이스 값 채우기
		D[0] = 0;
		D[1] = 1;
		for(int i=2;i<=n;i++) { //점화식을 이용하여 상향식으로 동적테이블 채우기
			D[i] = D[i-1] + D[i-2];
		}
		System.out.println(D[n]);
		
		
	}

}
