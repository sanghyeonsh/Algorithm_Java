package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main_1764_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> arr = new HashSet<>();
		ArrayList<String> ans = new ArrayList<>();
		for(int i=0;i<N;i++) {
			arr.add(br.readLine());
		}
		for(int i=0;i<M;i++) {
			String temp = br.readLine();
			if(arr.contains(temp)) {
				ans.add(temp);
			}
		}
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int i=0;i<ans.size();i++) {
			System.out.println(ans.get(i));
		}
	}

}
