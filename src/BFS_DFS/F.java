package BFS_DFS;

import java.io.*;
import java.util.StringTokenizer;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        int sum = 0, l = 1;

        for (int i = 0; i < K; i++) {
            int J = Integer.parseInt(br.readLine());
            int r = l + M - 1;

            if(J >= l && J <= r) continue;
            else {
                if(J < l) {
                    sum += (l - J);
                    l = J;
                } else {
                    sum += (J - r);
                    l += (J - r);
                }
            }
        }

        System.out.println(sum);
    }
}
