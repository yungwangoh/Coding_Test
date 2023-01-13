package 구현;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String[] strings = str.split("\\*");
        String pre = strings[0];
        String end = strings[1];

        for(int i = 0; i < N; i++) {
            String s = br.readLine();

            if(strings[0].length() + strings[1].length() > s.length()) {
                bw.write("NE");
            } else {
                // startWith 시작 문자열 비교
                // endWith 끝 문자열 비교
                // subString 으로 문자열 슬라이싱해서 하기 까다로울 때 사용.
                if(s.startsWith(pre) && s.endsWith(end)) {
                    bw.write("DA");
                } else {
                    bw.write("NE");
                }
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
    }
}
