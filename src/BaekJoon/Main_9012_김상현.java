package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			String str = br.readLine();
			Stack<Character> stack = new Stack<>();
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') {
					stack.push('(');
				}
				else if(str.charAt(0)==')') {
					stack.push('e');
					break;
				}
				else {
					if(!stack.isEmpty()) {
						stack.pop();
					}
					else {
						stack.push('e');
						break;
					}
				}
			}
			if(stack.isEmpty()) {
				System.out.println("YES");
			}
			else {
				System.out.println("NO");
			}
		}
		
		
	}

}
