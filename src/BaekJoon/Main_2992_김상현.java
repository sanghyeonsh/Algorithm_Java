package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main_2992_김상현 {

	static int len,min;
	static String start;
	static char[] arr,current;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		start = br.readLine();
		arr = start.toCharArray();
		len = start.length();
		visited = new boolean[len];
		min = 1000000;
		current = new char[len];
		perm(0);
		if(min<1000000) {
			System.out.println(min);
		}else {
			System.out.println(0);
		}
	}
	private static void perm(int depth) {
		if(depth == len) {
			int temp = Integer.parseInt(String.valueOf(current));
			if(temp>Integer.parseInt(start) && temp<min) {
				min = temp;
			}
			return;
		}
		for(int i=0;i<len;i++) {
			if(visited[i]) continue;
			visited[i] = true;
			current[depth] = arr[i];
//			System.out.print("i"+i+" : ");
//			System.out.println(current);
			perm(depth+1);
			visited[i] = false;
		}
	}
}
