package BaekJoon;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main_4358_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Map<String,Integer> map = new HashMap<>();
		while(sc.hasNextLine()) {
			String str = sc.nextLine();
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		Set<String> keySet = map.keySet();
		keySet.stream().sorted();
		int sum = 0;
		for(String str:keySet) {
			sum += map.get(str);
		}
		for(String str:keySet) {
			System.out.println(str+" "+Math.round(map.get(str)/sum));
		}
		
		
	}

}
