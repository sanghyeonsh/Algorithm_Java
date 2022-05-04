package YoutubeStrudy;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAPITest {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		System.out.println(queue.size()+"//"+queue.isEmpty());
		queue.offer("김지현");
		queue.offer("김상현");
		queue.offer("김서현");
		System.out.println(queue.size()+"//"+queue.isEmpty());
		
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.peek());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());
		System.out.println(queue.poll());
		System.out.println(queue.size()+"//"+queue.isEmpty());
		System.out.println(queue.poll());


	}

}
