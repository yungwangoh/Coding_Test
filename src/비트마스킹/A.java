package 비트마스킹;

import java.io.*;
import java.util.*;

class Nutrient {
    private int mp, mf, ms, mv, total;

    public Nutrient(int mp, int mf, int ms, int mv, int total) {
        this.mp = mp;
        this.mf = mf;
        this.ms = ms;
        this.mv = mv;
        this.total = total;
    }

    public int getMp() {
        return mp;
    }

    public int getMf() {
        return mf;
    }

    public int getMs() {
        return ms;
    }

    public int getMv() {
        return mv;
    }

    public int getTotal() {
        return total;
    }
}
public class A {
    static int ret = Integer.MAX_VALUE;
    static Map<Integer, List<List<Integer>>> map = new HashMap<>();
    static int mp = 0, mf = 0, ms = 0, mv = 0;
    static Nutrient[] nutrient;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        mp = Integer.parseInt(st1.nextToken());
        mf = Integer.parseInt(st1.nextToken());
        ms = Integer.parseInt(st1.nextToken());
        mv = Integer.parseInt(st1.nextToken());

        nutrient = new Nutrient[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st2.nextToken());
            int f = Integer.parseInt(st2.nextToken());
            int s = Integer.parseInt(st2.nextToken());
            int v = Integer.parseInt(st2.nextToken());
            int total = Integer.parseInt(st2.nextToken());

            nutrient[i] = new Nutrient(p, f, s, v, total);
        }


    }
    static void dfs() {

    }
}
