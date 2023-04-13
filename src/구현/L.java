package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class L {

    static int cnt = 0;
    static int[] arr;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        arr = new int[N];
        visit = new boolean[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        combi(0, N, 0, 0, M);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
    static void combi(int here, int n, int r, int sum, int M) {
        if(sum == M && r == 2) {
            cnt++;
            return;
        }

        for(int i = here; i < n; i++) {
            visit[i] = true;
            combi(i + 1, n, r + 1, sum + arr[i], M);
            visit[i] = false;
        }
    }
}
