package 완전탐색_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class L {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] visit;
    static int MAX = Integer.MIN_VALUE;
    static boolean[] check = new boolean[26];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        visit[0][0] = 1;
        dfs(0, 0, N, M);
        bw.write(MAX + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int N, int M) {
        MAX = Math.max(MAX, visit[y][x]);
        check[arr[y][x] - 'A'] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] > 0 || check[arr[ny][nx] - 'A']) continue;

            check[arr[ny][nx] - 'A'] = true;
            visit[ny][nx] = visit[y][x] + 1;
            dfs(ny, nx, N, M);
            visit[ny][nx] = 0;
            check[arr[ny][nx] - 'A'] = false;
        }
    }
}
