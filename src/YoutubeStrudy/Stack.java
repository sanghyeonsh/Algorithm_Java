package YoutubeStrudy;

public class Stack {

		
	private Node top;
	
	public void push(String data) {
		//첫번째 노드(top)로 삽입
		top = new Node(data,top);
	}
	public String pop() {
		if(isEmpty()) return null;
		//첫번째 노드(top) 삭제
		Node popNode = top;
		top = popNode.link;
		
		popNode.link = null;
		return popNode.data;
	}
	public boolean isEmpty() {
		return top==null;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(Node currNode=top;currNode!=null;currNode=currNode.link) {
			sb.append(currNode.data).append(",");
		}
		if(!isEmpty()) sb.setLength(sb.length()-1);
		sb.append("]");
		return sb.toString();
	}
	
	
		

}
