package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_3 {

	static int F,N,cnt[],max;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			F = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int len = st.countTokens();
			for(int i=0;i<len;i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			solve();
			System.out.println("#"+tc+" "+arr.get(F-1));
		}
	}
	private static void solve() {
		while(arr.size()<F) {
			F-=arr.size();
			cntChange();
			for(int i=0;i<arr.size();i++) {
				if(cnt[arr.get(i)]==max) {
					arr.remove(i);
					break;
				}
			}
		}
		
	}
	private static void cntChange() {
		max = 0;
		cnt = new int[N+1];
		for(int i=0;i<arr.size();i++) {
			cnt[arr.get(i)]++;
		}
		for(int i=1;i<=N;i++) {
			max = Math.max(cnt[i], max);
		}
	}

}
