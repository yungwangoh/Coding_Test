package 구현_연습;

import BFS_DFS.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S14501 {
    static List<Pair> list = new ArrayList<>();
    static boolean[] visit;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        visit = new boolean[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            list.add(new Pair(t, p));
        }

        dfs(0, 0, N);

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int idx, int sum, int N) {

        if(idx >= N) {
            max = Math.max(max, sum);
            return;
        }

        if(idx + list.get(idx).first() <= N) {
            dfs(idx + list.get(idx).first(), sum + list.get(idx).second(), N);
        } else {
            dfs(idx + list.get(idx).first(), sum, N);
        }

        dfs(idx + 1, sum, N);
    }
}
