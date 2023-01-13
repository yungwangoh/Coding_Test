package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class C {

    static int[] count = new int[101];
    static int A, B, C;
    static int a, b;

    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        int sum = 0;

        A = s.nextInt();
        B = s.nextInt();
        C = s.nextInt();

        for(int i = 0; i <3; i++) {
            a = s.nextInt();
            b = s.nextInt();

            for(int j = a; j < b; j++) {
                count[j]++;
            }
        }

        for(int i = 0; i < count.length; i++) {
            if(count[i] == 1) sum += A;
            else if (count[i] == 2) {
                sum += B * 2;
            } else if(count[i] == 3) {
                sum += C * 3;
            }
        }

        System.out.println(sum);
    }
}
