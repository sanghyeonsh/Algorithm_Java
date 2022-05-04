package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_10828_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Stack<Integer> stack = new Stack<>(); 
		int T = Integer.parseInt(br.readLine());
		for(int t=0;t<T;t++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			}
			else if(str.equals("pop")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.pop());
				}
			}
			else if(str.equals("size")) {
				System.out.println(stack.size());
			}
			else if(str.equals("empty")) {
				if(stack.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}
			else if(str.equals("top")) {
				if(stack.isEmpty()) {
					System.out.println(-1);
				}
				else {
					System.out.println(stack.peek());
				}
			}
		}
	}

}
