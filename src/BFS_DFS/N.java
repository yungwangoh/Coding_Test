package BFS_DFS;

import java.io.*;
import java.util.Stack;

public class N {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < N; i++) {
            String str = br.readLine();

            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == '(') {
                    stack.push(str.charAt(j));
                } else if(!stack.empty() && str.charAt(j) == ')' && stack.peek() == '('){
                    stack.pop();
                } else {
                    stack.push(str.charAt(j));
                }
            }

            if(!stack.empty()) {
                bw.write("NO" + "\n");
            } else {
                bw.write("YES" + "\n");
            }

            stack.clear();
        }

        bw.flush();
        bw.close();
    }
}
