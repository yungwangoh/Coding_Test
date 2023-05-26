package 그리디;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class L {

    static int[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // bit masking solving
        for(int i = 0; i < (1 << N); i++) {
            if(Integer.bitCount(i) != N / 2)  continue;
            List<Integer> start = new ArrayList<>();
            List<Integer> link = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                if((i & (1 << j)) > 0) start.add(j);
                else link.add(j);
            }
            System.out.println();

            min = Math.min(min , go(start, link, N));
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
    static int go(List<Integer> start, List<Integer> link, int N) {

        int s = 0;
        int l = 0;

        for(int i = 0; i < N / 2; i++) {
            for(int j = 0; j < N / 2; j++) {
                if(i == j) continue;

                s += arr[start.get(i)][start.get(j)];
                l += arr[link.get(i)][link.get(j)];
            }
        }

        return Math.abs(s - l);
    }
}
