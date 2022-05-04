package YoutubeStrudy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTest {

	static StringBuilder result = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = Integer.parseInt(br.readLine());
        hanoi(cnt, 1, 2, 3);
        System.out.println(result.toString());
    }// end main
  
    // 원반갯수, 시작기둥, 임시기둥, 끝기둥
    private static void hanoi(int cnt, int from, int temp, int to) {
    	if(cnt==0) return;
    	// 시작기둥에서 맨아래원반 빼고 그위부터 나머지 원반들을 가운데기둥으로 옮기고(시작기둥과 마지막기둥이 아닌기둥이 임시기둥으로 사용됨)
    	hanoi(cnt - 1, from, to, temp); 	
    	result.append(cnt + " : " + from + " -> " + to+"\n");//맨아래원반을 시작기둥에서 끝기둥으로 옮김
    	// 임시기둥에 옮겨진 모든 원반들을 다시 마지막 기둥으로 옮긴다. (시작기둥과 마지막기둥이 아닌기둥이 임시기둥으로 사용됨)
    	hanoi(cnt - 1, temp, from, to); 
    }      

}
