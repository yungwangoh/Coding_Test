package 그리디;

import java.io.*;
import java.util.*;

class Commend {
    int N; int C;

    public Commend(int n, int c) {
        N = n;
        C = c;
    }
}
public class N {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] arr;
    static int[][] visit;
    static List<Commend> list = new ArrayList<>();
    static int time = 0;
    static int dir = 1;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        visit = new int[N][N];

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[r - 1][c - 1] = Integer.MAX_VALUE;
        }

        int L = Integer.parseInt(br.readLine());

        for(int i = 0; i < L; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st1.nextToken());
            char C = st1.nextToken().charAt(0);

            if(C == 'D') {
                list.add(new Commend(num, 1));
            } else {
                list.add(new Commend(num, 3));
            }
        }

        bfs(0, 0, N);

        bw.write(time + "\n");

        bw.flush();
        bw.close();
    }
    static void bfs(int y, int x, int N) {
        Deque<Pair<Integer>> deque = new LinkedList<>();

        deque.add(new Pair<>(y, x));

        while (!deque.isEmpty()) {
            time++;
            Pair<Integer> p = deque.peekFirst();
            int ny = p.y + dy[dir];
            int nx = p.x + dx[dir];

            if(ny < 0 || nx < 0 || nx >= N || ny >= N || visit[ny][nx] > 0) break;

            if(arr[ny][nx] == Integer.MAX_VALUE) {
                arr[ny][nx] = 0;
            } else {
                Pair<Integer> pair = deque.pollLast();
                visit[pair.y][pair.x] = 0;
            }

            visit[ny][nx] = 1;
            deque.addFirst(new Pair<>(ny, nx));
            if(time == list.get(idx).N) {
                dir = (dir + list.get(idx).C) % 4;
                idx++;
            }
        }
    }
}
