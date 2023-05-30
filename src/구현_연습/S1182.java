package 구현_연습;

import java.io.*;
import java.util.StringTokenizer;

public class S1182 {

    static int[] arr;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        visit = new boolean[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i < (1 << N); i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) > 0) {
                    sum += arr[j];
                }
            }
            if (sum == M) cnt++;
        }

        if(M == 0) {
            bw.write(cnt - 1 + "\n");
        } else {
            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }
}
