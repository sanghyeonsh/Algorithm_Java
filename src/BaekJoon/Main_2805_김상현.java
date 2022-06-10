package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2805_김상현 {

	static int N;
	static long M;
	static long[] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Long.parseLong(st.nextToken());
		arr = new long[N];
		st = new StringTokenizer(br.readLine());
		long tempMax = 0;
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			tempMax=Math.max(tempMax, arr[i]);
		}
		System.out.println(bisearch(arr,0,tempMax,M));
	}
	
	static long bisearch(long[] arr, long start, long end, long key) {
		long mid = (start+end)/2;
		if(start>end) return mid;
		else {
			long sum = 0;
			for(int i=0;i<N;i++) {
				if(arr[i]-mid>0) {
					sum+=arr[i]-mid;
				}
			}
			if(sum>=key) {
				return bisearch(arr,mid+1,end,key);
			}
			else {
				return bisearch(arr,start,mid-1,key);
			}
		}
	}

}
