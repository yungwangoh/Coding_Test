package 구현_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G1107 {

    static boolean[] arr = new boolean[10];
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int M = Integer.parseInt(br.readLine());

        if(M != 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }
        }

        if(N.equals("100")) {
            System.out.println("0\n");
            return;
        }

        int num = Integer.parseInt(N);
        int abs = Math.abs(100 - num);

        min = Math.min(min, abs);

        dfs(10, 0, N, "");

        System.out.println(min + "\n");
    }
    static void dfs(int num, int idx, String N, String tmp) {

        for(int i = 0; i < num; i++) {
            if(arr[i]) continue;

            String s = tmp + i;

            min = Math.min(min, Math.abs(Integer.parseInt(N) - Integer.parseInt(s)) + String.valueOf(Integer.parseInt(s)).length());

            if(idx < 6) dfs(num, idx + 1, N, s);
        }
    }
}
