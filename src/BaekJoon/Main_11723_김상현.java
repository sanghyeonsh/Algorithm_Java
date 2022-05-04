package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_11723_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int M = Integer.parseInt(br.readLine());
		HashSet hs = new HashSet();
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			if(str.equals("empty")) {
				hs.clear();
			}
			else if(str.equals("all")){
				for(int j=1;j<=20;j++) {
					hs.add(j);
				}
			}
			else if(str.equals("add")) {
				int num = Integer.parseInt(st.nextToken());
				hs.add(num);
			}
			else if(str.equals("remove")) {
				int num = Integer.parseInt(st.nextToken());
				
			}
		}
		
		
	}

}
