// 1868 파핑파핑 지뢰찾기
import java.io.*;

public class d4_1868 {
    private static int N;
    private static int[][] board;
    private static boolean[][] visited;
    
    private static final int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};
    private static final int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};

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
                if (board[i][j] != -1) {
                    board[i][j] = count;
                }
            }
        }
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for (int k = 0; k < 8; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];
            if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (board[ny][nx] == 0) {
                    dfs(ny, nx);
                }
            }
        }
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
            
            init(inputArr);

            // 0 덩어리 개수 카운트
            int count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] == 0) {
                        count++;
                        dfs(i, j);
                    }
                }
            }

            // 0 외 개수 카운트
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
