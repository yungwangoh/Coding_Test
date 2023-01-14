package 구현;

import java.io.*;
import java.util.Arrays;

public class L {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String s1 = br.readLine();

        int N = Integer.parseInt(s);
        int M = Integer.parseInt(s1);

        int[] arr = new int[N];

        String s2 = br.readLine();
        String[] s3 = s2.split(" ");
        for(int i = 0; i < s3.length; i++) arr[i] = Integer.parseInt(s3[i]);

        int count = 0;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                if(arr[i] + arr[j] == M) {
                    count++;
                }
            }
        }

        bw.write(String.valueOf(count));

        bw.flush();
        bw.close();
    }

}
