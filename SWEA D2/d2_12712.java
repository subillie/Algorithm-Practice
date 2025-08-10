// 12712 파리퇴치3
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class d2_12712 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      // 입력
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");
      int N = Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      int[][] mat = new int[N][N];
      for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine(), " ");
        for (int j = 0; j < N; j++) {
          mat[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      // Logic
      int max_count = 0;
      int count_t, count_x;
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          if (i == 0 && (j == 0 || j == N - 1) ||
              i == N - 1 && (j == 0 || j == N - 1)) {
            continue;
          }
          count_t = mat[i][j];
          count_x = mat[i][j];
          for (int k = 1; k < M; k++) {
            if (j - k >= 0)
              count_t += mat[i][j - k];  // + 아래
            if (j + k < N)
              count_t += mat[i][j + k];  // + 위

            if (i - k >= 0) {
              count_t += mat[i - k][j];  // + 왼쪽
              if (j - k >= 0)
                count_x += mat[i - k][j - k];  // x 왼쪽 아래
              if (j + k < N)
                count_x += mat[i - k][j + k];  // x 왼쪽 위
            }

            if (i + k < N) {
              count_t += mat[i + k][j];  // + 오른쪽
              if (j - k >= 0)
                count_x += mat[i + k][j - k];  // x 오른쪽 아래
              if (j + k < N)
                count_x += mat[i + k][j + k];  // x 오른쪽 위
            }
          }
          max_count = Math.max(max_count, count_t);
          max_count = Math.max(max_count, count_x);
        }
      }

      // 출력
      sb.append("#").append(t).append(" ").append(max_count).append("\n");
    }

    System.out.println(sb.toString());
  }
}