package AfterStudy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class 기지국 {

    static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;

    static int T;
    static int N;
    static char[][] map;
    static int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    public static void main(String[] args) throws IOException {
        // 입력 방향을 살짝 바꿔주자.
        input = new BufferedReader(new StringReader(src));
        T = Integer.parseInt(input.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(input.readLine());

            // 쓸데없이 메모리를 쓰고 있는 부분은?
            map = new char[N][];
            for (int r = 0; r < N; r++) {
                map[r] = input.readLine().toCharArray();
            }
            /*
            // 입력 확인!!
            for(char [] row: map) {
                System.out.println(Arrays.toString(row));
            }
            // 입력 완료
             */

            // 2차원 배열 탐색 - 좌표계를 명확히 해두세요!
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    
                    if (map[r][c] == 'A') { // 사방으로 1칸씩 탐색
                        check(r, c, 1);
                    } else if (map[r][c] == 'B') { // 사방으로 2칸씩 탐색
                        check(r, c, 2);
                    } else if (map[r][c] == 'C') { // 사방으로 3칸씩 탐색
                        check(r, c, 3);
                    }
                    /*
                    if(map[r][c]<'D') {
                        check(r, c, map[r][c]-'A'+1);
                    }
                    */
                }
            }
            // 표시 완료!!!
            // 남은 집의 개수는?
            int answer = 0;
            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(map[r][c]=='H') {
                        answer++;
                    }
                }
            }
            output.append(String.format("#%d %d%n", t, answer));
        }// 테케 종료
        System.out.println(output);
    }

    /**
     * (r, c)에서 사방으로 l칸을 살펴보자!!
     * 
     * @param r
     * @param c
     * @param l
     */
    private static void check(int r, int c, int l) {
        for (int d = 0; d < 4; d++) {
            for (int i = 1; i <= l; i++) {
                // 거리만큼 한 칸씩 전진하면서 살펴보기.
                int nr = r + deltas[d][0]*i;
                int nc = c + deltas[d][1]*i;
                // 새로운 지점? 거기가 맵 안에 있나? 그리고 집인가?
                if (isIn(nr, nc) && map[nr][nc] == 'H') {
                    // 만약 거기가 집이면 전파 수신 가능하니까 X로 바꿔버리자!!
                    map[nr][nc] = 'X';
                }
            }
        }
    }

    private static boolean isIn(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }

    private static String src = "10\r\n"
            + "5\r\n"
            + "XXXXX\r\n"
            + "XHXXX\r\n"
            + "HXAHX\r\n"
            + "XHHXX\r\n"
            + "XBHHX\r\n"
            + "9\r\n"
            + "XXXXXXXXX\r\n"
            + "XXXHXXXXX\r\n"
            + "XXHAHXXHX\r\n"
            + "XXHHXXXXX\r\n"
            + "XXXXXXXXX\r\n"
            + "XXAHHXXXX\r\n"
            + "XXHXXHAHX\r\n"
            + "XXAHXXHXX\r\n"
            + "XXHXHXXXX\r\n"
            + "9\r\n"
            + "XXXXXXXXX\r\n"
            + "XXHHHXXXX\r\n"
            + "XXHAHXHXX\r\n"
            + "XXHHHXHXX\r\n"
            + "XXXHXXXXX\r\n"
            + "XXXBXXXXX\r\n"
            + "XXXXXXCHH\r\n"
            + "XXXXXXXXX\r\n"
            + "XXXHXXHXX\r\n"
            + "10\r\n"
            + "XXXXXXXXXX\r\n"
            + "XXXHXXXXXX\r\n"
            + "XHXAHXXXXX\r\n"
            + "XXXHXXHXXX\r\n"
            + "XXXHXXHXXX\r\n"
            + "XXBXXXHXXX\r\n"
            + "HXHHHHCHHH\r\n"
            + "XXHXXXHXXX\r\n"
            + "XXXXXXHXXX\r\n"
            + "XXHXXXHXXX\r\n"
            + "10\r\n"
            + "XXXXXXXXXX\r\n"
            + "XXXXHXXXXX\r\n"
            + "XXHAHAXXXX\r\n"
            + "XXXAHAXXXX\r\n"
            + "XXHBHHAXXX\r\n"
            + "XXHBACHXXX\r\n"
            + "BXXHBCXXXX\r\n"
            + "HAHCHHAXXX\r\n"
            + "XXXXXHXXXX\r\n"
            + "XXXXXXXXXX\r\n"
            + "9\r\n"
            + "XXXXHXXXX\r\n"
            + "XXXXXXXXX\r\n"
            + "XHXXHXXXX\r\n"
            + "XXXXXXXXX\r\n"
            + "XHXXHXXXX\r\n"
            + "XXXXHHXXH\r\n"
            + "XXXXXHXXX\r\n"
            + "XHXXXHXXX\r\n"
            + "XXXXXXXXX\r\n"
            + "9\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "HHHHHHHHH\r\n"
            + "10\r\n"
            + "XAXXXCXXXX\r\n"
            + "XBXCXAXXXX\r\n"
            + "XXXBACXXXX\r\n"
            + "XXXBBABXXX\r\n"
            + "XXXACXXXXX\r\n"
            + "XXXXXXAXXX\r\n"
            + "XCXXXXBXXX\r\n"
            + "XXAXCXCXXX\r\n"
            + "XXXXXXXXXX\r\n"
            + "XXXXXXXXXX\r\n"
            + "10\r\n"
            + "ABABCABCAC\r\n"
            + "BACABACBAC\r\n"
            + "ABCABCABAC\r\n"
            + "BACBAABCAB\r\n"
            + "ABBAABCABC\r\n"
            + "ABCBABCBAA\r\n"
            + "ABBBAABCCA\r\n"
            + "ABBCCABCAB\r\n"
            + "ABBCAACBBC\r\n"
            + "ABBCCAACBA\r\n"
            + "10\r\n"
            + "HHHHHHHHHH\r\n"
            + "ABCBABAABA\r\n"
            + "HHHHHHHHHH\r\n"
            + "ABCBABCCAB\r\n"
            + "HHHHHHHHHH\r\n"
            + "AABCAABBCA\r\n"
            + "HHHHHHHHHH\r\n"
            + "BCABBCBCAC\r\n"
            + "HHHHHHHHHH\r\n"
            + "CABBCAACCB";

}
