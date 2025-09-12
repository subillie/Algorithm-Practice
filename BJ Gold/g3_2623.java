// 2623 음악프로그램
import java.io.*;
import java.util.*;

public class g3_2623 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken()); // 가수의 수
        int M = Integer.parseInt(st.nextToken()); // 보조 PD의 수

        // Init graph
        int[] indegree = new int[N + 1];
        BitSet[] graph = new BitSet[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new BitSet(N + 1);
        }


        // Set graph
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int len = Integer.parseInt(st.nextToken());
            int[] tmp = new int[N + 1];
            for (int j = 0; j < len; j++) {
                tmp[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 1; j < len; j++) {
                int from = tmp[j - 1];
                int to = tmp[j];
                if (!graph[from].get(to)) { // 진입 차수 중복 카운트 방지
                    graph[from].set(to);
                    indegree[to]++;
                }
            }
        }

        // Set queue
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Topological sort
        int count = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            sb.append(cur).append("\n");
            count++;

            int next = graph[cur].nextSetBit(1);
            for (; next != -1; next = graph[cur].nextSetBit(next + 1)) {
                if (--indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        if (count < N) {
            System.out.println(0);
        } else {
            System.out.print(sb.toString());
        }
    }
}