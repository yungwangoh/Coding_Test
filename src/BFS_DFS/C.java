package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class C {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] visit;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int max = 0;
        int m = 0;

        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i][j]);
            }
        }

        for(int n = 0; n < max; n++) {

            visit = new boolean[N][N];
            int cnt = 0;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] <= n) {
                        visit[i][j] = true;
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visit[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }

            m = Math.max(m, cnt);
        }

        bw.write(Integer.toString(m));

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x) {
        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;

            dfs(ny, nx);
        }
    }
}
