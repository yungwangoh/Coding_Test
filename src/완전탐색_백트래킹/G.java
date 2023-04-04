package 완전탐색_백트래킹;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G {
    static int[] visit;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        visit = new int[100001];
        visited = new int[100001];

        visited[N] = 1;
        int bfs = bfs(N, M);

        if(N == M) {
            bw.write("0\n1");
        }else {
            bw.write(bfs + "\n");
            bw.write(visited[M] + "\n");
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
                    if(visit[a] == 0) {
                        queue.add(a);
                        visit[a] = visit[N] + 1;
                        visited[a] += visited[N];
                    } else if(visit[a] == visit[N] + 1) {
                        visited[a] += visited[N];
                    }
                }
            }
        }

        return visit[M];
    }
}
