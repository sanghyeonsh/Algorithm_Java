package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2920_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[8];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		boolean flag = false;
		boolean asc = true;
		for(int i=0;i<8;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<6;i++) {
			if(arr[i]<arr[i+1]) {
				if(arr[i+1]>arr[i+2]) {
					flag = true;
					break;
				}
			}
			if(arr[i]>arr[i+1]) {
				if(arr[i+1]<arr[i+2]) {
					flag = true;
					break;
				}
				asc=false;
			}
		}
		if(!flag && asc==true) {
			System.out.println("ascending");
		}
		if(!flag && asc==false) {
			System.out.println("descending");
		}
		if(flag) {
			System.out.println("mixed");
		}
	}

}
