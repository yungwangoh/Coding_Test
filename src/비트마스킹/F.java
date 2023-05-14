package 비트마스킹;

import java.io.*;
import java.util.StringTokenizer;

public class F {

    static int[] arr = new int[51];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < s.length(); j++) {
                arr[i] |= (1 << (s.charAt(j) - 'a'));
            }
        }
    }
}
