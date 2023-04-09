package 완전탐색_백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class F {

    static int max = Integer.MIN_VALUE;
    static List<Integer> num = new ArrayList<>();
    static List<Character> op = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        String s = br.readLine();
        for(int i = 0; i < N; i++) {
            char c = s.charAt(i);

            if(c >= '0' && c <= '9') {
                num.add(c - '0');
            } else {
                op.add(c);
            }
        }

        dfs(0, num.get(0));

        bw.write(max + "\n");

        bw.flush();
        bw.close();
    }
    static int oper(char a, int b, int c) {
        int ret = 0;

        if(a == '+') ret = b + c;
        if(a == '*') ret = b * c;
        if(a == '-') ret = b - c;

        return ret;
    }
    static void dfs(int here, int _num) {
        System.out.println("here : " + here + ", _num : " + _num);
        if(here == num.size() - 1) {
            max = Math.max(max, _num);
            return;
        }

        dfs(here + 1, oper(op.get(here), _num, num.get(here + 1)));

        if(here + 2 <= num.size() - 1) {
            int temp = oper(op.get(here + 1), num.get(here + 1), num.get(here + 2));
            dfs(here + 2, oper(op.get(here), _num, temp));
        }
    }
}
