// 1861 정사각형 방
import java.io.*;
import java.util.*;

public class d4_1861 {
  static int N;
  static int[][] mat;
  static int[][] dp;
  static int[] dx = {1, -1, 0, 0};
  static int[] dy = {0, 0, 1, -1};

  public static int bfs(int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    boolean[][] visited = new boolean[N][N];

    // 초기 상태
    queue.add(new int[]{i, j});
    visited[i][j] = true;
    int count = 0;
    int prev = mat[i][j];

    // BFS
    while (!queue.isEmpty()) {
      int[] current = queue.poll();  // 이동
      int y = current[0];
      int x = current[1];
      count++;

      for (int move = 0; move < 4; move++) {  // 사방 탐색
        int ny = y + dy[move];
        int nx = x + dx[move];
        if (ny >= 0 && ny < N && nx >= 0 && nx < N && 
          !visited[ny][nx] && mat[ny][nx] == prev + 1) {
          queue.add(new int[]{ny, nx});  // 이동 계획에 추가
          visited[ny][nx] = true;  // 방문 표시
          prev++;  // "각 방에 적힌 숫자가 모두 다르다"는 조건이 있으므로
          break;  // 이동 가능하면 즉시 break
        }
      }
    }
    return count;
  }

  public static int dfs(int y, int x) {
    if (dp[y][x] != 0) {  // 이미 계산된 결과가 있으면,
      return dp[y][x];  // 저장된 값을 바로 반환
    }

    dp[y][x] = 1;  // count 초기값은 1(자기 자신)
    for (int move = 0; move < 4; move++) {  // 사방 탐색
      int ny = y + dy[move];
      int nx = x + dx[move];
      if (ny >= 0 && ny < N && nx >= 0 && nx < N && mat[ny][nx] == mat[y][x] + 1) {
        // 기존에 저장된 값 vs 다음 위치에서 시작하는 count + 1(자기 자신) -> 더 큰 값 저장
        dp[y][x] = Math.max(dp[y][x], dfs(ny, nx) + 1);
      }
    }
    // 결과적으로, 현재 위치에서 시작하는 가장 큰 count 반환
    return dp[y][x];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      // Input
      N = Integer.parseInt(br.readLine());
      mat = new int[N][N];
      for (int i = 0; i < N; i++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int j = 0; j < N; j++) {
          mat[i][j] = Integer.parseInt(st.nextToken());
        }
      }

      // Logic
      int maxCount = 0;
      int roomNum = N * N + 1;

      dp = new int[N][N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          // int count = bfs(i, j);
          int count = dfs(i, j);

          if (count > maxCount) {
            maxCount = count;
            roomNum = mat[i][j];
          } else if (count == maxCount) {
            roomNum = Math.min(roomNum, mat[i][j]);
          }
        }
      }

      // Output
      sb.append("#").append(t).append(" ").append(roomNum).append(" ").append(maxCount).append("\n");
    }
    System.out.println(sb.toString());
  }
}