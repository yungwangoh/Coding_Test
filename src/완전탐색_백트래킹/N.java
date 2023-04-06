package 완전탐색_백트래킹;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N {

    static int[] arr;
    static List<Integer>[] lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        lists = new ArrayList[14];
        for(int i = 0; i < 14; i++) lists[i] = new ArrayList<>();

        int num = (int) Math.pow(2, N) - 1;

        arr = new int[10001];
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < num; i++) {
            arr[i] = st1.nextToken().charAt(0) - '0';
        }

        go(0, num, 1);

        for(int i = 1; i <= N; i++) {
            for(var a : lists[i]) {
                bw.write(a + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void go(int s, int e, int level) {
        if(s > e) {
            return;
        }
        if(s == e) {
            lists[level].add(arr[s]);
            return;
        }

        int mid = (s + e) / 2;
        lists[level].add(arr[mid]);
        go(s, mid - 1, level + 1);
        go(mid + 1, e, level + 1);
    }
}
