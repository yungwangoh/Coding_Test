package 구현;

import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int N = Integer.parseInt(s);

        int[] alphabet = new int[26];

        for(int i = 0; i < N; i++) {
            String name = br.readLine();

            alphabet[name.charAt(0) - 'a']++;
        }

        StringBuilder tmp = new StringBuilder();
        for(int i = 0; i < alphabet.length; i++) {
            if(alphabet[i] >= 5) {
                tmp.append((char) (i + 'a'));
            }
        }

        if(!tmp.toString().toString().isEmpty()) {
            bw.write(tmp.toString().toString());
        } else {
            bw.write("PREDAJA");
        }

        bw.flush();
        bw.close();
    }
}
