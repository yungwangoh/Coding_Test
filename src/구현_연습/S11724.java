package 구현_연습;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S11724 {

    static List<Integer>[] lists;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        lists = new List[N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st1.nextToken());
            int m = Integer.parseInt(st1.nextToken());

            lists[n].add(m);
            lists[m].add(n);
        }

        for(int i = 1; i < N + 1; i++) {
            if(visit[i]) continue;
            dfs(i);
            cnt++;
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int num) {

        visit[num] = true;

        for (var a : lists[num]) {
            if(visit[a]) continue;

            dfs(a);
        }
    }
}
