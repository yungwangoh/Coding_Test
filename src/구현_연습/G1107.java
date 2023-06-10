package 구현_연습;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class G1107 {

    static boolean[] arr = new boolean[10];
    static List<String> list = new ArrayList<>();
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();

        int M = Integer.parseInt(br.readLine());

        if(M == 0) {
            System.out.println("0\n");
        } else {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                arr[Integer.parseInt(st.nextToken())] = true;
            }

            if(N.equals("100")) {
                System.out.println("0\n");
                return;
            }

            int num = Integer.parseInt(N);
            int abs = Math.abs(100 - num);

            dfs(10, N.length(), "");

            for(var a : list) {
                if(Integer.parseInt(a) <= Integer.parseInt(N)) {
                    min = Math.min(min, Math.abs(Integer.parseInt(N) - Integer.parseInt(a))) + N.length();
                } else {
                    break;
                }
            }

            if(abs < min) {
                System.out.println(abs);
            } else {
                System.out.println(min);
            }
        }
    }
    static void dfs(int n, int r, String tmp) {

        if(tmp.length() == r) {
            list.add(tmp);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(arr[i]) continue;

            dfs(n, r, tmp + i);
        }
    }
}
