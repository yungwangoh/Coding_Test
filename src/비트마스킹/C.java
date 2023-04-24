package 비트마스킹;

import java.io.*;
import java.util.*;

public class C {

    static Map<Integer, List<Integer>> map = new HashMap<>();
    static int[] arr = new int[11];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            List<Integer> list = new ArrayList<>();

            int M = Integer.parseInt(st1.nextToken());
            for(int j = 0; j < M; j++) {
                list.add(Integer.parseInt(st1.nextToken()));
            }

            map.put(i, list);
        }

        
    }
}
