package 완전탐색_백트래킹;

import BFS_DFS.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class A {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1 ,0, 1};
    static int min = Integer.MAX_VALUE;
    static List<Pair> home = new ArrayList<>();
    static List<Pair> chicken = new ArrayList<>();
    static boolean[][] visit;
    static int [][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visit = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st1.nextToken());

                if(arr[i][j] == 1) {
                    home.add(new Pair(i, j));
                }

                if(arr[i][j] == 2) {
                    chicken.add(new Pair(i, j));
                }
            }
        }

        combi(-1, chicken.size(), 0, M, new LinkedList<>());

        bw.write(min + "\n");

        bw.flush();
        bw.close();
    }
    static void calculate(LinkedList<Pair> chicken) {

        int sum = 0;
        for(var a : home) {
            int min = Integer.MAX_VALUE;

            for(var b : chicken) {
                int s = Math.abs(a.first() - b.first()) + Math.abs(a.second() - b.second());

                min = Math.min(s, min);
            }

            sum += min;
        }

        min = Math.min(min, sum);
    }
    static void combi(int start, int n, int r, int M, LinkedList<Pair> list) {

        if(r == M) {
            calculate(list);
            return;
        }

        for(int i = start + 1; i < n; i++) {
            list.add(chicken.get(i));
            combi(i, n, r + 1, M, list);
            list.removeLast();
        }
    }
}
