package Tree;

public class CompleteBinaryTreeTest {

	public static void main(String[] args) {
		
		int size = 9;
		CompleteBinaryTree tree = new CompleteBinaryTree(9);
		for(int i=0;i<size;i++) {
			tree.add((char)(65+i)); //A,B,C,D...
		}
		tree.bfs();
		
		tree.dfsByPreOrder();
		tree.dfsByInOrder();
		tree.dfsByPostOrder();
	}
}
