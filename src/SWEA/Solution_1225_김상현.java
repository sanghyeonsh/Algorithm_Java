package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_1225_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int n = sc.nextInt();
			Queue<Integer> queue = new LinkedList<Integer>();
			for(int j=0;j<8;j++) {
				queue.offer(sc.nextInt());
			}
			while(true) {
				if(queue.peek()-1<=0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll()-1);
				if(queue.peek()-2<=0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll()-2);
				if(queue.peek()-3<=0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll()-3);
				if(queue.peek()-4<=0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll()-4);
				if(queue.peek()-5<=0) {
					queue.poll();
					queue.offer(0);
					break;
				}
				queue.offer(queue.poll()-5);
				
			}
			System.out.print("#"+i+" ");
			for(int j=0;j<8;j++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}
}
