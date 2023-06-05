package 구현_연습;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S2606 {

    static List<Integer>[] lists;
    static boolean[] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        lists = new List[N + 1];
        visit = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            lists[n].add(m);
            lists[m].add(n);
        }

        dfs(1);

        bw.write(cnt - 1 + "\n");

        bw.flush();
        bw.close();
    }
    static void dfs(int n) {

        cnt++;
        //System.out.println(n);
        visit[n] = true;

        for(var there : lists[n]) {
             if(visit[there]) continue;

             dfs(there);
        }
    }
}
