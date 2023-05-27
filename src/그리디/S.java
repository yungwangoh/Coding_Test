package 그리디;

import java.io.*;
import java.util.StringTokenizer;

public class S {

    static int[] oper = new int[4];
    static int[] num;
    static boolean[] visit;

    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        num = new int[N];
        visit = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st1.nextToken());
        int minus = Integer.parseInt(st1.nextToken());
        int mul =  Integer.parseInt(st1.nextToken());
        int div = Integer.parseInt(st1.nextToken());

        go(0, num[0], plus, minus, mul, div, N);

        bw.write(max + "\n");
        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
    static void go (int idx, int sum, int plus, int minus, int mul, int div, int N) {

        if(idx == N - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        if(plus > 0) go(idx + 1, sum + num[idx + 1], plus - 1, minus, mul, div, N);
        if(minus > 0) go(idx + 1, sum - num[idx + 1], plus, minus - 1, mul, div, N);
        if(mul > 0) go(idx + 1, sum * num[idx + 1], plus, minus, mul - 1, div, N);
        if(div > 0) go(idx + 1, sum / num[idx + 1], plus, minus, mul, div - 1, N);
    }
}
