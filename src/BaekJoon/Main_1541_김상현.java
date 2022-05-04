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
		List<Integer> arr = new ArrayList<>();
		int max = 0;
		int start = 0;
		int end = 0;
		boolean flag = false;
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='-') {
				arr.add(i);
				flag = false;
			}
			else if(str.charAt(i)=='+') {
				flag = true;
			}
		}
		if(flag) arr.add(str.length());
		for(int i=0;i<arr.size()-1;i++) {
			int temp = 0;
			int total = 0;
			for(int j=arr.get(i)+1;j<arr.get(i+1);j++) {
				if(str.charAt(j)=='+') {
					total += temp;
					temp = 0;
				}
				else {
					if(temp==0) temp = str.charAt(j)-'0';
					else {
						temp*=10;
						temp+=str.charAt(j)-'0';
					}
					
				}
			}
			total += temp;
			if(total>max) {
				max = total;
				start = arr.get(i)+1;
				end = arr.get(i+1)-1;
			}
		}
		int ans = 0;
		boolean check = true;
		int temp = 0;
		for(int i=0;i<str.length();i++) {
			if(i==start && max!=0) {
				ans-=max;
				i = end+1;
				continue;
			}
			if(temp==0 && str.charAt(i)!='+' && str.charAt(i)!='-') {
				temp+=str.charAt(i)-'0';
			}
			else if(temp!=0 && str.charAt(i)!='+' && str.charAt(i)!='-') {
				temp*=10;
				temp+=str.charAt(i)-'0';
			}
			if(str.charAt(i)=='+') {
				if(check) {
					ans += temp;
				}
				else {
					ans -= temp;
				}
				check = true;
				temp = 0;
			}
			if(str.charAt(i)=='-') {
				if(check) {
					ans += temp;
				}
				else {
					ans -= temp;
				}
				check = false;
				temp = 0;
			}
		}
		if(check) {
			ans+=temp;
		}
		else {
			ans-=temp;
		}
		System.out.println(ans);
		
	}

}
