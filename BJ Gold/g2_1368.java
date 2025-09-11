// 1368 물대기
import java.io.*;
import java.util.*;

public class g2_1368 {
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

    private static class DisjointSet {
        private int[] parent;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        private int findSet(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = findSet(parent[x]);
        }

        private boolean union(int x, int y) {
            int rootX = findSet(x);
            int rootY = findSet(y);
            if (rootX == rootY) {
                return false;
            }
            parent[rootY] = rootX;
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Edge> edge = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            // 가상의 수원지(N)과 우물(i)을 연결하는 간선
            edge.add(new Edge(N, i, Integer.parseInt(br.readLine())));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int weight = Integer.parseInt(st.nextToken());
                if (i < j) { // 중복 제거
                    // 우물(i)와 우물(j)를 연결하는 간선
                    edge.add(new Edge(i, j, weight));
                }
            }
        }

        // Kruskal Algorithm
        DisjointSet ds = new DisjointSet(N);
        int cost = 0;
        int count = 0;
        while (!edge.isEmpty()) {
            Edge e = edge.poll();
            if (ds.union(e.from, e.to)) {
                cost += e.weight;
                if (++count == N) {
                    break;
                }
            }
        }

        System.out.println(cost);
    }
}