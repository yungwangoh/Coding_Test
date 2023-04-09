package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visit;
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
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int d = 0;
        while (true) {
            boolean flag = false;

            visit = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visit[i][j]) {

                        list.clear();
                        visit[i][j] = true;
                        list.add(new Pair(i, j));
                        sum = arr[i][j];
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
            d++;
        }

        bw.write(d + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int N, int L, int R) {

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= N || ny >= N || visit[ny][nx]) continue;

            int abs = Math.abs(arr[ny][nx] - arr[y][x]);
            if(abs >= L && abs <= R) {
                list.add(new Pair(ny, nx));
                sum += arr[ny][nx];
                visit[ny][nx] = true;
                dfs(ny, nx, N, L, R);
            }
        }
    }
}
