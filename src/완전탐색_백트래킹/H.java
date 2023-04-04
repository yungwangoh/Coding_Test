package 완전탐색_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class H {

    static int[] arr = new int[100001];
    static int[] visit = new int[100001];
    static int[] tracking = new int[100001];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        bfs(N, M);
    }
    static int bfs(int N, int M) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            for(var a : new int[]{num - 1, num + 1, num * 2}) {

                if(num < 0 || num >= 100000 || visit[a] > 0) continue;

                queue.add(a);
                visit[a] = visit[N] + 1;
            }
        }

        return visit[M];
    }
}
