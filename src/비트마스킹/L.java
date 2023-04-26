package 비트마스킹;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class L {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            Deque<Integer> deque = new LinkedList<>();

            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String str = br.readLine();

            String string = str.replaceAll("[^0-9]", " ");
            StringTokenizer st = new StringTokenizer(string);
            for(int j = 0; j < n; j++) {
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            boolean cnt = false; boolean error = false;
            for(int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == 'R') {
                    cnt = !cnt;
                } else if(s.charAt(k) == 'D'){
                    if(deque.isEmpty()) {
                        error = true;
                        break;
                    }
                    if (!cnt) {
                        deque.removeFirst();
                    } else {
                        deque.removeLast();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append('[');
            if(!error) {
                if (!cnt) {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeFirst());
                        sb.append(',');
                    }
                } else {
                    while (!deque.isEmpty()) {
                        sb.append(deque.removeLast());
                        sb.append(',');
                    }
                }
                if (sb.charAt(sb.length() - 1) == ',') sb.deleteCharAt(sb.length() - 1);
            }
            sb.append(']');

            if(error) {
                bw.write("error\n");
            } else {
                bw.write(sb + "\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
