package YoutubeStrudy;
import java.util.Scanner;

public class SubsetTest {

	static int N, input[];
	static boolean[] isSelected;
	static int totalCnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		for(int i=0;i<N;i++) {
			input[i]=sc.nextInt();
		}
		generateSubset(0);
		System.out.println("부분집합의 개수 : "+totalCnt);
	}
	
	public static void generateSubset(int cnt) {//부분집합에 고려해야 하는 원소, 직전까지 고려한 원소 수
		
		if(cnt==N) {//마지막 원소까지 부분집합에 다 고려한 상황
			totalCnt++;
			for(int i=0;i<N;i++) {
				System.out.print((isSelected[i]?input[i]:"X")+" ");
			}
			System.out.println();
			
			return;
		}
		
		//현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt+1);
		//현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt+1);
		
		
		
	}

}
