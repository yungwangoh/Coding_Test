package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class M {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String s = br.readLine();
        int N = Integer.parseInt(s);

        int cnt = 0;
        for(int i = 0; i < N; i++) {

            String line = br.readLine();

            for(int j = 0; j < line.length(); j++) {
                if (!stack.empty() && (stack.peek() == line.charAt(j))) {
                    stack.pop();
                } else {
                    stack.push(line.charAt(j));
                }
            }

            if(stack.empty()) {
                cnt++;
            }

            stack.clear();
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }
}
