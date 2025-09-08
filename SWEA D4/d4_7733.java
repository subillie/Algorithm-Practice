// 7733 치즈 도둑
import java.io.*;
import java.util.*;

public class d4_7733 {
    private static int N;
    private static int[][] mat, visited;

    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static class Pos {
        private int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void bfs(int startY, int startX, int count) {
        Deque<Pos> queue = new ArrayDeque<>();
        queue.offerLast(new Pos(startY, startX));
        visited[startY][startX] = count;

        while (!queue.isEmpty()) {
            Pos pos = queue.pollFirst();

            for (int i = 0; i < 4; i++) {
                int ny = pos.y + dy[i];
                int nx = pos.x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N && visited[ny][nx] < 0) {
                    visited[ny][nx] = count;
                    queue.offerLast(new Pos(ny, nx));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            mat = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxCount = 1;
            for (int day = 0; day < 100; day++) {
                visited = new int[N][N];
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (--mat[i][j] > 0) {
                            visited[i][j] = -1;
                        }
                    }
                }

                int count = 0;
                boolean eatenAll = true;
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        if (visited[i][j] < 0) {
                            eatenAll = false;
                            bfs(i, j, ++count);
                        }
                    }
                }
                if (eatenAll) {
                    break;
                }
                maxCount = Math.max(maxCount, count);
            }

            sb.append("#").append(t).append(" ").append(maxCount).append("\n");
        }
        System.out.println(sb.toString());
    }
}
