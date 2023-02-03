package BFS_DFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] arr = new char[N][M];
        int[][] visit = new int[200][200];

        for(int i = 0; i < N ; i++) {
            String s = br.readLine();

            for(int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < N; i++) {
            Arrays.fill(visit[i], -1);

            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 'c') {
                    visit[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visit[i][j] == 0) {
                    int cnt = 1;
                    while (visit[i][j + 1] == -1) {
                        visit[i][j + 1] = cnt++;
                        j++;

                        if(j > M) break;
                    }
                }
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                sb.append(visit[i][j] + " ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}
