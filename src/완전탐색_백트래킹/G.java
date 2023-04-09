package 완전탐색_백트래킹;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G {

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

        tracking[N] = 1;
        int bfs = bfs(N, M);

        if(N == M) {
            bw.write("0\n1\n");
        } else {
            bw.write(bfs + "\n");
            bw.write(tracking[M] + "\n");
        }

        bw.flush();
        bw.close();
    }
    static int bfs(int N, int M) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        while (!queue.isEmpty()) {
            N = queue.poll();

            for(var a : new int[]{N - 1, N + 1, N * 2}) {

                if(a >= 0 && a <= 100000) {
                    if (visit[a] == 0) {
                        queue.add(a);
                        visit[a] = visit[N] + 1;
                        tracking[a] += tracking[N];
                    } else if (visit[a] == visit[N] + 1) {
                        tracking[a] += tracking[N];
                    }
                }
            }
        }

        return visit[M];
    }
}
