package 구현_연습;

import BFS_DFS.Pair;

import java.io.*;
import java.util.*;

public class S17086 {

    static int[] dx = {-1, 0, 1, 0, 1, -1, 1, -1};
    static int[] dy = {0, 1, 0, -1, -1, 1, 1, -1};
    static int[][] arr;
    static int[][] visit;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Pair> queue = new LinkedList<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] == 1) {
                    visit[i][j] = 1;
                    queue.add(new Pair(i ,j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            bfs(p.first(), p.second(), N, M);
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                max = Math.max(max, visit[i][j]);
            }
        }

        bw.write(max - 1 + "\n");

        bw.flush();
        bw.close();
    }
    static void bfs(int y, int x, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(y, x));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            int sy = p.first();
            int sx = p.second();

            for(int i = 0; i < 8; i++) {
                int nx = sx + dx[i];
                int ny = sy + dy[i];

                if(nx < 0 || ny < 0 || ny >= N || nx >= M) continue;

                if(visit[ny][nx] == 0) {
                    visit[ny][nx] = visit[sy][sx] + 1;
                    queue.add(new Pair(ny, nx));
                } else if(visit[ny][nx] > visit[sy][sx] + 1){
                    visit[ny][nx] = visit[sy][sx] + 1;
                    queue.add(new Pair(ny, nx));
                }
            }
        }
    }
}
