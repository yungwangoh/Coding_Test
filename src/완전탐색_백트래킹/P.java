package 완전탐색_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class P {

    static int min = Integer.MAX_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        dfs(N, 0, 0);

        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int N, int sum, int cnt) {

        if(cnt == 3) {
            min = Math.min(min, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(check(i, j, N)) continue;

                dfs(N, sum + addFlower(i,j, N), cnt + 1);
                deleteFlower(i, j, N);
            }
        }
    }
    static boolean check(int y, int x, int N) {

        if(visit[y][x]) return true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) return true;
        }

        return false;
    }
    static int addFlower(int y, int x, int N) {

        int sum = arr[y][x];
        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;

            visit[ny][nx] = true;
            sum += arr[ny][nx];
        }

        return sum;
    }
    static void deleteFlower(int y, int x, int N) {

        visit[y][x] = false;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            visit[ny][nx] = false;
        }
    }
}
