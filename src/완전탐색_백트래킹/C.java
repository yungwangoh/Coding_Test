package 완전탐색_백트래킹;

import BFS_DFS.P;
import BFS_DFS.Pair;
import BFS_DFS.S;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1 ,0};
    static boolean[][] visit;
    static int[][] arr;
    static List<Pair> list = new ArrayList<>();
    static int sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int day = 0;
        while (true) {

            visit = new boolean[N][N];
            boolean flag = false;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(!visit[i][j]) {

                        list.clear();
                        visit[i][j] = true;
                        sum = arr[i][j];
                        list.add(new Pair(i, j));
                        dfs(i, j, N, L, R);
                        if(list.size() == 1) continue;
                        for(var a : list) {
                            arr[a.first()][a.second()] = sum / (list.size());
                            flag = true;
                        }
                    }
                }
            }

            if(!flag) break;
            day++;
        }

        bw.write(String.valueOf(day));
        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int N, int L, int R) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;

            int abs = Math.abs(arr[y][x] - arr[ny][nx]);

            if(abs >= L && abs <= R) {

                visit[ny][nx] = true;
                list.add(new Pair(ny, nx));
                sum += arr[ny][nx];
                dfs(ny, nx, N, L, R);
            }
        }
    }
}
