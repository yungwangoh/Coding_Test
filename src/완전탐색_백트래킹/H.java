package 완전탐색_백트래킹;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class H {

    static int ret = 0;
    static int[] arr = new int[100004];
    static int[] visit = new int[100004];
    static int[] check = new int[100004];
    static List<Integer> tracking = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int bfs = bfs(N, M);
        bw.write(bfs + "\n");

        for(int i = M; i != N; i = check[i]) tracking.add(i);
        tracking.add(N);

        Collections.reverse(tracking);
        for(Integer i : tracking) bw.write(i + " ");
        bw.write("\n");

        bw.flush();
        bw.close();
    }
    static int bfs(int N, int M) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);

        while (!queue.isEmpty()) {
            Integer num = queue.poll();

            if(num == M) {
                ret = visit[M];
                break;
            }

            for(var a : new int[]{num + 1, num - 1, num * 2}) {

                if(a >= 0 && a <= 100000) {
                    if(visit[a] == 0) {
                        queue.add(a);
                        check[a] = num;
                        visit[a] = visit[num] + 1;
                    }
                }
            }
        }

        return ret;
    }
}
