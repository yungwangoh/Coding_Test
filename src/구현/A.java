package 구현;

import java.io.*;
import java.util.*;

public class A {

    static int sum = 0;
    static int[] arr = new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);

        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                if(sum - arr[i] - arr[j] == 100) {
                    for(int k = 0; k < 9; k++) {
                        if(k == i || k == j) continue;

                        System.out.println(arr[k]);
                    }
                    System.exit(0);
                }
            }
        }
    }
}
