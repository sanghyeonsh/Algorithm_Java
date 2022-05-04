package SWEA;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_3499_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=1;i<=T;i++) {
			int N = sc.nextInt();
			LinkedList<String> arr = new LinkedList<String>();
			for(int j=0;j<N;j++) {
				arr.add(sc.next());
			}
			for(int j=N/2;j>=1;j--) {
				arr.add(j,arr.pollLast());
			}
			System.out.print("#"+i+" ");
			for(int j=0;j<N;j++) {
				System.out.print(arr.get(j)+" ");
			}
			System.out.println();
			
//			Queue<String> queue1 = new LinkedList<String>();
//			Queue<String> queue2 = new LinkedList<String>();
//			int leftnum = N%2==1? N/2+1 : N/2;
//			int rightnum = N/2;
//			for(int j=1;j<=leftnum;j++) {
//				queue1.add(sc.next());
//			}
//			for(int j=1;j<=rightnum;j++) {
//				queue2.add(sc.next());
//			}
//			System.out.print("#"+i+" ");
//			while(true) {
//				System.out.print(queue1.poll()+" ");
//				if(queue1.isEmpty()&&queue2.isEmpty()) {
//					System.out.println();
//					break;
//				}
//				System.out.print(queue2.poll()+" ");
//				if(queue1.isEmpty()) {
//					System.out.println();
//					break;
//				}
//			}
			
			
		}
	}
}

