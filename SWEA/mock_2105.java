// 2105 디저트 카페
import java.io.*;
import java.util.*;

public class mock_2105 {
    private static int N, start_y, start_x, maxCount;
    private static int[][] dessert;
    private static boolean[] eaten;

    private static final int[] dy = {1, 1, -1, -1};
    private static final int[] dx = {1, -1, -1, 1};

    private static void dfs(int y, int x, int dir, int count) {
        // 방문 처리
        eaten[dessert[y][x]] = true;

        // 현재 방향(dir)으로 직진하거나, 다음 방향(dir + 1)으로 꺾는 경우
        for (int nextDir = dir; (nextDir <= dir + 1 && nextDir < 4); nextDir++) {
            int ny = y + dy[nextDir];
            int nx = x + dx[nextDir];

            // 다음 이동할 좌표가 시작점이고, 사각형을 그려 온 경우
            if (ny == start_y && nx == start_x && nextDir >= 3) {
                maxCount = Math.max(maxCount, count + 1);
            }

            // 다음 좌표가 배열 범위 내고, 아직 먹지 않은 디저트인 경우
            if (0 <= ny && ny < N && 0 <= nx && nx < N && !eaten[dessert[ny][nx]]) {
                dfs(ny, nx, nextDir, count + 1);  // 가보자고
            }
        }

        // 백트래킹
        eaten[dessert[y][x]] = false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // Input
            N = Integer.parseInt(br.readLine());
            dessert = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    dessert[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // Logic: DFS
            maxCount = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!((i == 0 || i == N - 1) && (j == 0 || j == N - 1))) {
                        eaten = new boolean[101];
                        start_y = i;
                        start_x = j;
                        dfs(i, j, 0, 0);
                    }
                }
            }

            // Output
            sb.append("#").append(t).append(" ").append(maxCount).append("\n");
        }

        System.out.println(sb.toString());
    }
}
