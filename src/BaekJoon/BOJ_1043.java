package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class BOJ_1043 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num_people = Integer.parseInt(st.nextToken());
		int num_party = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int num_know = Integer.parseInt(st.nextToken());
		boolean [] know = new boolean[num_people];
		String [][] input = new String[num_party][];
		int count=0;

		
		if(0 < num_know) {
			for(int i=0; i<num_know; i++) {
				know[Integer.parseInt(st.nextToken())-1] = true;
			}
		}
		
		//party의 횟수 만큼 input 배열에 넣음
		for(int i=0; i<num_party; i++) {
			input[i] = br.readLine().split(" ");
		}
		// input의 길이는 num_party
		for(int i=0; i<num_party; i++) {
			boolean know_flag = false;
			int temp = 0;
					
			//i번째 파티에서 진실을 아는 사람이 있는지 확인
			//input[i][k]는 파티 참석하는 사람 숫자이므로 제외
			for(int k=1; k<input[i].length;k++) {
				temp = Integer.parseInt(input[i][k]) -1;
				if(know[temp] == true) {
					know_flag = true;
					break;
				}
			}
			
			//만약 아는 사람이 있다면 그 파티의 모든 참석자가 진실을 아는 것과 마찬가지임.
			if(know_flag) {
				for(int k=1; k<input[i].length;k++) {
					know[Integer.parseInt(input[i][k]) -1] = true;
				}
			}
		}

		for(int i=0; i<num_party; i++) {
			boolean know_flag = false;
			for(int k=1; k<input[i].length;k++) {
				if(know[Integer.parseInt(input[i][k]) -1] == true) {
					know_flag = true;
					break;
				}
			}
			if(!know_flag)	count++;
		}
		System.out.println(count);
	}
}
