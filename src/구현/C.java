package 구현;

import java.io.*;
import java.util.StringTokenizer;

public class C {

    static int[] arr = new int[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 3; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());

            for(int j = a; j < b; j++) {
                arr[j]++;
            }
        }

        int sum = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 1) {
                sum += A;
            } else if(arr[i] == 2) {
                sum += (B * 2);
            } else if(arr[i] == 3) {
                sum += (C * 3);
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
