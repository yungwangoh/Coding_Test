package 구현;

import java.io.*;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] split = br.readLine().split("\\*");

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(split[0].length() + split[1].length() > s.length()) {
                bw.write("NE\n");
                continue;
            }

            if(s.startsWith(split[0]) && s.endsWith(split[1])) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
