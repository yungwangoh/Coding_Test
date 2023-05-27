package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class L {

    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        visit = new boolean[N];
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        go(0, N, 0);
        bw.write(min / 2 + "\n");

        bw.flush();
        bw.close();
    }
    static void go(int H, int N, int count) {

        if(count == N / 2) {
            int s = 0;
            int l = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(i == j) continue;

                    if (visit[i] && visit[j]) {
                        s += arr[i][j] + arr[j][i];
                    } else if (!visit[i] && !visit[j]) {
                        l += arr[i][j] + arr[j][i];
                    }
                }
            }

            int abs = Math.abs(s - l);
            min = Math.min(min, abs);
        }

        for(int i = H; i < N; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            go(i + 1, N, count + 1);
            visit[i] = false;
        }
    }
}
