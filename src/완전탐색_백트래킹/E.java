package 완전탐색_백트래킹;

import java.io.*;
import java.util.*;

class Tuple {
    private final int x, y, z;

    public Tuple(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
public class E {

    static List<Tuple> list = Arrays.asList(
            new Tuple(1, 3, 9),
            new Tuple(1, 9, 3),
            new Tuple(3, 1, 9),
            new Tuple(3, 9, 1),
            new Tuple(9, 1, 3),
            new Tuple(9, 3, 1)
            );
    static int visit[][][];
    static int[] arr = new int[3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        visit = new int[61][61][61];
        int bfs = bfs(arr[0], arr[1], arr[2]);

        bw.write(String.valueOf(bfs));

        bw.flush();
        bw.close();
    }
    static int bfs(int x, int y, int z) {
        Queue<Tuple> queue = new LinkedList<>();

        queue.add(new Tuple(x, y, z));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            x = tuple.getX();
            y = tuple.getY();
            z = tuple.getZ();

            for(int i = 0; i < list.size(); i++) {
                Tuple t = list.get(i);
                int nx = x - t.getX();
                int ny = y - t.getY();
                int nz = z - t.getZ();

                if(nx < 0) nx = 0;
                if(ny < 0) ny = 0;
                if(nz < 0) nz = 0;
                if(visit[nx][ny][nz] > 0) continue;

                queue.add(new Tuple(nx, ny, nz));
                visit[nx][ny][nz] = visit[x][y][z] + 1;
            }
        }

        return visit[0][0][0];
    }
}
