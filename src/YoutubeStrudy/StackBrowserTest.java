package YoutubeStrudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackBrowserTest {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> backward = new Stack<String>();
		Stack<String> forward = new Stack<String>();
		
		String current = "http://www.ssafy.com";
		
		while(true) {
			
			String input = br.readLine();
			if(input.charAt(0)=='Q') break;
			
			StringTokenizer st = new StringTokenizer(input);
			
			switch (st.nextToken()) {
			case "V":
				backward.push(current);
				forward.clear();
				current = st.nextToken();
				break;
			case "B":
				if(backward.isEmpty()) {
					System.out.println("Ignored..");
					continue;
				}
				forward.push(current);
				current = backward.pop();
				break;
			case "F":
				if(forward.isEmpty()) {
					System.out.println("Ignored..");
					continue;
				}
				backward.push(current);
				//backward.add(current)도 가능
				//add는 List메서드, push는 stack메서드 stack을 사용하는걸 명확하게 알려면 push사용
				current = forward.pop();
				break;
			}
			System.out.println(current);
			
		}
		
		
	}

}
