package 완전탐색_백트래킹;

import BFS_DFS.Pair;
import 구현.I;

import java.io.*;
import java.util.*;

public class A {

    static int[][] arr;
    static boolean[][] visited;
    static List<Pair> chickenList = new ArrayList<>();
    static List<Pair> homeList = new ArrayList<>();
    static int min = 9999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];


        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j =0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] == 1) homeList.add(new Pair(i,j));
                if(arr[i][j] == 2) chickenList.add(new Pair(i,j));
            }
        }

        combination(-1, new LinkedList<>(), M);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
    static void calculate(LinkedList<Pair> list) {

        int sum = 0;
        for(var a : homeList) {
            int m = 9999;

            for(var b : list) {
               int s = Math.abs(a.first() - b.first()) + Math.abs(a.second() - b.second());
               m = Math.min(s, m);
            }

            sum += m;
        }

        min = Math.min(sum, min);
    }
    static void combination(int start, LinkedList<Pair> list, int M) {
        if(list.size() == M) {
            calculate(list);
            return;
        }

        for(int i = start + 1; i < chickenList.size(); i++) {
            list.add(chickenList.get(i));
            combination(i, list, M);
            list.removeLast();
        }
    }
}
