package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution_1218_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=1;i<=10;i++) {
			boolean flag = true;
			int n = Integer.parseInt(br.readLine());
			String str = br.readLine();
			Stack<Character> s = new Stack<Character>();
			for(int j=0;j<str.length();j++) {
				char temp = str.charAt(j);
				if(temp=='('||temp=='['||temp=='{'||temp=='<') {
					s.push(temp);
				}
				else if(temp==')') {
					if(s.isEmpty()||s.pop()!='(') {
						flag = false;
						break;
					}
				}
				else if(temp==']') {
					if(s.isEmpty()||s.pop()!='[') {
						flag = false;
						break;
					}
				}
				if(temp=='}') {
					if(s.isEmpty()||s.pop()!='{') {
						flag = false;
						break;
					}
				}
				if(temp=='>') {
					if(s.isEmpty()||s.pop()!='<') {
						flag = false;
						break;
					}
				}
			}
			if(!s.isEmpty()) {
				flag=false;
			}
			if(flag) System.out.println("#"+i+" "+1);
			else System.out.println("#"+i+" "+0);
		}
	}
}

