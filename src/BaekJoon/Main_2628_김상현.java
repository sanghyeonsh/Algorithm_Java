package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_2628_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> arrx = new LinkedList<>();
		LinkedList<Integer> arry = new LinkedList<>();
		arrx.add(Integer.parseInt(st.nextToken()));
		arry.add(Integer.parseInt(st.nextToken()));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int check = Integer.parseInt(st.nextToken());
			int cut = Integer.parseInt(st.nextToken());
			if(check==1) {
				int idx;
				for(idx=0;cut-arrx.get(idx)>0 ;idx++ ) {
					cut -= arrx.get(idx);
				}
				int temp = arrx.remove(idx);
				arrx.add(idx,temp-cut);
				arrx.add(idx,cut);
			}
			else {
				int idx;
				for(idx=0;cut-arry.get(idx)>0 ;idx++ ) {
					cut -= arry.get(idx);
				}
				int temp = arry.remove(idx);
				arry.add(idx,temp-cut);
				arry.add(idx,cut);
			}
			
		}
		int max = 0;
		for(int x:arrx) {
			for(int y:arry) {
				max = Math.max(x*y,max);
			}
		}
		System.out.println(max);
	}

}
