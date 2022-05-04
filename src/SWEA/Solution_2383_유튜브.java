package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_2383_유튜브 {

	static class Person implements Comparable<Person>{
		int r,c,downCnt,status,time;

		public Person(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public void init() {
			time = downCnt = 0;
			status = M;
		}
		@Override
		public int compareTo(Person o) {
			
			return this.time-o.time;
		}
		
	}
	static final int M = 1, W = 2, D=3, C=4; //move, wait, down, count
	static int N,min,cnt;
	static boolean[] selected;
	static ArrayList<Person> pList;
	static int[][] sList;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			N = Integer.parseInt(br.readLine());
			
			pList = new ArrayList<Person>();
			sList = new int[2][];
			min = Integer.MAX_VALUE;
			for(int i=0, k=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					int c = Integer.parseInt(st.nextToken());
					if(c==1) {//사람이면
						pList.add(new Person(i,j));
					}
					else if(c>1) {//계단이면
						sList[k++] = new int[] {i,j,c};
					}
				}
			}
			cnt = pList.size();
			selected = new boolean[cnt];
			divide(0);
			System.out.println("#"+tc+" "+min);
			
			
		}
		
	}

	private static void divide(int index) {
		
		if(index==cnt) {
			makeList();
			return;
		}
		//부분집합에 포함: 계단 1에 배정
		selected[index] = true;
		divide(index+1);
		//부분집합에 비포함: 계단 2에 배정
		selected[index] = false;
		divide(index+1);
		
	}

	private static void makeList() {
		
		ArrayList<Person> aList = new ArrayList<Person>();
		ArrayList<Person> bList = new ArrayList<Person>();
		
		for(int i=0;i<cnt;i++) {
			Person p = pList.get(i);
			p.init();
			if(selected[i]) {
				p.time = Math.abs(p.r-sList[0][0])+Math.abs(p.c-sList[0][1]);
				aList.add(p);
			}
			if(!selected[i]) {
				p.time = Math.abs(p.r-sList[1][0])+Math.abs(p.c-sList[1][1]);
				bList.add(p);
			}
		}
		
		int res = go(aList,bList);
		if(min>res) min = res;
		
	}

	private static int go(ArrayList<Person> aList, ArrayList<Person> bList) {
		
		int timeA=0,timeB=0;
		
		if(aList.size()>0) timeA = goDown(aList,sList[0][2]);
		if(bList.size()>0) timeB = goDown(bList,sList[1][2]);
		
		return timeA>timeB?timeA:timeB;
		
	}

	private static int goDown(ArrayList<Person> list,int height) {
		
		Collections.sort(list);
		int time = list.get(0).time;//흘러가는 시간, 첫번째 사람의 계단 입구 도착시간부터 처리
		int size = list.size();
		int ingCnt = 0, cCnt = 0;//내려가고 있는 사람수, 다 내려간 사람수
		while(true) {//매 시간마다 사람들을 하나씩 꺼내어 상태를 처리
			for(int i=0;i<size;i++) {
				Person p = list.get(i);
				
				if(p.status==C) continue;
				if(p.time==time) {
					p.status = W;
				}else if(p.status == W && ingCnt<3) {
					p.status = D;
					p.downCnt = 1; //계단수 1부터 출발
					++ingCnt; //내려가는 사람수 증가
				}else if(p.status==D) {
					if(p.downCnt<height) {
						p.downCnt++;
					}else {
						p.status = C;
						++cCnt;
						--ingCnt;
					}
				}
			}
			if(cCnt==size) break;
			++time;
			
		}
		return time;
	}

}
