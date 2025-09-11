// 5643 키 순서
import java.io.*;
import java.util.*;

public class d4_5643 {
    private static int N;
    private static BitSet[] graph;

    private static void floydWarshall() {
        for (int j = 1; j <= N; j++) {     // j: 중간 경유지
            for (int i = 1; i <= N; i++) { // i: 출발지
                if (graph[i].get(j)) {     // i -> j 경로가 존재한다면
                    graph[i].or(graph[j]); // i는 j의 경로 사용 가능하므로 합집합 연산 수행
                }
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
            
            graph = new BitSet[N + 1]; // BitSet을 인접 행렬처럼 사용
            for (int i = 1; i <= N; i++) {
                graph[i] = new BitSet(N + 1);
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].set(b); // a -> b
            }

            // Logic
            floydWarshall(); // 모든 경로 정보 갱신
            
            int answer = 0;
            for (int i = 1; i <= N; i++) {
                int count = 0;
                for (int j = 1; j <= N; j++) {
                    // i가 j보다 작거나(i->j), i가 j보다 크면(j->i) 관계를 아는 것
                    if (i != j && (graph[i].get(j) || graph[j].get(i))) {
                        count++;
                    }
                }
                // 나를 제외한 모든 학생(N-1)과의 관계를 알고 있으면 순서가 확정되므로 정답 카운트
                if (count == N - 1) {
                    answer++;
                }
            }

            // Output
            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}