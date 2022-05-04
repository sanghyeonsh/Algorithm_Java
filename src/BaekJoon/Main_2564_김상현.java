package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2564_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int garo = Integer.parseInt(st.nextToken());
		int sero = Integer.parseInt(st.nextToken());
		int sum = 0;
		int N = Integer.parseInt(br.readLine());
		int[] arrx = new int[N];
		int[] arry = new int[N];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arrx[i]=Integer.parseInt(st.nextToken());
			arry[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++) {
			if(x==1) {
				if(arrx[i]==1) {
					sum+=Math.abs(y-arry[i]);
				}
				else if(arrx[i]==2) {
					sum+=sero+Math.min(y+arry[i], 2*garo-y-arry[i]);
				}
				else if(arrx[i]==3) {
					sum+=arry[i]+y;
				}
				else if(arrx[i]==4) {
					sum+=arry[i]+garo-y;
				}
			}
			else if(x==2) {
				if(arrx[i]==1) {
					sum+=sero+Math.min(y+arry[i], 2*garo-y-arry[i]);
				}
				else if(arrx[i]==2) {
					sum+=Math.abs(y-arry[i]);
				}
				else if(arrx[i]==3) {
					sum+=sero-arry[i]+y;
				}
				else if(arrx[i]==4) {
					sum+=sero-arry[i]+garo-y;
				}
			}
			else if(x==3) {
				if(arrx[i]==1) {
					sum+=y+arry[i];
				}
				else if(arrx[i]==2) {
					sum+=sero-y+arry[i];
				}
				else if(arrx[i]==3) {
					sum+=Math.abs(y-arry[i]);
				}
				else if(arrx[i]==4) {
					sum+=garo+Math.min(y+arry[i], 2*sero-y-arry[i]);
				}
			}
			else if(x==4) {
				if(arrx[i]==1) {
					sum+=y+garo-arry[i];
				}
				else if(arrx[i]==2) {
					sum+=garo-arry[i]+sero-y;
				}
				else if(arrx[i]==3) {
					sum+=garo+Math.min(y+arry[i], 2*sero-y-arry[i]);
				}
				else if(arrx[i]==4) {
					sum+=Math.abs(y-arry[i]);
				}
			}

		}
		System.out.println(sum);
	}

}
