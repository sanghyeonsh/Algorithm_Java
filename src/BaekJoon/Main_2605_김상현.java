package BaekJoon;
// 다시 보기
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2605_김상현 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> arr = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		arr.add(-1);
		for(int i=1;i<=N;i++) {
			int num = Integer.parseInt(st.nextToken());
			arr.add(i-num,i);
		}
		for(int i=1;i<=N;i++) {
			System.out.print(arr.get(i)+" ");
		}
		
		
	}

}
