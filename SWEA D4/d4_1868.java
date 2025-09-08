// 1868 파핑파핑 지뢰찾기
import java.io.*;
import java.util.*;

public class d4_1868 {
    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    
    private static final int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    private static final int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
    
    private static class Pos {
        private int y, x;
        public Pos(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    private static void init(char[][] inputArr) {
        board = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int count = 0;
                for (int k = 0; k < 8; k++) {
                    int ny = i + dy[k];
                    int nx = j + dx[k];
                    if (0 <= ny && ny < N && 0 <= nx && nx < N && inputArr[ny][nx] == '*') {
                        count++;
                        board[ny][nx] = -1;
                        visited[ny][nx] = true;
                    }
                }
                board[i][j] = count;
            }
        }
    }

    private static int countZeroChunk() {
        Queue<Pos> queue = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && board[i][j] == 0) {
                    queue.offer(new Pos(i, j));
                    visited[i][j] = true;
                    count++;
            
                    while (!queue.isEmpty()) {
                        Pos cur = queue.poll();
            
                        for (int k = 0; k < 8; k++) {
                            int ny = cur.y + dy[k];
                            int nx = cur.x + dx[k];
                            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                                visited[ny][nx] = true;
                                if (board[ny][nx] == 0) {
                                    queue.add(new Pos(ny, nx));
                                }
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // Input
            N = Integer.parseInt(br.readLine());

            char[][] inputArr = new char[N][N];
            for (int i = 0; i < N; i++) {
                inputArr[i] = br.readLine().toCharArray();
            }

            // Logic
            init(inputArr);
            int count = countZeroChunk();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        count++;
                    }
                }
            }

            // Output
            sb.append("#").append(t).append(" ").append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
