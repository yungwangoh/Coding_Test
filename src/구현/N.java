package 구현;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class N {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] split = s.split(" ");
        long N = Long.parseLong(split[0]);
        long M = Long.parseLong(split[1]);
        long K = Long.parseLong(split[2]);

        long ret = go(N, M, K);

        bw.write(Long.toString(ret));
        bw.flush();
        bw.close();
    }

    static long go(long N, long M, long K) {
        if(M == 1) return N % K;
        long ret = go(N, M / 2, K);
        ret = (ret * ret) % K;
        if(M % 2 == 1) ret = (ret * N) % K;
        return ret;
    }
}
