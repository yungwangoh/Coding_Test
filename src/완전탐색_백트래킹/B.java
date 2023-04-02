package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] arr;
    static int[][] visit;

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

            for(int j =0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int max = -9999;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'L') {

                    for(int k = 0; k < N; k++) Arrays.fill(visit[k], 0);

                    max = Math.max(bfs(i, j, N, M), max);
                }
            }
        }

        bw.write(String.valueOf(max - 1));
        bw.flush();
        bw.close();
    }
    static int bfs(int y, int x, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();

        visit[y][x] = 1;

        queue.add(new Pair(y ,x));

        while (!queue.isEmpty()) {
            Pair pair = queue.peek();
            y = pair.first();
            x = pair.second();

            queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] > 0 || arr[ny][nx] == 'W') continue;

                visit[ny][nx] = visit[y][x] + 1;
                queue.add(new Pair(ny, nx));
            }
        }

        return visit[y][x];
     }
}
