package 비트마스킹;

import java.io.*;

public class M {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        str = str.replaceAll("pi|ka|chu", "");

        if(str.equals("")) bw.write("YES");
        else bw.write("NO");

        bw.flush();
        bw.close();
    }
}
