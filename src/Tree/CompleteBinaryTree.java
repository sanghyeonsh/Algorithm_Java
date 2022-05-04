package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {

	private char[] nodes;
	private int SIZE;
	private int lastIndex;
	
	public CompleteBinaryTree(int size) {
		nodes = new char[size+1];
		SIZE = size;
		
		
	}
	public boolean isEmpty() {
		return lastIndex==0;
	}
	public boolean isFull() {
		return lastIndex==SIZE;
	}
	public void add(char e) {
		if(isFull()) return;
		nodes[++lastIndex] = e;
	}
	public void bfs() {
		
		if(isEmpty()) return;
		//이진트리의 탐색 순서 관리
		Queue<Integer> queue = new LinkedList<>();
		//루트가 가장 먼저 탐색되도록 queue에 넣기
		queue.offer(1);
		int level = 0;
		while(!queue.isEmpty()) {
//			int current = queue.poll(); //탐색 순서에 맞는 인덱스
//			
//			System.out.println(nodes[current]);
//			
//			//현재 노트의 자식노드들의 인덱스를 다음에 순서가 되었을 때 탐색되도록 큐에 넣어준다.
//			//왼쪽 자식노드
//			if(current*2<=lastIndex) queue.offer(current*2);
//			//오른쪽 자식노드
//			if(current*2+1<=lastIndex) queue.offer(current*2+1);
			
			
			System.out.print("level "+level+" : ");
			//같은 너비의 노드를 모두 탐색, 같은 행에 출력
			int size = queue.size();
			while(--size>=0) {
				int current = queue.poll();
				System.out.print(nodes[current]+"\t");
				//왼쪽 자식노드
				if(current*2<=lastIndex) queue.offer(current*2);
				//오른쪽 자식노드
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
				
			}
			System.out.println();
			++level;
			
		}
		
	}
	public void dfsByPreOrder() {
		System.out.println("dfsByPreOrder");
		dfsByPreOrder(1);
		System.out.println();
	}
	
	private void dfsByPreOrder(int current) {
		if(current>lastIndex) return; 
		//현재노드 방문
		//현재노드의 자식노드들 방문		
		System.out.print(nodes[current]+" ");
		dfsByPreOrder(current*2);
		dfsByPreOrder(current*2+1);
	}
	public void dfsByInOrder() {
		System.out.println("dfsByInOrder");
		dfsByInOrder(1);
		System.out.println();
	}
		
	private void dfsByInOrder(int current) {
		if(current>lastIndex) return; 
		//현재노드 방문
		dfsByInOrder(current*2);
		System.out.print(nodes[current]+" ");
		//현재노드의 자식노드들 방문		
		dfsByInOrder(current*2+1);
	}
	
	
	public void dfsByPostOrder() {
		System.out.println("dfsByPostOrder");
		dfsByPostOrder(1);
		System.out.println();
		
	}

	private void dfsByPostOrder(int current) {
		if(current>lastIndex) return; 
		//현재노드 방문
		dfsByPostOrder(current*2);
		dfsByPostOrder(current*2+1);
		//현재노드의 자식노드들 방문		
		System.out.print(nodes[current]+" ");
	}
	
	
	
	
	
}
