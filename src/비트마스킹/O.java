package 비트마스킹;

import java.io.*;
import java.util.Stack;

public class O {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int max = 0, cnt = 0;
        int[] arr = new int[200001];

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for(int i = 0; i < N; i++) {
            if(str.charAt(i) == '(') {
                stack.push(i);
            } else if(stack.size() > 0) {
                arr[i] = arr[stack.peek()] = 1;
                stack.pop();
            }
        }

        for(int i = 0; i < N; i++) {
            if(arr[i] > 0) {
                cnt++;
                max = Math.max(max, cnt);
            } else {
                cnt = 0;
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
}
