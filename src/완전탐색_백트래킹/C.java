package 완전탐색_백트래킹;

import BFS_DFS.S;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1 ,0};
    static boolean[][] visit;
    static int[][] arr;

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

        int day = 0;
        while (true) {

            search(N, L, R);
            if(!check(N)) break;
        }
    }

    static void search(int N, int L, int R) {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

                for(int k = 0; k < 4; k++) {
                    int ny = i + dy[i];
                    int nx = j + dx[i];

                    if(ny < 0 || nx < 0 || nx >= N || ny >= N) continue;

                    if(arr[ny][nx] >= L && arr[ny][nx] <= R) visit[ny][nx] = true;
                    else visit[ny][nx] = false;
                }
            }
        }
    }
    static boolean check(int N) {

        int ch = arr[0][0];
        boolean flag = false;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(ch != arr[i][j]) {
                    flag = true;
                }
            }
        }

        return flag;
    }
}
