// 1267 작업순서
import java.io.*;
import java.util.*;

public class d6_1267 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int V = Integer.parseInt(st.nextToken()); // 정점 개수
            int E = Integer.parseInt(st.nextToken()); // 간선 개수

            // Init graph
            BitSet[] graph = new BitSet[V + 1];
            for (int i = 1; i <= V; i++) {
                graph[i] = new BitSet(V + 1);
            }

            // Set graph and indegree
            st = new StringTokenizer(br.readLine(), " ");
            int[] indegree = new int[V + 1];
            for (int i = 0; i < E; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                if (!graph[from].get(to)) {
                    graph[from].set(to);
                    indegree[to]++;
                }
            }

            // Init queue
            Queue<Integer> queue = new ArrayDeque<>();
            for (int i = 1; i <= V; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                }
            }
            
            // Topological sort
            sb.append("#").append(t);
            while (!queue.isEmpty()) {
                int cur = queue.poll();
                sb.append(" ").append(cur);

                int next = graph[cur].nextSetBit(1);
                for (; next != -1; next = graph[cur].nextSetBit(next + 1)) {
                    if (--indegree[next] == 0) {
                        queue.offer(next);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}