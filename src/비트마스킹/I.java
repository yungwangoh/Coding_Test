package 비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int set = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            int num;

            boolean val = false;
            switch (str) {
                case "add":
                    num = Integer.parseInt(st.nextToken());
                    set |= (1 << (num - 1));
                    break;
                case "remove":
                    num = Integer.parseInt(st.nextToken());
                    set &= ~(1 << (num - 1));
                    break;
                case "check":
                    num = Integer.parseInt(st.nextToken());
                    sb.append((set & (1 << (num - 1))) != 0 ? "1\n" : "0\n");
                    break;
                case "toggle":
                    num = Integer.parseInt(st.nextToken());
                    set ^= (1 << (num - 1));
                    break;
                case "all":
                    set |= ~0;
                    break;
                case "empty":
                    set &= 0;
                    break;
                default:
                    break;
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
