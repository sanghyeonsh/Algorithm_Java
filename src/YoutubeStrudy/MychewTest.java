package YoutubeStrudy;
import java.util.LinkedList;
import java.util.Queue;

public class MychewTest {

	public static void main(String[] args) {
		
		int N = 20;
		int person=1;
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.offer(new int[] {person,1});
		int[] p;
		int availableCnt=0;
		while(N>0){
			if(!queue.isEmpty()) {
				p= queue.poll();
				availableCnt = (N>=p[1])? p[1]: N;
				N -= availableCnt;
				if(N ==0) {
					System.out.println("마지막 마이쭈를 가져간 사원 "+p[0]+" 가져간 개수 : "+availableCnt);
				}else {
					System.out.println(p[0]+"번이 "+availableCnt+"개수만큼 가져갑니다. 남은 수 : "+N);
					p[1]++; //  받을 마이쮸 개수 하나 증가
					queue.offer(p);// 자기 다시 줄 세우기
					queue.offer(new int[]{++person,1}); // 다음번호 사람 줄 세우기
				}
			}
		}

		
	}

}
