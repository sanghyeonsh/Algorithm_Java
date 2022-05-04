package AfterStudy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Intermediate_1 {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setIn(new FileInputStream("C:/Users/Hi/Downloads/기지국_input.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=1;tc<=T;tc++) {
        	int N = sc.nextInt();
        	int cnt = 0;
        	char[][] arr = new char[N][N];
        	for(int i=0;i<N;i++) {
        		String str = sc.next();
        		for(int j=0;j<N;j++) {
        			arr[i][j]=str.charAt(j);
        		}
        	}
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(arr[i][j]=='A'||arr[i][j]=='B'||arr[i][j]=='C') {
        				if(i-1>=0 && arr[i-1][j]=='H') {
        					arr[i-1][j]='X';
        				}
        				if(i+1<N && arr[i+1][j]=='H') {
        					arr[i+1][j]='X';
        				}
        				if(j-1>=0 && arr[i][j-1]=='H') {
        					arr[i][j-1]='X';
        				}
        				if(j+1<N && arr[i][j+1]=='H') {
        					arr[i][j+1]='X';
        				}
        			}
        			
        			if(arr[i][j]=='B'||arr[i][j]=='C') {
        				if(i-2>=0 && arr[i-2][j]=='H') {
        					arr[i-2][j]='X';
        				}
        				if(i+2<N && arr[i+2][j]=='H') {
        					arr[i+2][j]='X';
        				}
        				if(j-2>=0 && arr[i][j-2]=='H') {
        					arr[i][j-2]='X';
        				}
        				if(j+2<N && arr[i][j+2]=='H') {
        					arr[i][j+2]='X';
        				}
        			}
        			if(arr[i][j]=='C') {
        				if(i-3>=0 && arr[i-3][j]=='H') {
        					arr[i-3][j]='X';
        				}
        				if(i+3<N && arr[i+3][j]=='H') {
        					arr[i+3][j]='X';
        				}
        				if(j-3>=0 && arr[i][j-3]=='H') {
        					arr[i][j-3]='X';
        				}
        				if(j+3<N && arr[i][j+3]=='H') {
        					arr[i][j+3]='X';
        				}
        			}	
        		}
        	}
        	for(int i=0;i<N;i++) {
        		for(int j=0;j<N;j++) {
        			if(arr[i][j]=='H') cnt++;
        		}
        	}
        	System.out.println("#"+tc+" "+cnt);	
        }	
	}
}
