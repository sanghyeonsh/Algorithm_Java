package SamsungBStudy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Secret {
    String secretCode;
    char meetingPoint;
    int time;
    Secret(String secretCode,char meetingPoint, int time){
        this.secretCode = secretCode;
        this.meetingPoint = meetingPoint;
        this.time = time;
    }
	public static void main(String[] args) throws IOException {
	
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String code = st.nextToken();
        char point = st.nextToken().charAt(0);
        int time = Integer.parseInt(st.nextToken());
        System.out.println("secret code : "+code);
        System.out.println("meeting point : "+point);
        System.out.println("time : "+time);
	}

}
