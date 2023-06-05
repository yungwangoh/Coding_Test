package 구현_연습;

import java.io.*;

public class S3085 {

    static char[][] arr;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        // 행 체크
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[i][j] != arr[i][j + 1]) {
                    swap(arr, i, j, i, j + 1);
                    rowCheck(N);
                    colCheck(N);
                    swap(arr, i, j, i, j + 1);
                }
            }
        }

        // 열 체크
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - 1; j++) {
                if(arr[j][i] != arr[j + 1][i]) {
                    swap(arr, j, i, j + 1, i);
                    rowCheck(N);
                    colCheck(N);
                    swap(arr, j, i, j + 1, i);
                }
            }
        }

        bw.write(max + 1 + "\n");

        bw.flush();
        bw.close();
    }
    static void rowCheck(int N) {

        // 행 체크
        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N - 1; j++) {
                if(arr[i][j] == arr[i][j + 1]) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                max = Math.max(max, cnt);
            }
        }
    }
    static void colCheck(int N) {

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N - 1; j++) {
                if(arr[j][i] == arr[j + 1][i]) {
                    cnt++;
                } else {
                    cnt = 0;
                }
                max = Math.max(max, cnt);
            }
        }
    }
    static void swap(char[][] arr, int a, int b, int c, int d) {
        char tmp = arr[a][b];
        arr[a][b] = arr[c][d];
        arr[c][d] = tmp;
    }
}
