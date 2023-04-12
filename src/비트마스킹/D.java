package 비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

public class D {

    static int ret = Integer.MIN_VALUE;
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
        visit = new int[N][M];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        dfs(0, 0, 1 << ((int) arr[0][0] - 'A'), 1, N, M);

        bw.write(ret + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int y, int x, int num, int cnt, int N, int M) {

        ret = Math.max(ret, cnt);

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
            int next = (1 << (int) arr[ny][nx] - 'A');

            if((num & next) == 0) {
                dfs(ny, nx, num | next, cnt + 1, N, M);
            }
        }
    }
}
