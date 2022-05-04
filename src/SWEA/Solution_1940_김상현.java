package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1940_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			int speed = 0;
			int d = 0;
			int N = Integer.parseInt(br.readLine());
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				if(a!=0) {
					int b = Integer.parseInt(st.nextToken());
					if(a==1) {
						speed+=b;
						d+=speed;
					}
					else if(a==2) {
						speed-=b;
						speed=Math.max(0, speed);
						d+=speed;
					}
				}
				else if(a==0){
					d+=speed;
				}
			}
			System.out.println("#"+i+" "+d);
		}

	}

}
