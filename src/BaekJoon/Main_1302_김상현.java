package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main_1302_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<String,Integer> map = new HashMap<>();
		int max = 0;
		for(int i=0;i<N;i++) {
			String bookName = br.readLine();
			map.put(bookName, map.getOrDefault(bookName, 0)+1);
			max = Math.max(map.get(bookName),max);
		}
		ArrayList<String> arr = new ArrayList<>();
		for(String s:map.keySet()) {
			if(map.get(s)==max) {
				arr.add(s);
			}
		}
		String[] str = new String[arr.size()];
		for(int i=0;i<str.length;i++) {
			str[i] = arr.get(i);
		}
		Arrays.sort(str);
		System.out.println(str[0]);
	}

}
