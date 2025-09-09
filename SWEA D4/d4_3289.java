// 3289 서로소 집합
import java.io.*;
import java.util.*;

public class d4_3289 {
    static class DisjointSet {
        private int[] parent, rank;

        public DisjointSet(int n) {
            parent = new int[n + 1];
            rank = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
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

            // 두 원소의 루트가 같다면 (이미 같은 집합에 속해있다면) return
            if (rootX == rootY) {
                return false;
            }

            if (rank[rootX] > rank[rootY]) { // x의 랭크가 더 높으면, y를 x 밑에 붙임
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else { // 랭크가 같다면, 아무거나 골라 다른 쪽 밑에 붙임
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); // 집합 개수 (정점)
            int m = Integer.parseInt(st.nextToken()); // 연산 개수 (간선)
            DisjointSet ds = new DisjointSet(n); // makeSet

            sb.append("#").append(t).append(" ");

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int command = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                if (command == 0) {
                    ds.union(a, b);
                } else { // command == 1
                    if (ds.findSet(a) == ds.findSet(b)) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                }
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
