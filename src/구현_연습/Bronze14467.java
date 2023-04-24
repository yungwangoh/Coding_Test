package 구현_연습;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Bronze14467 {

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int ret = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            int lr = Integer.parseInt(st.nextToken());

            if(map.containsKey(num)) {
                if(map.get(num) == 1 && lr == 0) {
                    map.put(num, lr);
                    ret++;
                } else if(map.get(num) == 0 && lr == 1) {
                    map.put(num, lr);
                    ret++;
                }
            } else {
                map.put(num, lr);
            }
        }

        bw.write(ret + "\n");
        bw.flush();
        bw.close();
    }
}
