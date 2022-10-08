package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_20413_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Map<Character,Integer> cost = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		cost.put('B', Integer.parseInt(st.nextToken())-1);
		cost.put('S', Integer.parseInt(st.nextToken())-1);
		cost.put('G', Integer.parseInt(st.nextToken())-1);
		int max = Integer.parseInt(st.nextToken());
		cost.put('P', max-1);
		cost.put('D', max);
		int[] arr = new int[N+1];
		arr[0] = 0;
		String str = br.readLine();
		int ans = 0;
		for(int i=0;i<N;i++) {
			if(str.charAt(i)=='D') arr[i+1] = max;
			else arr[i+1] = cost.get(str.charAt(i)) - arr[i];
			ans += arr[i+1];
		}
		System.out.println(ans);
		
	}

}
