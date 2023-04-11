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

        int M = (int) Math.pow(2, N) - 1;

        arr = new int[1100];

        lists = new List[100];
        for(int i = 0; i < 100; i++) {
            lists[i] = new ArrayList<>();
        }

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st1.nextToken());
        }

        go(0, M, 1);
        for(int i = 1; i <= N; i++) {
            for(var a : lists[i]) {
                bw.write(a + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void go(int start, int end, int level) {

        if(start > end) return;
        if(start == end) {
            lists[level].add(arr[start]);
            return;
        }

        int mid = (start + end) / 2;
        lists[level].add(arr[mid]);
        go(start, mid - 1, level + 1);
        go(mid + 1, end, level + 1);
    }
}
