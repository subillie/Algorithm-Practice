// 5643 키 순서
import java.io.*;
import java.util.*;

public class d4_5643 {
    private static int N, count;
    private static boolean[] visited;

    private static void dfs(List<Integer>[] graph, int cur) {
        visited[cur] = true;
        for (int next: graph[cur]) {
            if (!visited[next]) {
                count++;
                dfs(graph, next);
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
            int M = Integer.parseInt(br.readLine());
            
            List<Integer>[] graph = new ArrayList[N + 1];
            List<Integer>[] revGraph = new ArrayList[N + 1];
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<>();
                revGraph[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                graph[a].add(b);    // a -> b (a는 b보다 작다)
                revGraph[b].add(a); // b -> a (b는 a보다 크다)
            }

            // Logic
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                count = 0;

                visited = new boolean[N + 1];
                dfs(graph, i); // 나보다 키 큰 사람 수 세기
                visited = new boolean[N + 1];
                dfs(revGraph, i); // 나보다 키 작은 사람 수 세기

                if (count == N - 1) { // 카운트가 나 제외 N-1이면 정답
                    answer++;
                }
            }

            // Output
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}