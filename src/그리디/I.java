package 그리디;

import java.io.*;
import java.util.*;

public class I {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int cnt = 0;
        while (start != end) {
            if(arr[start] + arr[end] == M) {
                end--;
                cnt++;
            } else if(arr[start] + arr[end] < M) {
                start++;
            } else if(arr[start] + arr[end] > M) {
                end--;
            }
        }


        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
}
