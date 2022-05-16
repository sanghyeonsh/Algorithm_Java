package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19941_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		char[] arr = new char[N];
		String str = br.readLine();
		for(int i=0;i<N;i++) {
			arr[i] = str.charAt(i);
		}
		int ans = 0;
		boolean flag = false;
		for(int i=0;i<N;i++) {
			flag = false;
			if(arr[i]=='P') {
				for(int j=K;j>=1;j--) {
					if(i-j>=0 && arr[i-j]=='H') {
						arr[i-j]='X';
						ans++;
						flag = true;
						break;
					}
				}
				if(flag) {
					continue;
				}
				for(int j=1;j<=K;j++) {
					if(i+j<N && arr[i+j]=='H') {
						arr[i+j]='X';
						ans++;
						break;
					}
				}
			}
		}
		System.out.println(ans);
	}

}
