package 구현_연습;

import java.io.*;
import java.util.StringTokenizer;

public class S10971 {

    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            dfs(0, i, i, N, 0);
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int depth, int s, int prev, int N, int cost) {

        visit[s] = true;

        if(depth == N - 1) {
            if(arr[prev][s] != 0) {
                min = Math.min(min, cost + arr[prev][s]);
            }
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visit[i] || arr[prev][i] == 0) continue;

            visit[i] = true;
            dfs(depth + 1, s, i, N, cost + arr[prev][i]);
            visit[i] = false;
        }
    }
}
