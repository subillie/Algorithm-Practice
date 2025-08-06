// 1954 달팽이 숫자
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class d2_1954 {
    public static void main(String[] args) throws IOException {  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.valueOf(br.readLine());
        for (int t = 1; t <= T; t++) {
            int N = Integer.valueOf(br.readLine());
            int direction = 0;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            int[][] mat = new int[N][N];

            int x = 0, y = 0;  // 시작 인덱스
            for (int i = 1; i <= N * N; i++) { 
                mat[y][x] = i;
                int nx = x + dx[direction];
                int ny = y + dy[direction];
                // 벽에 부딪히거나 이미 채워진 곳이면 방향 전환
                if (!(0 <= nx && nx < N && 0 <= ny && ny < N) || mat[ny][nx] != 0) {
                    direction = (direction + 1) % 4;
                    nx = x + dx[direction];
                    ny = y + dy[direction];
                }
                x = nx;
                y = ny;
            }
            // 출력
            sb.append("#").append(t).append("\n");
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    sb.append(String.valueOf(mat[i][j])).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}