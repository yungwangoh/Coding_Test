package 구현;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class H {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] strings = s.split(" ");
        int N = Integer.parseInt(strings[0]);
        int M = Integer.parseInt(strings[1]);

        String line = br.readLine();
        String[] s1 = line.split(" ");

        int[] arr = Arrays.stream(s1).mapToInt(Integer::parseInt).toArray();
        int[] psum = new int[100004];

        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= N; i++) {
            psum[i] = psum[i - 1] + arr[i - 1];
        }

        for(int i = M; i <= N; i++) {
            max = Math.max(max, psum[i] - psum[i - M]);
        }

        bw.write(String.valueOf(max));

        bw.flush();
        bw.close();
    }
}
