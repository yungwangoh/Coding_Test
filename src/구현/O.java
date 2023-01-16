package 구현;

import java.util.Scanner;

public class O {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            int go = go(sc.nextInt());

            System.out.println(go);
        }
    }

    static int go(int N) {
        long cnt = 1;
        int ret = 1;
        while (true) {
            if(cnt % N == 0) {
                break;
            } else {
                cnt = (cnt * 10) + 1;
                cnt %= N;
                ret++;
            }
        }

        return ret;
    }
}
