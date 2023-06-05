package 구현_연습;

import BFS_DFS.Pair;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G7576 {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] visit;
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[M][N];
        visit = new int[M][N];

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] == 1) {
                    visit[i][j] = 1;
                    queue.add(new Pair(i, j));
                }
            }
        }

        bfs(M, N);

        print(N, M);

        boolean flag = false;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(arr[i][j] == -1) continue;

                if(visit[i][j] == 0) flag = true;

                max = Math.max(max, visit[i][j]);
            }
        }

        if(flag) {
            bw.write(-1 + "\n");
        } else {
            bw.write(max - 1 + "\n");
        }

        bw.flush();
        bw.close();
    }
    static void print(int N, int M) {
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                System.out.print(visit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static void bfs(int N, int M) {
        while (!queue.isEmpty()) {
            Pair poll = queue.poll();

            int y = poll.first();
            int x = poll.second();

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == -1) continue;

                if(visit[ny][nx] == 0) {
                    visit[ny][nx] = visit[y][x] + 1;
                    queue.add(new Pair(ny, nx));
                }
            }
        }
    }
}
