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

        for(int i = 1; i < (1 << N); i++) {
            int b = 0; int c = 0; int d = 0; int e = 0; int sum = 0;
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < N; j++) {
                if((i & (1 << j)) > 0) {
                    list.add(j + 1);
                    b += nutrient[j].getMp();
                    c += nutrient[j].getMf();
                    d += nutrient[j].getMs();
                    e += nutrient[j].getMv();
                    sum += nutrient[j].getTotal();
                }
            }

            if(b >= mp && c >= mf && d >= ms && e >= mv) {
                if(ret >= sum) {
                    ret = sum;
                    if(!map.containsKey(ret)) {
                        map.put(ret, new ArrayList<>());
                    }
                    if(map.containsKey(ret)) {
                        map.get(ret).add(list);
                    }
                }
            }
        }

        if(ret == Integer.MAX_VALUE) {
            bw.write("-1\n");
        } else {
            map.get(ret).sort((o1, o2) -> {
                for(int i = 0; i < Math.min(o1.size(), o2.size()); i++) {
                    if(!o1.get(i).equals(o2.get(i))) {
                        return o1.get(i) - o2.get(i);
                    }
                }
                return o1.size() - o2.size();
            });

            bw.write(ret + "\n");
            for(int a : map.get(ret).get(0)) {
                bw.write(a + " ");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
