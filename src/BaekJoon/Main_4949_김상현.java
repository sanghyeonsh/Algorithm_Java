package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_4949_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while(!str.equals(".")) {
			Stack<Character> stack = new Stack<>();
			for(int i=0;i<str.length();i++) {
				if(str.charAt(i)=='(') {
					stack.push('(');
				}
				else if(str.charAt(i)=='[') {
					stack.push('[');
				}
				else if(str.charAt(i)==')') {
					if(stack.isEmpty()) {
						stack.push('1');
						break;
					}
					else if(stack.peek()=='(') {
						stack.pop();
					}
					else {
						break;
					}
				}
				else if(str.charAt(i)==']') {
					if(stack.isEmpty()) {
						stack.push('1');
						break;
					}
					else if(stack.peek()=='[') {
						stack.pop();
					}
					else {
						break;
					}
				}
			}
			if(stack.isEmpty()) System.out.println("yes");
			else System.out.println("no");
			str = br.readLine();
		}
		
		
	}

}
