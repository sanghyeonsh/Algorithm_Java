package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1449_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[Integer.parseInt(st.nextToken())]++;
		}
		int cnt = 0;
		for(int i=0;i<1001;i++) {
			if(arr[i]==1) {
				cnt++;
				i+=L-1;
			}
		}
		System.out.println(cnt);
	}

}
