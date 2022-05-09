package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1292_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int[] arr = new int[1001];
		int cnt = 1;
		int check = 0;
		for(int i=1;i<1001;i++) {
			check++;
			if(check<cnt) {
				arr[i] = cnt;
			}
			else {
				arr[i] = cnt;
				cnt++;
				check = 0;
			}
		}
		int ans = 0;
		for(int i=A;i<=B;i++) {
			ans += arr[i];
		}
		System.out.println(ans);
		
	}

}
