/**
 * Disjoint Set (Union-Find) 자료구조 구현
 * 최적화: 경로 압축 (Path Compression) 및 랭크를 이용한 합집합 (Union by Rank) 적용
 */
class DisjointSet {

    // 각 원소의 부모 노드를 저장하는 배열. parent[i] = i이면 i는 루트 노드.
    private int[] parent;
    // 트리의 깊이(랭크)를 저장하는 배열. union 연산 시 최적화에 사용됨.
    private int[] rank;

    /**
     * DisjointSet 생성자 (makeSet 연산 수행)
     * n개의 원소를 가지는 집합을 초기화합니다.
     * @param n 원소의 개수 (1부터 n까지 가정)
     */
    public DisjointSet(int n) {
        parent = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            // 1. makeSet(i): 초기에는 각 원소가 자기 자신을 부모로 가리킴 (자신이 루트인 집합)
            parent[i] = i;
            rank[i] = 0; // 초기 랭크(트리 높이)는 0
        }
    }

    /**
     * findSet(x) 연산: 원소 x가 속한 집합의 대표(루트)를 찾는다.
     * 경로 압축(Path Compression) 최적화: 찾는 과정에서 만나는 모든 노드가 직접 루트를 가리키도록 갱신한다.
     *
     * @param x 찾고자 하는 원소
     * @return 원소 x의 루트 노드 번호
     */
    public int findSet(int x) {
        // 1. 부모가 자기 자신이 아니면, 재귀적으로 루트를 찾아 올라간다.
        if (parent[x] != x) {
            // 2. 경로 압축: parent[x]를 최종 루트로 직접 연결한다.
            parent[x] = findSet(parent[x]);
        }
        return parent[x];
    }

    /**
     * union(x, y) 연산: 원소 x가 속한 집합과 원소 y가 속한 집합을 합친다.
     * 랭크를 이용한 합집합(Union by Rank) 최적화: 높이가 낮은 트리를 높이가 높은 트리 밑에 붙여
     * 전체적인 트리의 높이가 불필요하게 커지는 것을 방지한다.
     *
     * @param x 합칠 원소 1
     * @param y 합칠 원소 2
     * @return 두 집합이 성공적으로 합쳐졌으면 true, 이미 같은 집합이면 false 반환
     */
    public boolean union(int x, int y) {
        // 1. 각 원소의 루트를 찾는다.
        int rootX = findSet(x);
        int rootY = findSet(y);

        // 2. 두 원소가 이미 같은 집합에 속해있다면 합칠 필요 없음.
        if (rootX == rootY) {
            return false;
        }

        // 3. 랭크(트리 높이) 비교하여 합치기 (Union by Rank)
        if (rank[rootX] < rank[rootY]) {
            // rootY의 랭크가 더 높으면, rootX를 rootY 밑에 붙인다.
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            // rootX의 랭크가 더 높으면, rootY를 rootX 밑에 붙인다.
            parent[rootY] = rootX;
        } else {
            // 랭크가 같다면, 한쪽(rootY)을 다른 쪽(rootX) 밑에 붙이고 rootX의 랭크를 1 증가시킨다.
            parent[rootY] = rootX;
            rank[rootX]++;
        }
        return true;
    }
}

// --- 사용 예시 ---
// public class Main {
//     public static void main(String[] args) {
//         int numberOfElements = 10;
//         DisjointSet ds = new DisjointSet(numberOfElements);

//         // 초기 상태: 모두 다른 집합
//         System.out.println("Find(1): " + ds.findSet(1)); // 1
//         System.out.println("Find(2): " + ds.findSet(2)); // 2

//         // Union 연산: 1과 2를 합침
//         ds.union(1, 2);
//         System.out.println("Union(1, 2) 후 Find(1): " + ds.findSet(1));
//         System.out.println("Union(1, 2) 후 Find(2): " + ds.findSet(1)); // 1과 2의 루트가 같아짐

//         // Union 연산: 3과 4를 합침
//         ds.union(3, 4);

//         // Union 연산: 1의 집합과 3의 집합을 합침 (1-2, 3-4 -> 1-2-3-4)
//         ds.union(1, 3);
//         System.out.println("Find(4): " + ds.findSet(4)); // 1, 2, 3, 4가 모두 같은 집합의 루트를 가리킴
//         System.out.println("Find(1) == Find(4): " + (ds.findSet(1) == ds.findSet(4))); // true
//     }
// }