package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] arr;
    static boolean[][] visit;
    static List<Pair> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[104][104];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
            }
        }

        int ret = 0;
        int v;
        while (true) {

            v = 0;
            pairs.clear();
            visit = new boolean[104][104];
            dfs(0, 0, N, M);

            for(Pair pair : pairs) {
                v++; // 여기가 지워질 좌표. -> 좌표 수 만큼 카운팅. 좌표가 없다면 for 루프를 건너뜀.
                arr[pair.first()][pair.second()] = 0;
            }

            boolean flag = false;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(arr[i][j] == 1) {
                        // v++ 이 여기 들어가면 안됨. -> 지워질 좌표에 들어가야지 로직상 맞음.
                        flag = true;
                    }
                }
            }

            ret++;

            if(!flag) break;
        }

        bw.write((ret) + "\n" + v + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x, int N, int M) {
        visit[y][x] = true;

        if(arr[y][x] == 1) {
            pairs.add(new Pair(y, x));
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx]) continue;
            dfs(ny, nx, N, M);
        }
    }
}
