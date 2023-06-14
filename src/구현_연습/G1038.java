package 구현_연습;

import java.io.*;

public class G1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int i = 0;
        int check = 0;
        boolean flag = false;
        while (i < Integer.MAX_VALUE) {

            if(check == N) {
                flag = true;
                break;
            }

            boolean condition = condition(String.valueOf(i));

            if(!condition) {
                check++;
            }
            i++;
        }

        if(flag) System.out.println(i);
        else System.out.println("-1");
    }
    static boolean condition(String tmp) {

        int ch = tmp.charAt(0) - '0';
        boolean flag = false;
        for(int i = 1; i < tmp.length(); i++) {
            if (ch <= (tmp.charAt(i) - '0')) {
                flag = true;
                break;
            }
            ch = tmp.charAt(i) - '0';
        }

        return flag;
    }
}
