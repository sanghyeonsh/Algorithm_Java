package YoutubeStrudy;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		
		PriorityQueue<Integer> minQueue = new PriorityQueue<Integer>();
		//최소힙으로 동작
		PriorityQueue<Integer> maxQueue = new PriorityQueue<Integer>(Collections.reverseOrder());
		//최대힙으로 동착
		
		minQueue.offer(10);
		minQueue.offer(50);
		minQueue.offer(5);
		minQueue.offer(20);
		minQueue.offer(30);
		
		maxQueue.offer(10);
		maxQueue.offer(50);
		maxQueue.offer(5);
		maxQueue.offer(20);
		maxQueue.offer(30);

		
		System.out.println(minQueue.poll());
		System.out.println(minQueue.poll());
		System.out.println(minQueue.poll());
		System.out.println(minQueue.poll());
		System.out.println(minQueue.poll());
		System.out.println(maxQueue.poll());
		System.out.println(maxQueue.poll());
		System.out.println(maxQueue.poll());
		System.out.println(maxQueue.poll());
		System.out.println(maxQueue.poll());
		
		
		PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(Comparator.reverseOrder());
		pQueue.offer(1);
		pQueue.offer(2);
		pQueue.offer(3);
		pQueue.offer(4);
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		
		
		
		
	}

}
