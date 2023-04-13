package BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class C {
    static int areaMax= Integer.MIN_VALUE;
    static int max = Integer.MIN_VALUE;
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

                max = Math.max(max, arr[i][j]);
            }
        }

        for(int i = 1; i <= max; i++) {
            int ret = 0;
            visit = new boolean[N][N];

            count(i, N);

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    if(visit[j][k]) continue;

                    dfs(j, k, N);
                    ret++;
                }
            }

            areaMax = Math.max(areaMax, ret);
        }

        if(areaMax == 0) {
            bw.write("1\n");
        } else {
            bw.write(areaMax + "\n");
        }
        bw.flush();
        bw.close();
    }
    static void count(int num, int N) {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] <= num) {
                    visit[i][j] = true;
                }
            }
        }
    }
    static void dfs(int y, int x, int N) {

        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;

            visit[ny][nx] = true;
            dfs(ny, nx, N);
        }
    }
}
