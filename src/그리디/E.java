package 그리디;

import java.io.*;
import java.util.*;

public class E {

    static List<Pair<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            list.add(new Pair<>(n, m));
        }

        list.sort((o1, o2) -> {
            if(Objects.equals(o1.x, o2.x)) {
                return o1.y - o2.y;
            }

            return o1.x - o2.x;
        });

        int from = list.get(0).y;
        int to = list.get(0).x;

        int ret = 1;
        for(int i = 1; i < N; i++) {
            if(to > list.get(i).y) continue;
            from = list.get(i).y;
            to = list.get(i).x;
            ret++;
        }

        bw.write(ret + "\n");

        bw.flush();
        bw.close();
    }
}
