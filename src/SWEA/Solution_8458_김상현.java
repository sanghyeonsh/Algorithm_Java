package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_8458_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			int max = 0;
			boolean flag = false;
			boolean odd = false;
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int dist = Math.abs(a)+Math.abs(b);
			if(dist%2==0) {
				odd = false;
			}else {
				odd = true;
			}
			max = Math.max(max, dist);
			for(int i=0;i<N-1;i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				dist = Math.abs(a)+Math.abs(b);
				if(odd!=(dist%2==1)) {
					flag = true;
				}
				max = Math.max(max, dist);
			}
			int n = 0;
			int sum = 0;
			while(true) {
				if(flag) {
					System.out.println("#"+tc+" "+ -1);
					break;
				}
				sum += n;
				if(sum>=max && odd==(sum%2==1)) {
					System.out.println("#"+tc+" "+n);
					break;
				}
				n++;
			}
		}
		
		
//		Scanner sc = new Scanner(System.in);
//		StringBuilder sb = new StringBuilder();
//		int tc = sc.nextInt();
//		here: for (int t = 1; t <= tc; t++) {
//			int n = sc.nextInt();
//			int d = 0, pre = 0;
//			for (int i = 0; i < n; i++) {
//				d = Math.abs(sc.nextInt()) + Math.abs(sc.nextInt());
//				if (pre != 0)
//					if ((pre + d) % 2 == 1) { // 홀짝
//						sb.append("#").append(t).append(" -1\n");
//						continue here;
//					}
//				pre = pre < d ? d : pre;
//			}
//			int sum = 0, i = 0;
//			while (sum < pre) {
//				sum += ++i;
//			}
//			if ((sum + pre) % 2 == 1) {
//				while ((sum + pre) % 2 == 1) {
//					sum += ++i;
//				}
//			}
//			sb.append("#").append(t).append(" ").append(i).append("\n");
//		}
//		System.out.println(sb.toString());
		
	}

}
