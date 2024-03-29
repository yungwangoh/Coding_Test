package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B {

    static int max = Integer.MIN_VALUE;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'L') {
                    visit = new int[N][M];
                    max = Math.max(bfs(i, j, N, M), max);
                }
            }
        }

        bw.write((max - 1)+ "\n");

        bw.flush();
        bw.close();
    }
    static void test(int N, int M) {

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(visit[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    static int bfs(int y, int x, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();

        visit[y][x] = 1;

        queue.add(new Pair(y, x));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            y = p.first();
            x = p.second();

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
