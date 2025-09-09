// 7465 창용 마을 무리의 개수
import java.io.*;
import java.util.*;

public class d4_7465 {
    static class DisjointSet {
        private int[] parent;

        // makeSet
        public DisjointSet(int n) {
            parent = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
            }
        }

        // findSet
        public int findSet(int x) {
            if (parent[x] == x) {
                return x;
            }
            return parent[x] = findSet(parent[x]);
        }

        // union
        public void union(int x, int y) {
            int rootX = findSet(x);
            int rootY = findSet(y);
            // 더 작은 번호를 부모로 삼음
            if (rootX < rootY) {
                parent[rootY] = rootX;
            } else {
                parent[rootX] = rootY;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 사람 수 (정점)
            int M = Integer.parseInt(st.nextToken()); // 관계 수 (간선)
            DisjointSet ds = new DisjointSet(N); // 서로소 집합 생성

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                ds.union(a, b); // 관계가 있으면 두 사람을 같은 집합으로 합침
            }

            // 각 사람의 최종 루트를 Set에 추가
            HashSet<Integer> groupRoots = new HashSet();
            for (int i = 1; i <= N; i++) {
                groupRoots.add(ds.findSet(i));
            }

            // 최종 집합 수 카운트 및 출력
            sb.append("#").append(t).append(" ").append(groupRoots.size()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
