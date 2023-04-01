package BFS_DFS;

import java.io.*;
import java.util.*;

public class T {

    static int[] arr = new int[1000004];
    static int[] ret = new int[1000004];
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        Arrays.fill(arr, 0);
        Arrays.fill(ret, -1);
        StringTokenizer st1 = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());

            while (!stack.empty() && arr[stack.peek()] < arr[i]) {
                ret[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }

        for(int i = 0; i < N; i++) {
            bw.write(ret[i] + " ");
        }

        bw.flush();
        bw.close();
    }
}
