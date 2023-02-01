package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class E {

    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < N; j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(go(0, 0, N));

        bw.flush();
        bw.close();
    }

    static String go(int y, int x, int N) {
        StringBuilder tmp = new StringBuilder();
        int val = arr[y][x];

        if(N == 1) {
            return Integer.toString(arr[y][x]);
        }

        for(int i = y; i < y + N; i++) {
            for(int j = x; j < x + N; j++) {
                if(arr[i][j] != val) {
                    tmp.append("(");
                    tmp.append(go(y, x, N / 2));
                    tmp.append(go(y, x + N / 2, N / 2));
                    tmp.append(go(y + N / 2, x, N / 2));
                    tmp.append(go(y + N / 2, x + N / 2, N / 2));
                    tmp.append(")");
                    return tmp.toString();
                }
            }
        }
        return Integer.toString(arr[y][x]);
    }
}
