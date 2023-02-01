package BFS_DFS;

import 구현.I;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<Integer, Integer> map = new LinkedHashMap<>();

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int k = Integer.parseInt(st1.nextToken());

            if(map.containsKey(k)) {
                map.put(k, map.get(k) + 1);
            } else {
                map.put(k, 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Integer.compare(map.get(o2), map.get(o1)));

        for(Integer tmp : list) {
            int k = map.get(tmp);

            for(int i = 0; i < k; i++) {
                sb.append(tmp + " ");
            }
        }

        System.out.println(sb);
    }
}
