package SWEA;

import java.util.Scanner;
import java.util.Stack;

public class Solution_1223_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int tc=1;tc<=10;tc++) {
			int N = sc.nextInt();
			String str = sc.next();
			Stack<Character> temp = new Stack<Character>();
			Stack<Integer> calc = new Stack<Integer>();
			String trans = "";
			for(int i=0;i<N;i++) {
				if(0<=str.charAt(i)-'0'&&str.charAt(i)-'0'<=9) {
					trans+=str.charAt(i);
				}
				else {
					if(temp.isEmpty()) {
						temp.push(str.charAt(i));						
					}
					else {
						if(str.charAt(i)=='+') {
							while(!temp.isEmpty()) {
								trans+=temp.pop();
							}
							temp.push(str.charAt(i));
						}
						else {
							while(!temp.isEmpty()&&temp.peek()=='*') {
								trans+=temp.pop();
							}
							temp.push(str.charAt(i));
						}
					}
				}
			}
			while(!temp.isEmpty()) {
				trans+=temp.pop();
			}
			for(int j=0;j<trans.length();j++) {
				if(trans.charAt(j)-'0'>=0 && trans.charAt(j)-'0'<=9) {
					calc.push(trans.charAt(j)-'0');
				}
				else {
					int a = calc.pop();
					int b = calc.pop();
					if(trans.charAt(j)=='+') calc.push(a+b);
					else calc.push(a*b);
				}
			}
			System.out.println("#"+tc+" "+calc.pop());
			
			
		}
	}
}
