package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_5432_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			Stack<Character> stack = new Stack<Character>();
			String str = br.readLine();
			char[] arr = new char[str.length()];
			int sum = 0;
			for(int j=0;j<str.length();j++) {
				arr[j]=str.charAt(j);
			}
			for(int j=0;j<arr.length;j++) {
				if(arr[j]=='(') {
					stack.push(arr[j]);
				}
				else if(arr[j]==')' && arr[j-1]=='(') {
					stack.pop();
					sum+=stack.size();
				}
				else if(arr[j]==')' && arr[j-1]==')') {
					stack.pop();
					sum+=1;
				}
			}
			System.out.println("#"+i+" "+sum);
		}
	}
}

