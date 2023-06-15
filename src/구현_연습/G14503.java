package 구현_연습;

import java.io.*;
import java.util.StringTokenizer;

public class G14503 {

    // 동 남 서 북
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] arr;
    static boolean[][] visit;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visit = new boolean[N][M];

        StringTokenizer st1 = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st1.nextToken());
        int c = Integer.parseInt(st1.nextToken());
        int num = Integer.parseInt(st1.nextToken());

        for(int i = 0; i < N; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st2.nextToken());
            }
        }

        visit[r][c] = true;
        solution(r, c, num, N, M, 1);
    }
    static void solution(int y, int x, int num, int N, int M, int sum) {

        for(int i = 0; i < 4; i++) {
            int dn = (num + 3 - i) % 4;
            int nx = x + dx[dn];
            int ny = y + dy[dn];

            if(nx < 0 || ny < 0 || nx >= M || ny >= N || arr[ny][nx] == 1 || visit[ny][nx]) continue;

            if(arr[ny][nx] == 0) {
                visit[ny][nx] = true;
                solution(ny, nx, dn, N, M, sum + 1);
            }
        }

        int backIdx = num + 2 < 4 ? num + 2: num - 2;
        int backY = y + dy[backIdx];
        int backX = x + dx[backIdx];

        if(backY >= 0 && backY <= N && backX >= 0 && backX <= M) {
            if(arr[backY][backX] == 0) {
                solution(backY, backX, num, N, M, sum);
            } else {
                System.out.println(sum);
                System.exit(0);
            }
        }
    }

}
