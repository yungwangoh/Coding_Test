package 구현;

import java.io.*;

public class K {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[200];
        int flag = 0;
        char mid = 0;
        String str = "";

        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
        }

        for(int i = 'Z'; i >= 'A'; i--) {
            if(arr[i] > 0) {
                if((arr[i] & 1) == 1) {
                    mid = (char) i;
                    flag++;
                    arr[i]--;
                }
                if(flag == 2) break;

                for(int j = 0; j < arr[i]; j += 2) {
                    str = (char) i + str;
                    str += (char) i;
                }
            }
        }

        StringBuilder sb = new StringBuilder(str);
        String res = str;
        if(mid > 0) {
            res = sb.insert(str.length() / 2, mid).toString();
        }
        if(flag == 2) {
            bw.write("I'm Sorry Hansoo\n");
        } else {
            bw.write(res);
        }
        bw.flush();
        bw.close();
    }
}
