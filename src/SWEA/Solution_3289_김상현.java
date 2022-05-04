package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] arr = new int[n+1];
			for(int i=1;i<=n;i++) {
				arr[i]=i;
			}
			System.out.print("#"+tc+" ");
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int check = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(check==1) {
					if(find(arr,a,b)) System.out.print(1);
					else System.out.print(0);
				}
				else {
					union(arr,a,b);
				}
			}
			System.out.println();
		}
		
	}

	private static int findSet(int[] arr, int a) {
		if(a==arr[a]) return a;
		else return arr[a] = findSet(arr,arr[a]);
		
	}
		
	
	private static void union(int[] arr, int a, int b) {
		a = findSet(arr,a);
		b = findSet(arr,b);
		if(a>b) arr[a]=b;
		else arr[b]=a;
	}

	private static boolean find(int[] arr, int a, int b) {
		return (findSet(arr,a)==findSet(arr,b));
		
	}

}
