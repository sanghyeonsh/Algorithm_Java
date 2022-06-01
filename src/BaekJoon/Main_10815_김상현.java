package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10815_김상현 {

	static int N,M,arr[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			if(solve(Integer.parseInt(st.nextToken()))) {
				bw.write("1 ");
			}else {
				bw.write("0 ");
			}
		}
		bw.close();
	}

	private static boolean solve(int num) {
		
		int leftIdx = 0;
		int rightIdx = N-1;
		while(leftIdx<=rightIdx) {
			int midIdx = (leftIdx+rightIdx)/2;
			int mid = arr[midIdx];
			if(num<mid) rightIdx = midIdx-1;
			else if(num>mid) leftIdx = midIdx+1;
			else return true;
		}
		return false;
	}

	
}
