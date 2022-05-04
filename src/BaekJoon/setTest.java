package BaekJoon;

import java.util.HashSet;

public class setTest {

	public static void main(String[] args) {
		
		HashSet<int[]> hs = new HashSet<>();
		hs.add(new int[] {1,2});
		hs.add(new int[] {1,2});
		System.out.println(hs.size());
		
	}

}
