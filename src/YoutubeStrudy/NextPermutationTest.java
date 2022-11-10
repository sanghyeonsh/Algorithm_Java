package YoutubeStrudy;
import java.util.Arrays;
import java.util.Scanner;

public class NextPermutationTest {

	static int N, input[];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for(int i=0;i<N;i++) {
			input[i] = sc.nextInt();
		}
		//1.오름차순 정렬
		Arrays.sort(input);
		do {
			//순열 출력
			System.out.println(Arrays.toString(input));
		}while(np());
		
	}

	private static boolean np() {	
		//1.교환 위치 찾기
		int i = N-1;
		while( i>0 && input[i-1]>=input[i]) --i;
		
		if(i==0) return false;
		
		//2.교환위치에 교환할 값 찾기
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		//3.교환위치와 교환할 값 교환하기
		swap(i-1,j);
		//4.교환위치 탑(꼭대기)부터 맨 뒤까지 만들 수 있는 가장 작은 순열 생성(오름차순 정렬)
		int k = N-1;
		while(i<k) {
			swap(i++,k--);
		}	
		return true;
	}
	public static void swap(int i,int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
}
