package 완전탐색_백트래킹;

import com.sun.source.tree.BinaryTree;

import java.io.*;
import java.util.*;

public class M {

    static char[] arr;
    static boolean[] visit = new boolean[10];
    static List<String> str = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        arr = new char[N];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = st1.nextToken().charAt(0);
        }

        dfs(0, "", N);
        Collections.sort(str);
        System.out.println(str.get(str.size() - 1));
        System.out.println(str.get(0));
    }
    static boolean check(int x, int y, char op) {
        if(x < y && op == '<') return true;
        if(x > y && op == '>') return true;
        return false;
    }
    static void dfs(int idx, String num, int N) {

        if(idx == N + 1) {
            str.add(num);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visit[i]) continue;

            if(idx == 0 || check(num.charAt(idx - 1), i + '0', arr[idx - 1])) {
                visit[i] = true;
                dfs(idx + 1, num + i, N);
                visit[i] = false;
            }
        }
    }
}
