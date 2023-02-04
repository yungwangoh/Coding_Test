package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class K {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int tmp = Integer.parseInt(st1.nextToken());

            int two = 0, five = 0;
            for(int j = 2; j <= tmp; j *= 2) {
                two += tmp / j;
            }

            for(int k = 5; k <= tmp; k *= 5) {
                five += tmp / k;
            }

            int min = Math.min(two, five);
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
    }
}
