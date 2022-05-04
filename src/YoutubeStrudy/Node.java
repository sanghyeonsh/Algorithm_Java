package YoutubeStrudy;

public class Node {
	public String data;
	public Node link;
	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}
	public Node(String data) {
		super();
		this.data = data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", link=" + link + "]";
	}
	

}
