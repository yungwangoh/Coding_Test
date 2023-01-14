package 구현;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class J {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(s);

        for(int i = 0; i < N; i++) {
            int sum = 1;
            Map<String, Integer> map = new HashMap<>();

            String s1 = br.readLine();
            int num = Integer.parseInt(s1);

            for(int j = 0; j < num; j++) {
                String s2 = br.readLine();
                String[] s3 = s2.split(" ");

                if(map.containsKey(s3[1])) {
                    map.put(s3[1], map.get(s3[1]) + 1);
                } else {
                    map.put(s3[1], 1);
                }
            }

            for(int tmp : map.values()) {
                sum *= (tmp + 1);
            }

            bw.write((sum - 1) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
