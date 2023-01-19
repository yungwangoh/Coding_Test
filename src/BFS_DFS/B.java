package BFS_DFS;

import 구현.I;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class B {

    static final int[] dx = {0, 1, 0, -1};
    static final int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] check;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int T = Integer.parseInt(s);

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int count = 0;

            arr = new int[N][M];
            check = new boolean[N][M];

            for(int j = 0; j < K; j++) {
                StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
                int y = Integer.parseInt(st2.nextToken());
                int x = Integer.parseInt(st2.nextToken());
                arr[y][x] = 1;
            }

            for(int k = 0; k < N; k++) {
                for(int l = 0; l < M; l++) {

                    if(!check[k][l] && arr[k][l] == 1) {
                        dfs(k, l, N, M);
                        count++;
                    }
                }
            }

            bw.write(count + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x, int N, int M) {
        check[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] != 1 || check[ny][nx]) continue;

            dfs(ny, nx, N, M);
        }
        return;
    }
}
