package BFS_DFS;

import 구현.O;

import java.io.*;
import java.util.Map;

public class H {
    static boolean check(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        while (true) {

            String s = br.readLine();
            boolean flag = true;
            int lcnt = 0, vcnt = 0, vowelInclude = 0;

            if(s.equals("end")) break;

            for(int i = 0; i < s.length(); i++) {
                char tmp = s.charAt(i);

                if(check(tmp)) {
                    lcnt++;
                    vcnt = 0;
                    vowelInclude = 1;
                } else {
                    vcnt++;
                    lcnt = 0;
                }

                if(lcnt == 3 || vcnt == 3) flag = false;
            }

            for(int i = 0; i < 26; i++) {
                String tmp = "";
                char ch = (char) (i + 'a');
                tmp = ch + "" + ch;

                if(s.contains(tmp) && !(s.contains("ee") || s.contains("oo"))) {
                    flag = false;
                }
            }

            if(vowelInclude < 1) flag = false;
            if(!flag) {
                bw.write("<" + s + "> is not acceptable.");
            } else {
                bw.write("<" + s + "> is acceptable.");
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
