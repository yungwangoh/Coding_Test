package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class W {

    static int[] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int i = 0; i < N; i++) {
            sum += arr[i];

            max = Math.max(max, sum);

            if(sum < 0) sum = 0;
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
}
