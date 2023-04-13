package 구현;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class J {

    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            int sum = 1;
            map.clear();
            int M = Integer.parseInt(br.readLine());

            for(int j = 0; j < M; j++) {
                String[] s = br.readLine().split(" ");

                if(map.containsKey(s[1]))
                    map.put(s[1], map.get(s[1]) + 1);
                else
                    map.put(s[1], 1);
            }

            for(var tmp : map.values()) {
                sum *= (tmp + 1);
            }

            bw.write((sum - 1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
