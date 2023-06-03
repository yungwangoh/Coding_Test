package 구현_연습;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class G1759 {

    static char[] arr;
    static boolean[] visit;
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new char[M];
        visit = new boolean[M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = st1.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        combi(-1, M, N, "");

        for(var a : list) {
            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
    }
    static boolean check(String str) {

        int moum = 0;
        int jaum = 0;

        for(int i = 0; i < str.length(); i++) {
            if('a' == str.charAt(i) || 'e' == str.charAt(i) || 'i' == str.charAt(i)
                    || 'o' == str.charAt(i) || 'u' == str.charAt(i)) {

                moum++;
            } else {
                jaum++;
            }
        }

        if(moum >= 1 && jaum >= 2) {
            return true;
        } else {
            return false;
        }
    }
    static void combi(int level, int n, int r, String str) {

        if(str.length() == r && check(str)) {
            list.add(str);
            return;
        }

        for(int i = level + 1; i < n; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            combi(i, n, r, str + arr[i]);
            visit[i] = false;
        }
    }
}
