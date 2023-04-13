package 구현;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class M {

    static int ret = 0;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            stack.clear();
            String s = br.readLine();

            for(int j = 0; j < s.length(); j++) {
                if(!stack.empty()) {
                    if(stack.peek() == s.charAt(j)) {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(j));
                    }
                } else {
                    stack.push(s.charAt(j));
                }
            }

            if(stack.empty()) {
                ret++;
            }
        }

        bw.write(ret + "\n");

        bw.flush();
        bw.close();
    }
}
