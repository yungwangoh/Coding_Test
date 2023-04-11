package 완전탐색_백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class M {

    static char[] arr;
    static boolean[] visit;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new char[N];
        visit = new boolean[10];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = st1.nextToken().charAt(0);
        }

        dfs(0, "", N);

        Collections.sort(list);

        bw.write(list.get(list.size() - 1) + "\n");
        bw.write(list.get(0) + "\n");

        bw.flush();
        bw.close();
    }
    static boolean check(char op, int a, int b) {

        if(op == '<') return a < b;
        if(op == '>') return a > b;
        return false;
    }
    static void dfs(int start, String str, int N) {
        System.out.println("start : " + start + ", str : " + str);
        if(str.length() == N + 1) {
            list.add(str);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visit[i]) continue;

            if(start == 0 || check(arr[start - 1], str.charAt(start - 1), i + '0')) {
                visit[i] = true;
                dfs(start + 1, str + i, N);
                visit[i] = false;
            }
        }
    }
}
