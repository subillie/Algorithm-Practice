// 1197 최소 스패닝 트리
import java.io.*;
import java.util.*;

public class g4_1197 {
    private static class Edge implements Comparable<Edge> {
        private int from, to, weight;
        
        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
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
            int rootX = findSet(x);
            int rootY = findSet(y);
            if (rootX == rootY) {
                return false;
            } else {
                parent[rootY] = rootX;
                return true;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        //Input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int V = Integer.parseInt(st.nextToken()); // 정점의 개수
        int E = Integer.parseInt(st.nextToken()); // 간선의 개수

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < E; i++) { // 모든 간선 정보 저장
            st = new StringTokenizer(br.readLine(), " ");
            int A = Integer.parseInt(st.nextToken()); // 연결된 정점
            int B = Integer.parseInt(st.nextToken()); // 연결된 정점
            int C = Integer.parseInt(st.nextToken()); // 가중치
            edges.add(new Edge(A, B, C));
        }

        // Logic: Kruskal Algorithm
        DisjointSet ds = new DisjointSet(V);
        long totalWeight = 0;
        int edgeCount = 0;

        while (true) {
            Edge e = edges.poll();
            if (ds.union(e.from, e.to)) { // union 연산으로 사이클이 생기는지 확인
                totalWeight += e.weight; // 사이클이 생기지 않으면 간선을 MST에 포함
                if (++edgeCount == V - 1) { // MST는 V-1개의 간선으로 이루어지므로
                    break; // 다 선택했으면 종료
                }
            }
        }

        // Output
        System.out.println(totalWeight);
    }
}
