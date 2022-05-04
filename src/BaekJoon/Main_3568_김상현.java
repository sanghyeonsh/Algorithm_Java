package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3568_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		String a = st.nextToken();
		char temp = ' ';
		while(temp!=';') {
			sb.append(a);
			String str = st.nextToken();
			char[] arr = new char[str.length()];
			temp = str.charAt(str.length()-1);
			for(int i=str.length()-1;i>=0;i--) {
				if(str.charAt(i)!=';' && str.charAt(i)!=',') {
					if(str.charAt(i)=='[') {
						sb.append(']');
					}
					else if(str.charAt(i)==']') {
						sb.append('[');
					}
					else if(str.charAt(i)!=';' && str.charAt(i)!=',' && str.charAt(i)!='[' && str.charAt(i)!=']' &&str.charAt(i)!='&' && str.charAt(i)!='*'){
						sb.append(" "+str.charAt(i));
					}
					else {
						sb.append(str.charAt(i));
					}
				}
			}
			sb.append(";\n");
		}
		System.out.println(sb);
	}

}
