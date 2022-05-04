package BaekJoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_10158_김상현 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int curX = Integer.parseInt(st.nextToken());
		int curY = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(br.readLine());
		int tempx = (curX+second)%(2*x);
		int tempy = (curY+second)%(2*y);
		int px = (x - Math.abs(x-tempx));
		int py = (y - Math.abs(y-tempy));
		bw.write(px);
		bw.write(" ");
		bw.write(py);
		bw.flush();
	}

}
