package 구현;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class I {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] split = s.split(" ");
        int N = Integer.parseInt(split[0]);
        int M = Integer.parseInt(split[1]);

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map1 = new HashMap<>();

        for(int i = 0; i < N; i++) {
            String s1 = br.readLine();
            map.put(i + 1, s1);
            map1.put(s1, i + 1);
        }

        for(int i = 0; i < M; i++) {
            String line = br.readLine();

            if(isCheck(line)) {
                String s1 = map.get(Integer.parseInt(line));
                bw.write(s1);
            } else {
                Integer integer = map1.get(line);
                bw.write(integer.toString());
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean isCheck(String str) {
        try {
            Integer.parseInt(str);

            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }
}
