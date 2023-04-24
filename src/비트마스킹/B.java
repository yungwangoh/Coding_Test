package 비트마스킹;

import java.io.*;

public class B {

    static char[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new char[N][N];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            for(int j = 0; j < N; j++) {
                arr[i][j] = s.charAt(j);
            }
        }


    }
}
