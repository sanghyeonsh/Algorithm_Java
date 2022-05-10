package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19539_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		int odd_cnt = 0;
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(st.nextToken());
			sum+=num;
			if(num%2==1) {
				odd_cnt+=1;
			}
		}
		if(sum%3==0 && odd_cnt<=sum/3) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
		
	}

}
