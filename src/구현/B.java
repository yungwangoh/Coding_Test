package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B {

    public static void main(String[] args) throws IOException {
        int[] alphabet = new int[26];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++) {
            alphabet[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            System.out.print(alphabet[i]);
            System.out.print(" ");
        }
    }
}
