package BaekJoon;
//다시
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1920_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean flag = true;
		for(int i=0;i<M;i++) {
			int num = Integer.parseInt(st.nextToken());
			for(int j=0;j<N;j++) {
				flag = true;
				if(num==arr[j]) {
					System.out.println(1);
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(0);
			}
		}

		
		
	}

}
