package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_8911_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());		
		for(int tc=0;tc<T;tc++) {
			int curD = 0;
			int topX = 0;
			int topY = 0;
			int botX = 0;
			int botY = 0;
			int curX = 0;
			int curY = 0;
			String str = br.readLine();
			for(int i=0;i<str.length();i++) {
				curD+=4;
				char temp = str.charAt(i);
				if(temp=='F') {
					if(curD%4==0) {
						curY+=1;
					}
					else if(curD%4==1) {
						curX+=1;
					}
					else if(curD%4==2) {
						curY-=1;
					}
					else {
						curX-=1;
					}
				}
				else if(temp=='B') {
					if(curD%4==0) {
						curY-=1;
					}
					else if(curD%4==1) {
						curX-=1;
					}
					else if(curD%4==2) {
						curY+=1;
					}
					else {
						curX+=1;
					}
				}
				else if(temp=='L') {
					curD-=1;
				}
				else if(temp=='R') {
					curD+=1;
				}
				topX = Math.max(curX, topX);
				topY = Math.max(curY, topY);
				botX = Math.min(curX, botX);
				botY = Math.min(curY, botY);
				
			}
			System.out.println((topX-botX)*(topY-botY));
		}
		
		
	}

}
