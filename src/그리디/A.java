package 그리디;

import java.io.*;
import java.util.*;

class Pair<T> {
    T y, x;

    public Pair(T y, T x) {
        this.y = y;
        this.x = x;
    }

    public T getY() {
        return y;
    }

    public T getX() {
        return x;
    }
}
public class A {

    static List<Pair<Integer>> list = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new Pair<>(p, d));
        }

        list.sort(Comparator.comparing(o -> o.x));

        for(int i = 0; i < N; i++) {
            pq.add(list.get(i).y);

            if(pq.size() > list.get(i).x) {
                pq.poll();
            }
        }

        int ret = 0;
        while (!pq.isEmpty()) {
            ret += pq.poll();
        }

        bw.write(ret + "\n");

        bw.flush();
        bw.close();
    }
}
