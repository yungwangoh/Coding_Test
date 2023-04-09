package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.*;

public class J {

    static int cnt = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] visit;
    static List<Pair> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int y1 = Integer.parseInt(st1.nextToken());
        int x1 = Integer.parseInt(st1.nextToken());

        int y2 = Integer.parseInt(st1.nextToken());
        int x2 = Integer.parseInt(st1.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];


        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int bfs = bfs(y1 - 1, x1 - 1, y2 - 1, x2 - 1, N, M);

        bw.write(bfs + "\n");

        bw.flush();
        bw.close();
    }
    static int bfs(int y1, int x1, int y2, int x2, int N, int M) {

        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(y1, x1));
        visit[y1][x1] = 1;

        while (arr[y2][x2] != '0') {
            cnt++;
            Queue<Pair> tmp = new LinkedList<>();

            while (!queue.isEmpty()) {
                Pair p = queue.poll();
                y1 = p.first();
                x1 = p.second();

                for(int i = 0; i < 4; i++) {
                    int nx = x1 + dx[i];
                    int ny = y1 + dy[i];

                    if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] > 0) continue;

                    visit[ny][nx] = cnt;

                    if(arr[ny][nx] != '0') {
                        arr[ny][nx] = '0';
                        tmp.add(new Pair(ny, nx));
                    } else {
                        queue.add(new Pair(ny ,nx));
                    }
                }
            }

            queue = tmp;
        }

        return visit[y2][x2];
    }
}
