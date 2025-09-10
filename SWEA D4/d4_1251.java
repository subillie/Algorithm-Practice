// 1251 하나로
import java.io.*;
import java.util.*;

public class d4_1251 {
    /**
     * 서로소 집합의 구현과 연산에 사용될 클래스
     */
    private static class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findSet(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = findSet(parent[x]);
        }

        public boolean union(int x, int y) {
            // 각 원소의 루트를 찾음
            int rootX = findSet(x);
            int rootY = findSet(y);

            // 이미 같은 집합에 속해있다면 return
            if (rootX == rootY) {
                return false;
            }

            // 병합 (rank 최적화 생략)
            parent[rootY] = rootX;
            return true;
        }
    }

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
        int from, to;
        long distSquared; // 거리 제곱

        public Edge(int from, int to, long distSquared) {
            this.from = from;
            this.to = to;
            this.distSquared = distSquared;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.distSquared, o.distSquared);
        }
    }

    /**
     * Kruskal Algorithm: MST 구축
     *
     * @param N     섬의 개수
     * @param E     환경 부담 세율
     * @param edges 터널 후보 리스트
     * @return      최종 환경 부담금
     */
    private static long kruskal(int N, double E, PriorityQueue<Edge> edges) {
        DisjointSet ds = new DisjointSet(N);  // makeSet
        long cost = 0;
        int count = 0;

        while (!edges.isEmpty()) {
            Edge e = edges.poll();
            if (ds.union(e.from, e.to)) {
                // true: 두 섬이 이전에 연결되어있지 않았음 -> 이 터널(간선)을 MST에 포함시킴
                // false: 이미 다른 경호를 통해 연결되어 있음 -> 추가하면 사이클이 발생하므로 무시
                cost += e.distSquared;
                // 간선 수가 (N - 1)이면 모든 섬 연결이 완료된 것
                if (++count == N - 1) {
                    break;
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

            // Logic
            PriorityQueue<Edge> edges = new PriorityQueue<>();
            for (int i = 0; i < N; i++) { // 가능한 모든 간선 생성
                for (int j = i + 1; j < N; j++) {
                    long dx = islands[i].x - islands[j].x;
                    long dy = islands[i].y - islands[j].y;
                    long distSquared = dx * dx + dy * dy;
                    edges.offer(new Edge(islands[i].id, islands[j].id, distSquared));
                }
            }

            // Output by Kruskal Algorithm
            sb.append("#").append(t).append(" ").append(kruskal(N, E, edges)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
