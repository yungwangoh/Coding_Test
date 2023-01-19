package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;

public class D {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N;
    static int M;
    static int K;
    static int[][] arr;
    static boolean[][] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < K; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            Pair p = new Pair(Integer.parseInt(split[1]), Integer.parseInt(split[0]));
            Pair p1 = new Pair(Integer.parseInt(split[3]), Integer.parseInt(split[2]));

            for(int j = p.first(); j < p1.first(); j++) {
                for(int k = p.second(); k < p1.second(); k++) {
                    arr[j][k] = 1;
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] != 1 && !visit[i][j]) {
                    cnt = dfs(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);

        sb.append(list.size()).append("\n");
        for (Integer integer : list) {
            sb.append(integer).append(" ");
        }
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    static int dfs(int y, int x) {
        int cnt = 1;
        visit[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || visit[ny][nx] || arr[ny][nx] == 1) continue;

            cnt += dfs(ny, nx);
        }

        return cnt;
    }
}
