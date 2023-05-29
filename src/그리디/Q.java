package 그리디;

import java.io.*;
import java.util.*;

public class Q {

    static List<Pair<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());

            list.add(new Pair<>(start, end));
        }

        list.sort(Comparator.comparing(o -> o.y));

        int idx = 0;
        int ret = 0;
        int r = 0;
        for(var a : list) {
            if(a.x <= idx) continue;
            if(idx < a.y) {
                ret = (a.x - a.y) / L + (((a.x - a.y) % L) != 0 ? 1 : 0);
                idx = a.y + ret * L;
            } else {
                ret = (a.x - idx) / L + (((a.x - idx) % L) != 0 ? 1 : 0);
                idx = idx + ret * L;
            }
            r += ret;
        }

        bw.write(r + "\n");

        bw.flush();
        bw.close();
    }
}
