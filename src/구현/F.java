package 구현;

import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        for(int i = 0; i< s.length(); i++) {
            int num = s.charAt(i);

            if(s.charAt(i) != ' ') {
                if(num >= 'A' && num <= 'Z') {
                    num += 13;
                    if(num > 'Z') {
                        num %= 'Z';
                        num += 'A' - 1;
                    }
                } else if(num >= 'a' && num <= 'z') {
                    num += 13;
                    if(num > 'z') {
                        num %= 'z';
                        num += 'a' - 1;
                    }
                }
            }

            sb.append((char) num);
        }

        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }
}
