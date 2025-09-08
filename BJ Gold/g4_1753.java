// 1753 최단경로
import java.io.*;
import java.util.*;

public class g4_1753 {
    private static int V;
    private static List<Node>[] graph;
    
    private static class Node implements Comparable<Node>{
        private int vertex; // 정점 번호
        private int weight; // 간선 가중치 (PQ에 넣을 때는 시작점부터의 총 거리)

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight; // 가중치 기준 오름차순 정렬
        }
    }
    
    private static int[] dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] table = new int[V + 1];
        Arrays.fill(table, Integer.MAX_VALUE);

        pq.add(new Node(start, 0));
        table[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (cur.weight > table[cur.vertex]) {
                continue;
            }

            for (Node next: graph[cur.vertex]) {
                int newDist = cur.weight + next.weight;
                if (newDist < table[next.vertex]) {
                    table[next.vertex] = newDist;
                    pq.add(new Node(next.vertex, newDist));
                }
            }
        }
        return table;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // Input
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[V + 1];
        for (int i = 0; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w)); // u -> v
        }

        // Logic
        int[] table = dijkstra(K);

        // Output
        for (int i = 1; i <= V; i++) {
            if (table[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(table[i]).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}