package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P {
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Pair> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for(int i = 0; i < N ; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] == 0) list.add(new Pair(i, j));
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < i; j++) {
                for(int k = 0; k < j; k++) {
                    arr[list.get(i).first()][list.get(i).second()] = arr[list.get(j).first()][list.get(j).second()] =
                            arr[list.get(k).first()][list.get(k).second()] = 1;

                    max = Math.max(max, solve(N, M));

                    arr[list.get(i).first()][list.get(i).second()] = arr[list.get(j).first()][list.get(j).second()] =
                            arr[list.get(k).first()][list.get(k).second()] = 0;
                }
            }
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
    static int solve(int N, int M) {
        visit = new boolean[N][M];

        int cnt = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 2) dfs(i, j, N, M);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(!visit[i][j] && arr[i][j] == 0) cnt++;
            }
        }

        return cnt;
    }
    static void dfs(int y, int x, int N, int M) {
        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || arr[ny][nx] == 1) continue;

            dfs(ny, nx, N, M);
        }
    }
}
