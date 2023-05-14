package 단계별로_풀기;

import java.io.*;
import java.util.*;

public class A {
    static int[] brr;
    static Map<Integer, Integer> map = new HashMap<>();
    static Set<Integer> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        brr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            set.add(num);
            brr[i] = num;
        }

        Object[] objects = set.toArray();
        Arrays.sort(objects);

        for(int i = 0; i < objects.length; i++) {
            if(!map.containsKey((Integer) objects[i])) map.put((Integer) objects[i], i);
        }

        for(int i = 0; i < N; i++) {
            bw.write(map.get(brr[i]) + " ");
        }

        bw.flush();
        bw.close();
    }
}
