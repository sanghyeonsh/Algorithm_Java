package SWEA;
//다시
import java.util.Scanner;

public class Solution_1215_김상현 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		for(int i=1;i<=10;i++) {
			int len = sc.nextInt();
			int check = 0;
			char[][] arr = new char[8][8];
			for(int j=0;j<8;j++) {
				String str = sc.next();
				for(int k=0;k<8;k++) {
					arr[j][k]=str.charAt(k);
				}
			}
			for(int j=0;j<8;j++) {
				int k = 0;
				check = 0;
				boolean flag = true;
				while(k<8-len) {
					for(int minus=0;minus<len/2;minus++) {
						if(arr[j][k+minus]!=arr[j][k+len-1-minus]) {
							flag = false;
							break;
						}
						flag = true;
					}
					if(flag==true) {
						check++;
					}
					k++;
				}
			}
			System.out.println(check);
			
		}
		

	}

}
