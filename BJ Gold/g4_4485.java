// 4485 녹색 옷 입은 애가 젤다지?
import java.io.*;
import java.util.*;

public class g4_4485 {
    private static int N;
    private static int[][] mat;
    private static final int[] dy = {1, -1, 0, 0};
    private static final int[] dx = {0, 0, 1, -1};

    private static class Pos implements Comparable<Pos> {
        private int y, x, cost;
        
        public Pos(int y, int x, int cost) {
            this.y = y;
            this.x = x;
            this.cost = cost;
        }

        @Override
        public int compareTo(Pos o) {
            return this.cost - o.cost;
        }
    }

    private static int dijkstra() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        int[][] table = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(table[i], Integer.MAX_VALUE);
        }

        pq.add(new Pos(0, 0, mat[0][0]));
        table[0][0] = mat[0][0];

        while (!pq.isEmpty()) {
            Pos cur = pq.poll();
            if (cur.cost > table[cur.y][cur.x]) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    int newCost = cur.cost + mat[ny][nx];
                    if (newCost < table[ny][nx]) {
                        table[ny][nx] = newCost;
                        pq.add(new Pos(ny, nx, newCost));
                    }
                }
            }
        }

        return table[N - 1][N - 1];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = 0;
        while (true) {
            N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }

            mat = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    mat[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("Problem ").append(++t).append(": ").append(dijkstra()).append("\n");
        }

        System.out.println(sb.toString());
    }
}