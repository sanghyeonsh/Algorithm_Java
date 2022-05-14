package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_1541_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int sum = 0;
		String temp = "";
		boolean flag = false;
		for(int i=0;i<str.length();i++) {
			if(flag) {
				if(str.charAt(i)=='-' || str.charAt(i)=='+') {
					sum-=Integer.parseInt(temp);
					temp="";
				}
				else {
					temp+=str.charAt(i);
				}
			}
			else {
				if(str.charAt(i)=='-') {
					flag = true;
					sum+=Integer.parseInt(temp);
					temp="";
				}
				else if(str.charAt(i)=='+') {
					sum+=Integer.parseInt(temp);
					temp="";
				}
				else {
					temp+=str.charAt(i);
				}
			}
		}
		if(flag) sum-=Integer.parseInt(temp);
		else sum+=Integer.parseInt(temp);
		System.out.println(sum);
	}

}
