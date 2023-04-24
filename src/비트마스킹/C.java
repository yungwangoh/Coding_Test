package 비트마스킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.*;

public class C {

    static int min = Integer.MAX_VALUE;
    static List<Integer>[] lists = new List[11];
    static int[] arr = new int[11];
    static boolean[] visit = new boolean[11];
    static int[] comp = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lists[i] = new ArrayList<>();
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            int M = Integer.parseInt(st1.nextToken());
            for(int j = 0; j < M; j++) {
                list.add(Integer.parseInt(st1.nextToken()));
            }

           lists[i] = list;
        }

        for(int i = 1; i < (1 << N) - 1; i++) {
            visit = new boolean[11];
            comp = new int[11];
            int idx1 = -1; int idx2 = -1;

            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) > 0) {
                    comp[j + 1] = 1;
                    idx1 = j + 1;
                } else {
                    idx2 = j + 1;
                }
            }
            Pair p1 = dfs(idx1, 1);
            Pair p2 = dfs(idx2, 0);

            if(p1.first() + p2.first() == N) {
                min = Math.min(min, Math.abs(p1.second() - p2.second()));
            }
        }

        if(min == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(min + "\n");
        }
        bw.flush();
        bw.close();
    }
    static Pair dfs(int here, int num) {

        visit[here] = true;
        Pair p = new Pair(1, arr[here]);

        for(var a : lists[here]) {
            if(comp[a] != num) continue;
            if(visit[a]) continue;

            Pair dfs = dfs(a, num);
            p = new Pair(p.first() + dfs.first(), p.second() + dfs.second());
        }

        return p;
    }
}
