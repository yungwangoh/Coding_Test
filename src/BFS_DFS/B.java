package BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class B {

    static int ret = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr = new int[51][51];
    static boolean[][] visit = new boolean[51][51];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            arr = new int[51][51];

            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());
            int v = Integer.parseInt(st1.nextToken());

            for(int j = 0; j < v; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st2.nextToken());
                int b = Integer.parseInt(st2.nextToken());

                arr[a][b] = 1;
            }

            visit = new boolean[51][51];
            ret = 0;
            for(int k = 0; k < n; k++) {
                for(int l = 0; l < m; l++) {
                    if(arr[k][l] == 1 && !visit[k][l]) {
                        dfs(k, l, n, m);
                        ret++;
                    }
                }
            }

            bw.write(ret + "\n");
        }

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int n, int m) {

        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= m || ny >= n || visit[ny][nx] || arr[ny][nx] == 0) continue;

            visit[ny][nx] = true;
            dfs(ny, nx, n, m);
        }
    }
}
