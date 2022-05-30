package BaekJoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_18405_김상현 {
    static int N, K, S, X, Y;
    static int[][] map;
    static PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
        public int compare(int[] o1, int[] o2) {
            if(o1[3] != o2[3]) {
                return o1[3] - o2[3]; 
            }
            else {
                return o1[0] - o2[0];
            }
        }
    });
    static boolean[][] visited;

    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j]!=0) {
                        pq.offer(new int[] {map[i][j], i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }

            st = new StringTokenizer(br.readLine(), " ");
            S = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            Y = Integer.parseInt(st.nextToken());

            while(!pq.isEmpty()) {
                int[] cur = pq.poll();
                int y = cur[1];
                int x = cur[2];
                if(cur[3] >= S) continue;
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if(ny<0 || ny>=N || nx<0 || nx>=N) continue;
                    if(visited[ny][nx] && map[ny][nx]!=0) continue;

                    pq.offer(new int[] {cur[0], ny, nx, cur[3]+1});
                    map[ny][nx] = cur[0];
                    visited[ny][nx] = true;
                }
            }

            System.out.println(map[X-1][Y-1]);

        br.close();

}
}