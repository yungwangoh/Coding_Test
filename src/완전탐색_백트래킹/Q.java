package 완전탐색_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class Q {

    static int cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        arr = new char[R][C];
        visit = new int[R][C];

        for(int i = 0; i < R; i++) {
            String s = br.readLine();

            for(int j = 0; j < C; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visit[R - 1][0] = 1;
        dfs(R - 1, 0, R, C, K);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int N, int M, int K) {

        if(visit[0][M - 1] == K) {
            cnt++;
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] > 0 || arr[ny][nx] == 'T') continue;

            visit[ny][nx] = visit[y][x] + 1;
            dfs(ny, nx, N, M, K);
            visit[ny][nx] = 0;
        }
    }
}
