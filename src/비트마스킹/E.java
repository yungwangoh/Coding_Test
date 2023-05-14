package 비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

public class E {

    static int[][] arr;
    static int[][] brr;
    static int ret = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];
        brr = new int[N + 1][N + 1];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());
                brr[j][i] = arr[i][j];
            }
        }

        solve(arr, N, L);
        solve(brr, N, L);

        bw.write(ret + "\n");

        bw.flush();
        bw.close();
    }
    static void solve(int[][] arr, int N, int L) {

        for(int i = 0; i < N; i++) {
            int cnt = 1;
            int j;
            for(j = 0; j < N - 1; j++) {
                if(arr[i][j] == arr[i][j + 1]) cnt++;
                else if(arr[i][j] + 1 == arr[i][j + 1] && cnt >= L) cnt = 1;
                else if(arr[i][j] - 1 == arr[i][j + 1] && cnt >= 0) cnt = -L + 1;
                else break;
            }

            if(j == N - 1 && cnt >= 0) ret++;
        }
    }
}
