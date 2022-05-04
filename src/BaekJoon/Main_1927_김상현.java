package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_1927_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			if(num==0) {
				if(pQueue.isEmpty()) System.out.println(0);
				else System.out.println(pQueue.poll());
			}
			else {
				pQueue.add(num);
			}
		}

	}

}
