package 완전탐색_백트래킹;

import BFS_DFS.Pair;
import BFS_DFS.Q;

import java.io.*;
import java.util.*;

public class J {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int y1 = Integer.parseInt(st.nextToken());
        int x1 = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int bfs = bfs(y - 1, x - 1, y1 - 1, x1 - 1, N, M);

        bw.write(bfs + "\n");

        bw.flush();
        bw.close();
    }
    static int bfs(int y, int x, int y1, int x1, int N, int M) {
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(y, x));

        while (arr[y1][x1] != '0') {
            Queue<Pair> queue1 = new LinkedList<>();
            cnt++;

            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                y = p.first();
                x = p.second();

                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];

                    if (nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] > 0) continue;

                    visit[ny][nx] = cnt;

                    if(arr[ny][nx] != '0') {
                        arr[ny][nx] = '0';
                        queue1.add(new Pair(ny, nx));
                    } else {
                        queue.add(new Pair(ny, nx));
                    }
                }
            }

            queue = queue1;
        }

        return visit[y1][x1];
    }
}
