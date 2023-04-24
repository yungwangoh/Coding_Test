package 구현_연습;

import java.io.*;
import java.util.StringTokenizer;

public class Bronze20053 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            int M = Integer.parseInt(br.readLine());

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st1.nextToken());

                max = Math.max(max, num);
                min = Math.min(min, num);
            }

            bw.write(min + " " + max + "\n");
        }

        bw.flush();
        bw.close();
    }
}
