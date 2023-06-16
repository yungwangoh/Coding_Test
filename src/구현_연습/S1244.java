package 구현_연습;

import BFS_DFS.Pair;

import java.io.*;
import java.util.*;

public class S1244 {

    static boolean[] arr = new boolean[101];
    static List<Pair> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            int i1 = Integer.parseInt(st.nextToken());

            if(i1 == 1) arr[i] = true;
        }

        int M = Integer.parseInt(br.readLine());

        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st1.nextToken());
            int num = Integer.parseInt(st1.nextToken());
            list.add(new Pair(s, num));
        }

        for(int i = 0; i < list.size(); i++) {
            Pair pair = list.get(i);

            if(pair.first() == 1) {
                men(pair.second(), N);
            } else {
                women(pair.second(), N);
            }
        }

        for(int i = 1; i <= N; i++) {

            if(arr[i]) {
                bw.write(1 + " ");
            } else {
                bw.write(0 + " ");
            }

            if(i % 20 == 0) bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
    static void women(int num, int N) {

        arr[num] = !arr[num];

        for(int i = 1; arr[num - i] == arr[num + i]; i++) {
            int left = num - i;
            int right = num + i;

            System.out.println(left + " " + right);

            if(left < 1 || right >= N) break;

            arr[left] = !arr[left];
            arr[right] = !arr[right];
        }
    }
    static void men(int num, int N) {

        for(int i = 1; i <= N; i++) {
            if(i % num == 0) {
                arr[i] = !arr[i];
            }
        }
    }
}
