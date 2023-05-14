package 그리디;

import java.io.*;
import java.util.Stack;

public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        String str = br.readLine();
        String boom = br.readLine();

        for(int i = 0; i < str.length(); i++) {
            boolean flag = false;
            StringBuilder sb = new StringBuilder();

            stack.push(str.charAt(i));

            for(int j = boom.length() - 1; j >= 0; j--) {
                if(!stack.empty() && (stack.peek() == boom.charAt(j))) {
                    sb.append(stack.pop());
                } else {
                    flag = true;
                    break;
                }
            }
            if(flag) {
                String rev = sb.reverse().toString();
                for(int j = 0; j < rev.length(); j++) {
                    stack.push(sb.charAt(j));
                }
            }
        }

        StringBuilder sb1 = new StringBuilder();
        while (!stack.empty()) {
            sb1.append(stack.pop());
        }

        String s = sb1.reverse().toString();
        if(s.equals("")) {
            bw.write("FRULA\n");
        } else {
            bw.write(s + "\n");
        }

        bw.flush();
        bw.close();
    }
}
