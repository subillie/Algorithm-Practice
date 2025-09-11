// 1238 Contact
import java.io.*;
import java.util.*;

public class d4_1238 {
    private static HashMap<Integer, HashSet<Integer>> calls;

    private static int bfs(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        int[] distance = new int[101];
        Arrays.fill(distance, -1); // -1은 아직 방문하지 않았음을 의미

        queue.add(start);
        distance[start] = 0;

        int maxDistance = 0;  // 가장 먼 거리 (현재까지 발견된 가장 깊은 깊이)
        int maxNum = start;  // 가장 깊은 곳에 있는 가장 큰 번호

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            // 현재 노드의 깊이가 이전에 기록된 최대 깊이보다 깊다면,
            // 정답 후보를 현재 노드로 완전히 교체
            if (distance[cur] > maxDistance) {
                maxDistance = distance[cur];
                maxNum = cur;
            }
            // 현재 노드의 깊이가 최대 깊이와 같다면,
            // 더 번호가 큰 쪽을 정답 후보로 남김
            else if (distance[cur] == maxDistance) {
                maxNum = Math.max(maxNum, cur);
            }

            // 현재 노드와 연결된 다음 노드들 탐색
            if (calls.containsKey(cur)) {
                for (int next : calls.get(cur)) {
                    // 아직 방문하지 않은 노드라면
                    if (distance[next] == -1) {
                        // 이전 노드 깊이 + 1로 깊이를 기록하고 큐에 추가
                        distance[next] = distance[cur] + 1;
                        queue.add(next);
                    }
                }
            }
        }
        return maxNum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int dataLen = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            
            st = new StringTokenizer(br.readLine(), " ");
            calls = new HashMap<>();
            for (int i = 0; i < dataLen; i += 2) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                HashSet<Integer> value = calls.getOrDefault(from, new HashSet<>());
                value.add(to);
                calls.put(from, value);
            }
            
            sb.append("#").append(t).append(" ").append(bfs(start)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
