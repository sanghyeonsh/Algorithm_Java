package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if(gender==1) {
				for(int j=num-1;j<N;j+=num) {
					arr[j]=(arr[j]+1)%2;
				}
			}
			else {
				int temp = 1;
				arr[num-1]=(arr[num-1]+1)%2;
				while(num-1-temp>=0 && num-1+temp<N) {
					if(arr[num-1-temp]==arr[num-1+temp]) {
						arr[num-1-temp]=(arr[num-1-temp]+1)%2;
						arr[num-1+temp]=(arr[num-1+temp]+1)%2;
					}
					else {
						break;
					}
					temp++;
				}
			}
			
		}
		for(int i=0;i<N;i++) {
			System.out.print(arr[i]+" ");
			if((i+1)%20==0) {
				System.out.println();
			}
		}
		
		
		
	}

}
