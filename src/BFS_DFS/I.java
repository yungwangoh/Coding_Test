package BFS_DFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.*;

public class I {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<BigDecimal> list = new ArrayList<>();

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            String str = st1.nextToken();

            String[] strings = str.split("[a-z]");

            for(int j = 0; j < strings.length; j++) {
                if(!strings[j].equals("")) {
                    String string = strings[j];
                    list.add(new BigDecimal(string));
                }
            }
        }

        list.sort(null);

        for(BigDecimal tmp : list) {
            sb.append(tmp + "\n");
        }

        System.out.println(sb);
    }
}
