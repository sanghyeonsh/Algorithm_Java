package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_2112_김상현 {

	static int D,W,K,film[][],min;
	static final int A=0,B=1;
	static int[] drugA, drugB;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			drugA = new int[W];
			drugB = new int[W];
			min = K;
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			Arrays.fill(drugA, A);
			Arrays.fill(drugB, B);
			process(0,0);
			System.out.println("#"+tc+" "+min);
			
		}
		
	}
	
	private static boolean check() {
		//열 고정 행 탐색 연속된 셀에 같은 특성이 K개 이상인지 검사
		for(int c=0;c<W;c++) {
			int count = 1;
			int before = film[0][c];
			for(int r=1;r<D;r++) {
				int current = film[r][c];
				if(before == current) {
					if(++count == K) break;
				}else {
					before = current;
					count = 1;
				}
			}//하나의 열을 고정해서 수직 검사
			if(count<K) return false;
		}
		return true;
		
	}
	
	private static boolean process(int row,int useCnt) {
		
		if(row==D){
			if(check()) {
				min = Math.min(min, useCnt);
				return min==0;
			}
			return false;
		}
		if(useCnt>=min) return false; //기존 임시최적해의 최소 약물수보다 현재까지 사용한 약물수가 같거나 크면 의미X
		
		int[] backup = film[row];
		if(process(row+1,useCnt)) return true;
		film[row] = drugA;
		process(row+1,useCnt+1);
		film[row] = drugB;
		process(row+1,useCnt+1);
		film[row] = backup;
		return false;
	}

}
