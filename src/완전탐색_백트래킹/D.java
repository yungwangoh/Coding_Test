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
    static int[][] humanVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        visit = new int[N][M];
        humanVisit = new int[N][M];

        Pair p = null;
        Pair p1 = null;
        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'F') p = new Pair(i, j);
                if(arr[i][j] == 'J') p1 = new Pair(i, j);
            }
        }

        int var = bfs(p.first(), p.second(), p1.first(), p1.second(), N, M);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(humanVisit[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        bw.write(String.valueOf(var));
        bw.flush();
        bw.close();
    }
    static int bfs(int y, int x, int y1, int x1, int N, int M) {
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

        queue.add(new Pair(y1, x1));
        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            y1 = p.first();
            x1 = p.second();

            for(int i = 0; i < 4; i++) {
                int nx = x1 + dx[i];
                int ny = y1 + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == '#' || arr[ny][nx] =='J'
                        || arr[ny][nx] == 'F' || humanVisit[ny][nx] > 0) continue;

                queue.add(new Pair(ny,nx));

                if(humanVisit[ny][nx] < visit[y1][x1]) {
                    humanVisit[ny][nx] = humanVisit[y1][x1] + 1;
                }
            }
        }

        return humanVisit[y1][x1];
    }
}
