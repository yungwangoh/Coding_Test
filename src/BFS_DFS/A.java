package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Pair {
    Integer x, y;

    public Pair(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    Integer first() {
        return x;
    }

    Integer second() {
        return y;
    }
}
public class A {
    static int[][] arr = new int[101][1001];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] visit = new int[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] split = s.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);


        for(int i = 0; i < N; i++) {
            String line = br.readLine();

            for(int j = 0; j < line.length(); j++) {
                arr[i][j] = line.charAt(j) - '0';
            }
        }

        Queue<Pair> queue = new LinkedList<>();
        visit[0][0] = 1;
        queue.add(new Pair(0, 0));
        while (queue.size() > 0) {
            Pair p = queue.poll();
            int x = p.x;
            int y = p.y;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M || visit[nx][ny] > 0 || arr[nx][ny] == 0) continue;

                visit[nx][ny] = visit[x][y] + 1;
                queue.add(new Pair(nx, ny));
            }
        }

        bw.write(Integer.toString(visit[N - 1][M - 1]));

        bw.flush();
        bw.close();
    }
}
