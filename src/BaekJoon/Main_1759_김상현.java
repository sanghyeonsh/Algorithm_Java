package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_김상현 {

	static char[] arr;
	static boolean[] isVisited;
	static int L;
	static int C;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		isVisited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<C;i++) {
			arr[i]=st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0,0,0,0);
	}
	static void dfs(int start, int cnt, int ja, int mo) {
		if(cnt==L && ja>=2 && mo>=1) {
			for(int i=0;i<C;i++) {
				if(isVisited[i]==true) {
					System.out.print(arr[i]);
				}
			}
			System.out.println();
		}
		for(int i=start;i<C;i++) {
			isVisited[i] = true;
			dfs(i+1,cnt+1,ja+(!check(arr[i])?1:0),mo+(check(arr[i])?1:0));
			isVisited[i] = false;
		}
	}
	static boolean check(char c) {
		if(c=='a'||c=='e'||c=='i'||c=='o'||c=='u') {
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
