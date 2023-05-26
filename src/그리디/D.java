package 그리디;

import java.io.*;
import java.util.*;

public class D {

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

        list.sort(Comparator.comparing(o -> o.y));

        int sum = 0;
        for(var a : list) {
            if(sum < a.y) {
                sum = a.y + a.x;
            } else {
                sum += a.x;
            }
        }

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }
}
