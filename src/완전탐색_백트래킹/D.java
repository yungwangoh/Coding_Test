package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.*;

public class D {

    static int ret = 0;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static char[][] arr;
    static int[][] human;
    static int[][] fire;
    static List<Pair> h = new ArrayList<>();
    static Queue<Pair> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        human = new int[N][M];
        fire = new int[N][M];

        for(int i = 0; i < N; i++) {
            Arrays.fill(fire[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);

                if(arr[i][j] == 'J'){
                    h.add(new Pair(i, j));
                }

                if(arr[i][j] == 'F') {
                    fire[i][j] = 1;
                    queue.add(new Pair(i, j));
                }
            }
        }

        int bfs = bfs(h.get(0).first(), h.get(0).second(), N, M);

        if(bfs != 0) {
            bw.write(bfs + "\n");
        } else {
            bw.write("IMPOSSIBLE\n");
        }
        bw.flush();
        bw.close();
    }
    static int bfs(int hy, int hx, int N, int M) {

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            int fy = p.first();
            int fx = p.second();

            for(int i = 0; i < 4; i++) {
                int nx = fx + dx[i];
                int ny = fy + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == '#') continue;
                if(fire[ny][nx] != Integer.MAX_VALUE) continue;

                fire[ny][nx] = fire[fy][fx] + 1;
                queue.add(new Pair(ny, nx));
            }
        }

        human[hy][hx] = 1;
        queue.add(new Pair(hy, hx));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            hy = p.first();
            hx = p.second();

            if(hy == 0 || hx == 0 || hy == N - 1 || hx == M - 1) {
                ret = human[hy][hx];
                break;
            }

            for(int i = 0; i < 4; i++) {
                int nx = hx + dx[i];
                int ny = hy + dy[i];

                if(nx < 0 || ny < 0 || nx >= M || ny >= N || human[ny][nx] > 0 || arr[ny][nx] == '#') continue;
                if(fire[ny][nx] <= human[hy][hx] + 1) continue;

                human[ny][nx] = human[hy][hx] + 1;
                queue.add(new Pair(ny, nx));
            }
        }

        return ret;
    }
}
