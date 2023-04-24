package 구현_연습;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bronze21918 {

    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st2.nextToken());
            int x = Integer.parseInt(st2.nextToken());
            int y = Integer.parseInt(st2.nextToken());

            commend(com, x, y);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i] + " ");
        }

        bw.write(sb + "\n");
        bw.flush();
        bw.close();
    }
    static void commend(int com, int x, int y) {

        switch (com) {
            case 1:
                arr[x - 1] = y;
                break;
            case 2:
                for(int i = x - 1; i < y; i++) {
                    if(arr[i] == 0) arr[i] = 1;
                    else arr[i] = 0;
                }
                break;
            case 3:
                for(int i = x - 1; i < y; i++) {
                    arr[i] = 0;
                }
                break;
            case 4:
                for(int i = x - 1; i < y; i++) {
                    arr[i] = 1;
                }
                break;
            default:
                break;
        }
    }
}
