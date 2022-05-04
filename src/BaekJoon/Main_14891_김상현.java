package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] arr1 = new int[8];
		int[] arr2 = new int[8];
		int[] arr3 = new int[8];
		int[] arr4 = new int[8];
		String str = br.readLine();
		for(int i=0;i<str.length();i++) {
			arr1[i] = str.charAt(i)-'0';
		}
		str = br.readLine();
		for(int i=0;i<str.length();i++) {
			arr2[i] = str.charAt(i)-'0';
		}
		str = br.readLine();
		for(int i=0;i<str.length();i++) {
			arr3[i] = str.charAt(i)-'0';
		}
		str = br.readLine();
		for(int i=0;i<str.length();i++) {
			arr4[i] = str.charAt(i)-'0';
		}
		int n = Integer.parseInt(br.readLine());
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			int clock = Integer.parseInt(st.nextToken());
			
			
		}
		
		
	}
	static boolean check(int[] arr1,int[] arr2) {
		if(arr1[2]==arr2[6]) {
			return true;
		}
		return false;
	}
	static void rotate(int[] arr, int check) {
		if(check==1) {
			int temp = arr[7];
			for(int i=0;i<7;i++) {
				arr[i+1]=arr[i];
			}
			arr[0]=temp;
		}
		if(check==2) {
			int temp = arr[0];
			for(int i=0;i<7;i++) {
				arr[i]=arr[i+1];
			}
			arr[7]=temp;
		}
	}
}
