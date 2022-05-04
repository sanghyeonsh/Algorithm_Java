package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main_1620_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> nameMap = new HashMap<String, Integer>();
		String[] arr = new String[N+1];
		for(int i=1;i<=N;i++) {
			String name = br.readLine();
			nameMap.put(name, i);
			arr[i] = name;
		}
		for(int i=1;i<=M;i++) {
			String find = br.readLine();
			if(find.charAt(0)>='0' && find.charAt(0)<='9') {
				System.out.println(arr[Integer.parseInt(find)]);
			}
			else {
				System.out.println(nameMap.get(find));
			}
		}
	}

}
