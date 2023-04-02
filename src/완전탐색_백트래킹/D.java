package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D {

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

        Pair pair = null;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'J') pair = new Pair(i, j);
            }
        }

        int var = bfs(pair.first(), pair.second(), N, M);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        bw.write(String.valueOf(var));
        bw.flush();
        bw.close();
    }
    static int bfs(int y, int x, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(y, x));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            y = pair.first();
            x = pair.second();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == '#' || arr[ny][nx] == 'J'
                        || visit[ny][nx] > 0 || arr[ny][nx] == 'F') continue;

                queue.add(new Pair(ny, nx));
                visit[ny][nx] = visit[y][x] + 1;
            }
        }

        return visit[y][x];
    }
}
