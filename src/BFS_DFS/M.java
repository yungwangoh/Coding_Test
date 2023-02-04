package BFS_DFS;

import java.io.*;
import java.nio.Buffer;

public class M {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int i = 0, cnt = 0;
        while (true) {

            String s = String.valueOf(i);
            if(s.contains("666")) {
                cnt++;
            }

            if(cnt == N) {
                break;
            }

            i++;
        }

        bw.write(String.valueOf(i));

        bw.flush();
        bw.close();
    }
}
