package BFS_DFS;

import java.io.*;
import java.util.*;

public class R {

    static int ans = 0;
    static boolean[] visit;
    static List<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int root = 0;

        visit = new boolean[N];

        list = new ArrayList[N];

        for(int i = 0; i < N; i++) list[i] = new ArrayList<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st1.nextToken());

            if(num == -1) root = i;
            else {
                list[num].add(i);
            }

        }

        int M = Integer.parseInt(br.readLine());

        visit[M] = true;

        if(!visit[root]) {
            dfs(root);
        }

        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void dfs(int N) {
        visit[N] = true;

        int childNode = 0;
        for(int i = 0; i < list[N].size(); i++) {
            Integer num = list[N].get(i);

            if(!visit[num]) {
                childNode++;
                visit[num] = true;
                dfs(num);
            }
        }

        if(childNode == 0)
            ans++;
    }
}
