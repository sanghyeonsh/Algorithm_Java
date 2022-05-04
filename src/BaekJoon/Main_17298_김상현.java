package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_17298_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int[] arr = new int[T];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<T;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<T;i++) {
			while(!stack.isEmpty() && arr[stack.peek()]<	arr[i]) {
				arr[stack.pop()]=arr[i];
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) {
			arr[stack.pop()]=-1;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<T;i++) {
			sb.append(arr[i]).append(" ");
		}
		System.out.println(sb);
		
		
		
		
		
	}

}
