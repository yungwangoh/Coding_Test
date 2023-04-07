package 완전탐색_백트래킹;

import java.io.*;
import java.util.StringTokenizer;

public class O {

    static int ret = Integer.MAX_VALUE;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        visit = new boolean[34][34];

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st1.nextToken());
            int x = Integer.parseInt(st1.nextToken());

            visit[y][x] = true;
        }

        dfs(1, 0, N, H);

        bw.write(String.valueOf((ret == Integer.MAX_VALUE) ? -1 : ret));

        bw.flush();
        bw.close();
    }
    static void dfs(int here, int cnt, int N, int H) {
        if(cnt > 3 || cnt >= ret) return;
        if(check(N, H)) {
            ret = Math.min(ret, cnt);
            return;
        }

        for(int i = here; i <= H; i++) {
            for(int j = 1; j <= N; j++) {
                if(visit[i][j] || visit[i][j - 1] || visit[i][j + 1]) continue;
                visit[i][j] = true;
                dfs(i, cnt + 1, N, H);
                visit[i][j] = false;
            }
        }
    }
    static boolean check(int N, int H) {

        for(int i = 1; i <= N; i++) {
            int start = i;

            for(int j = 1; j <= H; j++) {
                if(visit[j][start]) start++;
                else if(visit[j][start - 1]) start--;
            }
            if(start != i) return false;
        }

        return true;
    }
}
