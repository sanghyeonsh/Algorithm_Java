package JungOl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2577_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = 0;
		int cur = 0;
		int[] cnt = new int[d+1];
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		//처음 k개 넣어줌
		for(int i=0;i<k;i++) {
			cnt[arr[i]]++;
			if(cnt[arr[i]]==1) cur++;
		}
		max = cur;
		for(int i=1;i<N;i++) {
			//같거나 크면 보너스 확인
			if(cur>=max) {
				if(cnt[c]==0) max = cur+1;
				else max = cur;
			}
			//앞에서 빼고 뒤에꺼 더해줌  단,빼줄 때 cur변환
			cnt[arr[i-1]]--;
			if(cnt[arr[i-1]]==0) cur--;
			cnt[arr[(i-1+k)%N]]++;
			if(cnt[arr[(i-1+k)%N]]==1) cur++;
		}
		System.out.println(max);
	}

}
