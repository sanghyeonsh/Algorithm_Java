package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1756_김상현 {

	static int[] arr;
	static int D,N,cur,ans;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[D];
		cur = D-1;
		ans = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<D;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		reset();
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			int target = Integer.parseInt(st.nextToken());
			binary(target,0,cur);
		}
		System.out.println(ans+1);
		
	}
	private static void binary(int target, int start, int end) {
		
		int res = -1;
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid]>=target) {
				res = mid;
				start = mid+1;
			}else {
				end = mid-1;
			}
		}
		ans = Math.min(ans, res);
		cur = res-1;
	}
	public static void reset() {
		for(int i=1;i<D;i++) {
			if(arr[i]>arr[i-1]) {
				arr[i] = arr[i-1];
			}
		}
	}

}
