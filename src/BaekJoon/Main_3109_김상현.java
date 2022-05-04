package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_김상현 {

	static char[][] map;
	static int R,C;
	static int cnt;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
		}
		solve(0);
		System.out.println(cnt);

		
	}
	
	
	static void solve(int r) {
		if(r==R-1) {
			return;
		}
		if(isAvailable(r,0)) {
			cnt++;
		}
		solve(r+1);
	}
	
	
	
	static boolean isAvailable(int r, int c) {
		//들리는 곳마다 표시
		//1.성공한 경우: 여기에 파이프를 설치했으니 지나가지 마라
		//2.실패한 경우: 여기에서도 갈 길이 없으니 돌아가라
		map[r][c]='x';
		//오른쪽 끝까지 도달
		if(c==C-1) {
			return true;
		}
		if(r>0 && map[r-1][c+1]=='.') {
			if(isAvailable(r-1,c+1)) {
				return true;
			}
		}
		if(map[r][c+1]=='.') {
			if(isAvailable(r,c+1)) {
				return true;
			}
		}
		if(r<R-1 && map[r+1][c+1]=='.') {
			if(isAvailable(r+1,c+1)) {
				return true;
			}
		}
		return false;
	}
	
	

}
