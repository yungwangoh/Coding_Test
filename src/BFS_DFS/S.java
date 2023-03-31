package BFS_DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class S {
    static boolean[] visited;
    static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[100001];
        int max = 0;

        tree = new ArrayList[N + 1];
        visited = new boolean[100001];

        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int index = Integer.parseInt(st1.nextToken());
            int node = Integer.parseInt(st1.nextToken());

            tree[node].add(index);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[visited.length];
            arr[i] = dfs(i);
            max = Math.max(arr[i], max);
        }

        for(int i = 1; i <= N; i++) {
            if(max == arr[i]) bw.write(String.valueOf(i));
            bw.write(" ");
        }
        bw.flush();
        bw.close();
    }

    static int dfs(int node) {
        visited[node] = true;

        int count = 1;
        for(var a : tree[node]) {

            if(!visited[a]) {
                visited[a] = true;
                count += dfs(a);
            }
        }

        return count;
    }
}
