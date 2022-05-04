package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13300_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] arr = new int[12];
		int cnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			if(arr[gender+(grade-1)*2]==0) cnt++;
			arr[gender+(grade-1)*2]++;
			if(arr[gender+(grade-1)*2]>K) {
				arr[gender+(grade-1)*2]-=K;
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}

}
