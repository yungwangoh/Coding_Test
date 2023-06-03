package 구현_연습;

import java.io.*;
import java.util.StringTokenizer;

public class S1057 {

    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        if(N < K || N < L) cnt = -1;
        else dfs(K, L);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int K, int L) {

        if(K == L) {
            return;
        }

        cnt++;

        dfs((K + 1) / 2, (L + 1) / 2);
    }
}
