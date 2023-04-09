package 완전탐색_백트래킹;

import java.io.*;
import java.util.*;

public class H {

    static int ret = 0;
    static List<Integer> s = new ArrayList<>();
    static int[] arr;
    static int[] visit;
    static int[] tracking;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[100004];
        visit = new int[100004];
        tracking = new int[100004];

        int bfs = bfs(N, M);

        bw.write(bfs + "\n");

        for(int i = M; i != N; i = tracking[i]) s.add(i);
        s.add(N);

        Collections.reverse(s);
        for(var a : s) {
            bw.write(a + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }
    static int bfs(int N, int M) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        while (!queue.isEmpty()) {
            N = queue.poll();

            if(N == M) {
                ret = visit[M];
                break;
            }

            for(var a : new int[]{N - 1, N + 1, N * 2}) {

                if(a >= 0 && a <= 100000) {
                    if(visit[a] == 0) {
                        queue.add(a);
                        tracking[a] = N;
                        visit[a] = visit[N] + 1;
                    }
                }
            }
        }

        return ret;
    }
}
