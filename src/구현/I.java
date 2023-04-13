package 구현;

import java.io.*;
import java.util.*;

public class I {
    static Map<Integer, String> map = new HashMap<>();
    static Map<String, Integer> map2 = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= N; i++) {
            String s = br.readLine();
            map.put(i, s);
            map2.put(s, i);
        }

        for(int i = 0; i < M; i++) {
            String s = br.readLine();

            if(check(s)) {
                bw.write(map.get(Integer.parseInt(s)) + "\n");
            } else {
                bw.write(map2.get(s) + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
    static boolean check(String s) {
        try {
            Integer.parseInt(s);

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
