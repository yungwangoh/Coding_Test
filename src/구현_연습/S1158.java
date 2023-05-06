package 구현_연습;

import java.io.*;
import java.util.*;

public class S1158 {

    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= N; i++) {
            queue.add(i);
        }

        while (!queue.isEmpty()) {
            for(int i = 0; i < M - 1; i++) {
                if(!queue.isEmpty()) {
                    int n = queue.poll();
                    queue.add(n);
                } else {
                    list.add(queue.poll());
                }
            }
            list.add(queue.poll());
        }

        bw.write("<");
        for(int i = 0; i < list.size(); i++) {
            bw.write(String.valueOf(list.get(i)));

            if(i != list.size() - 1) bw.write(", ");
        }
        bw.write(">");

        bw.flush();
        bw.close();
    }
}
