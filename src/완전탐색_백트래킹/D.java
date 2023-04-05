package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D {

    static int ret = 0;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static char[][] arr;
    static int[][] fireVisit;
    static int[][] humanVisit;
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Pair p = null;

        arr = new char[N][M];
        fireVisit = new int[N][M];
        humanVisit = new int[N][M];

        for(int i = 0; i < N; i++) {
            Arrays.fill(fireVisit[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {

            String s = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'F') {
                    fireVisit[i][j] = 1;
                    queue.add(new Pair(i, j));
                }
                if (arr[i][j] == 'J') {
                    p = new Pair(i, j);
                }
            }
        }

        int bfs = bfs(p.first(), p.second(), N, M);

        if(bfs != 0) {
            bw.write(bfs + "\n");
        } else {
            bw.write("IMPOSSIBLE\n");
        }

        bw.flush();
        bw.close();
    }
    static int bfs(int y1, int x1, int N, int M) {

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int y = p.first();
            int x = p.second();

            for(int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if(ny < 0 || nx < 0 || nx >= M || ny >= N || arr[ny][nx] == '#') continue;
                if(fireVisit[ny][nx] != Integer.MAX_VALUE) continue;

                queue.add(new Pair(ny, nx));
                fireVisit[ny][nx] = fireVisit[y][x] + 1;
            }
        }

        humanVisit[y1][x1] = 1;
        queue.add(new Pair(y1, x1));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            y1 = p.first();
            x1 = p.second();

            if(y1 == 0 || x1 == 0 || x1 == M - 1 || y1 == N - 1) {
                ret = humanVisit[y1][x1];
                break;
            }

            for(int i = 0; i < 4; i++) {
                int ny = y1 + dy[i];
                int nx = x1 + dx[i];

                if(ny < 0 || nx < 0 || nx >= M || ny >= N || humanVisit[ny][nx] > 0 || arr[ny][nx] == '#') continue;
                if(fireVisit[ny][nx] <= humanVisit[y1][x1] + 1) continue;

                humanVisit[ny][nx] = humanVisit[y1][x1] + 1;
                queue.add(new Pair(ny, nx));
            }
        }

        return ret;
    }
}
