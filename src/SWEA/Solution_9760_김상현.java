package SWEA;

import java.util.Scanner;

public class Solution_9760_김상현 {

	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);

	    int T;
	    T = sc.nextInt();

	    for (int test_case = 1; test_case <= T; test_case++) {
	        int num[] = new int[14];
	        // 0 - S, 1 - D, 2 - H, 3 - C
	        boolean flush = true;

	        char temp = 'X';

	        for (int i = 0; i < 5; i++) {
	            String st = sc.next();
	            char p = st.charAt(0);

	            if (temp != p && temp != 'X') {
	                flush = false;
	            }

	            temp = p;

	            int n = st.charAt(1) - '0';

	            if (n == 'A' - '0') {
	                num[0] += 1;
	                num[13] += 1;
	            } else if (n >= 2 && n < 10) {
	                num[n - 1] += 1;
	            } else if (n == 'T' - '0') {
	                num[9] += 1;
	            } else if (n == 'J' - '0') {
	                num[10] += 1;
	            } else if (n == 'Q' - '0') {
	                num[11] += 1;
	            } else if (n == 'K' - '0') {
	                num[12] += 1;
	            }

	        }

	        boolean straight = false;
	        for (int i = -1; i < 9; i++) {
	            int cnt = 0;
	            for (int j = i + 1; j <= i + 5; j++) {
	                if (num[j] == 1) {
	                    cnt++;
	                }
	            }
	            if (cnt == 5) {
	                straight = true;
	            }
	        }

	        boolean four = false;
	        boolean three = false;
	        int one = 0;
	        int max = 0;

	        for (int i = 0; i < 13; i++) {
	            if (num[i] == 4) { // 포카드
	                four = true;
	                break;
	            }
	            if (num[i] == 3) { // 트리플
	                three = true;
	            }
	            if (num[i] == 2) { // 원페어
	                one += 1;
	            }
	            if (num[i] == 1) {
	                max = Math.max(max, i);
	            }
	        }

	        if (straight && flush) {
	            System.out.println("#" + test_case + " " + "Straight Flush");
	        } else if (four) {
	            System.out.println("#" + test_case + " " + "Four of a Kind");
	        } else if (straight) {
	            System.out.println("#" + test_case + " " + "Straight");
	        } else if (three && one == 1) {
	            System.out.println("#" + test_case + " " + "Full House");
	        } else if (flush) {
	            System.out.println("#" + test_case + " " + "Flush");
	        } else if (three) {
	            System.out.println("#" + test_case + " " + "Three of a kind");
	        } else if (one == 2) {
	            System.out.println("#" + test_case + " " + "Two pair");
	        } else if (one == 1) {
	            System.out.println("#" + test_case + " " + "One pair");
	        } else {
	            if (max == 0) {
	                System.out.println("#" + test_case + " " + 'A');
	            } else if (max > 0 && max < 9) {
	                System.out.println("#" + test_case + " " + max + 1);
	            } else if (max == 9) {
	                System.out.println("#" + test_case + " " + 'T');
	            } else if (max == 10) {
	                System.out.println("#" + test_case + " " + 'J');
	            } else if (max == 11) {
	                System.out.println("#" + test_case + " " + 'Q');
	            } else if (max == 12) {
	                System.out.println("#" + test_case + " " + 'K');
	            }
	        }

	    }

	}
}
