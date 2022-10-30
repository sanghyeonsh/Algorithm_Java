package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_김상현 {

	static int N, answer, arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		answer = 0;
		arr = new int[N+1];
		nQueen(1);
		System.out.println(answer);
	}
	private static void nQueen(int row) {
		if(!isAvailable(row-1)) {
			return;
		}
		if(row>N) {
			answer++;
			return;
		}
		for(int i=1;i<=N;i++) {
			arr[row] = i;
			nQueen(row+1);
		}
		
	}

	private static boolean isAvailable(int row) {
		
		for(int i=1;i<row;i++) {
			if(arr[row]==arr[i] || Math.abs(arr[row]-arr[i])==Math.abs(row-i)) {
				return false;
			}
		}
		
		return true;
	}

}
