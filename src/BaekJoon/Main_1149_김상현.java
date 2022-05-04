package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[] redDP = new int[N+1];
		int[] greenDP = new int[N+1];
		int[] blueDP = new int[N+1];
		st = new StringTokenizer(br.readLine());
		redDP[1] = Integer.parseInt(st.nextToken());
		greenDP[1] = Integer.parseInt(st.nextToken());
		blueDP[1] = Integer.parseInt(st.nextToken());
		for(int i=2;i<N+1;i++) {
			st = new StringTokenizer(br.readLine());
			int red = Integer.parseInt(st.nextToken());
			int green = Integer.parseInt(st.nextToken());
			int blue = Integer.parseInt(st.nextToken());
			redDP[i] = red + Math.min(greenDP[i-1], blueDP[i-1]);
			greenDP[i] = green + Math.min(redDP[i-1], blueDP[i-1]);
			blueDP[i] = blue + Math.min(greenDP[i-1], redDP[i-1]);
			
		}
		System.out.println(Math.min(blueDP[N],Math.min(redDP[N], greenDP[N])));
		
	}

}
