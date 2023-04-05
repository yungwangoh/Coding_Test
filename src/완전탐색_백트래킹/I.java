package 완전탐색_백트래킹;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class I {
    static int MAX = 500000;
    static int[][] visit = new int[2][MAX + 4];
    static boolean check = false;
    static int turn = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if(N == K) {
            bw.write("0");

            bw.flush();
            bw.close();

            System.exit(0);
        }
        bfs(N, K);

        if(check) bw.write(String.valueOf(turn));
        else bw.write("-1");

        bw.flush();
        bw.close();
    }
    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();

        visit[0][N] = 1;
        queue.add(N);

        while (!queue.isEmpty()) {
            K += turn;
            if(K > MAX) break;
            if(visit[turn % 2][K] > 0) {
                check = true;
                break;
            }

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer now = queue.poll();

                for (var a : new int[]{now - 1, now + 1, now * 2}) {

                    if(a < 0 || a > MAX || visit[turn % 2][a] > 0) continue;
                    visit[turn % 2][a] = visit[(turn + 1) % 2][a] + 1;
                    if(a == K) {
                        check = true;
                        break;
                    }
                    queue.add(a);
                }

                if(check) break;;
            }
            if(check) break;
            turn++;
        }
    }
}
