package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14696_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int[] acard = new int[5];
			int[] bcard = new int[5];
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=0;j<a;j++) {
				acard[Integer.parseInt(st.nextToken())]++;
			}
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			for(int j=0;j<b;j++) {
				bcard[Integer.parseInt(st.nextToken())]++;
			}
			for(int j=4;j>=1;j--) {
				if(acard[j]>bcard[j]) {
					System.out.println("A");
					break;
				}
				else if(bcard[j]>acard[j]) {
					System.out.println("B");
					break;
				}
				if(j==1) {
					System.out.println("D");
				}
			}
		}
		
		
		
	}

}
