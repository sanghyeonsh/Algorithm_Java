package YoutubeStrudy;

import java.util.Scanner;

public class NQueenBackTrackingTest {

	static int N, ans;
	static int col[];
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ans = 0;
		col = new int[N+1];
		setQueen(1);
		System.out.println(ans);
	}
	
	public static void setQueen(int rowNo) { //rowNo : 퀸을 두어야하는 현재 행
				
		if(!isAvailable(rowNo-1)) return; //직전까지의 상황이 유망하지 않다면 리턴
		
		//기본파트 : 퀸을 모두 놓았다면
		if(rowNo>N) { //1이 시작점 이므로
			ans++;
			return;
		}
		
		// 1열부터 - n열까지 퀸을 놓는 시도
		for(int i=1;i<=N;i++) {
			col[rowNo] = i;
			setQueen(rowNo+1);
		}
	}
	public static boolean isAvailable(int rowNo) {
		
		for(int i=1;i<rowNo;i++) {
			if(col[rowNo] == col[i] || Math.abs(rowNo-i)==Math.abs(col[rowNo]-col[i])) return false;
		}
		return true;
	}
	

}
