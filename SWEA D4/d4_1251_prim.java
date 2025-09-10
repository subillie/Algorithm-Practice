// 1251 하나로
import java.io.*;
import java.util.*;

public class d4_1251_prim {
    /**
     * 섬(정점)의 좌표를 저장할 클래스
     */
    private static class Island {
        int id, x, y;

        public Island(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }
    }

    /**
     * 터널(간선)의 정보를 저장할 클래스
     */
    private static class Edge implements Comparable<Edge> {
        int to;  // 도착 섬 ID
        long distSquared; // 거리 제곱

        public Edge(int to, long distSquared) {
            this.to = to;
            this.distSquared = distSquared;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.distSquared, o.distSquared);
        }
    }

    /**
     * Prim Algorithm
     *
     * @param N       섬의 개수
     * @param E       환경 부담 세율
     * @param islands 섬의 좌표 배열
     * @return        최종 환경 부담금
     */
    private static long prim(int N, double E, Island[] islands) {
        boolean[] visited = new boolean[N]; // MST에 포함되었는지 여부
        PriorityQueue<Edge> pq = new PriorityQueue<>();

        long cost = 0;
        int count = 0;

        pq.add(new Edge(0, 0));  // 시작점
        
        while (!pq.isEmpty() && count < N) {
            Edge cur = pq.poll();

            // 이미 MST에 포함된 섬이면 무시
            if (visited[cur.to]) {
                continue;
            }

            // MST에 포함시키기
            visited[cur.to] = true;
            cost += cur.distSquared;
            count++;

            // 새로 추가된 섬에서 아직 연결되지 않은 다른 모든 섬으로의 간선을 PQ에 추가
            Island island = islands[cur.to];
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    Island alone = islands[i];
                    long dx = island.x - alone.x;
                    long dy = island.y - alone.y;
                    long distSquared = dx * dx + dy * dy;
                    pq.add(new Edge(alone.id, distSquared));
                }
            }
        }
        return Math.round(cost * E);
    }

    /**
     * Main Function
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            // Input
            int N = Integer.parseInt(br.readLine()); // 섬의 개수
            Island[] islands = new Island[N];
            
            StringTokenizer X = new StringTokenizer(br.readLine(), " ");
            StringTokenizer Y = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {
                int x = Integer.parseInt(X.nextToken());
                int y = Integer.parseInt(Y.nextToken());
                islands[i] = new Island(i, x, y); // 섬의 좌표 배열
            }
            
            double E = Double.parseDouble(br.readLine()); // 환경 부담 세율

            // Output by Prim Algorithm
            sb.append("#").append(t).append(" ").append(prim(N, E, islands)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
