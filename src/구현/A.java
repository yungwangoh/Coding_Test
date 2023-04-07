package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class A {

    static int[] arr = new int[9];
    static boolean[] visit = new boolean[9];
    static LinkedList<Integer> list = new LinkedList<>();

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
       }

       dfs(0, 0);

    }
    static void solve() {
        Collections.sort(list);

        for(int i = 0; i < 7; i++) {
            System.out.println(list.get(i));
        }

        System.exit(0);
    }
    static void dfs(int sum, int cnt) {

        if(cnt == 7 && sum == 100) {
            solve();
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(visit[i]) continue;

            visit[i] = true;
            list.add(arr[i]);
            dfs(sum + arr[i], cnt + 1);
            visit[i] = false;
            list.removeLast();
        }
    }
}
