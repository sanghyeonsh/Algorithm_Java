package BaekJoon;

public class Main_4673_김상현 {

	public static void main(String[] args) {
		
		int[] arr = new int[10001];
		for(int i=1;i<10000;i++) {
			String str = String.valueOf(i);
			int num = i;
			for(int j=0;j<str.length();j++) {
				num+=str.charAt(j)-'0';
			}
			arr[num>10000?10000:num]++;
		}
		for(int i=1;i<=10000;i++) {
			if(arr[i]==0) {
				System.out.println(i);
			}
		}	
	}

}
