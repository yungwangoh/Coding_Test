package BFS_DFS;

import java.io.*;
import java.util.Stack;

public class O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            if(s.equals(".")) break;

            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '(' || s.charAt(i) == '[') {
                    stack.push(s.charAt(i));
                } else if(!stack.empty() && ((s.charAt(i) == ')' && stack.peek() == '(') || ((s.charAt(i) == ']' && stack.peek() == '[')))){
                    stack.pop();
                } else if(s.charAt(i) == '(' || s.charAt(i) == ')' || s.charAt(i) == '[' || s.charAt(i) == ']'){
                    stack.push(s.charAt(i));
                }
            }

            if(stack.empty()) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
