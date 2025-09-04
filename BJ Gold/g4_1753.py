# 1753 최단경로
import sys, heapq

input = sys.stdin.readline
INF = float('inf')


def dijkstra(table: list, start: int) -> list:
    """
    Args:
        - table (list): 노드와 그 노드에 연결된 (가중치, 이웃 노드)를 담은 배열
        - start (int): 최단 경로를 찾기 시작할 노드
    Returns:
        - min_dists (list): 시작 노드로부터 각 노드까지의 최단 거리를 담은 배열
    """
    min_dists = [INF] * (V + 1)  # 초기값: 무한대
    min_dists[start] = 0  # 시작 노드(자기 자신): 0
    priority_queue = [(0, start)]  # 가중치(거리)=0, 시작 노드

    while priority_queue:
        # 거리가 가장 짧은 노드를 우선순위 큐에서 꺼냄
        dist, node = heapq.heappop(priority_queue)

        # 가장 짧은 경로가 확정된 후에 들어온 더 긴 경로는 무시
        if dist > min_dists[node]:
            continue
        
        # 현재 노드와 연결된 이웃 노드들 확인
        for weight, next_hop in table[node]:
            new_dist = dist + weight
            # 이웃으로 갈 때, 현재 노드를 거쳐 가는 것이 기존 경로보다 짧다면 갱신
            if new_dist < min_dists[next_hop]:
                min_dists[next_hop] = new_dist
                heapq.heappush(priority_queue, (new_dist, next_hop))

    return min_dists


if __name__ == '__main__':
    V, E = map(int, input().split())
    K = int(input())

    table = [[] for _ in range(V + 1)]
    for _ in range(E):
        u, v, w = map(int, input().split())  # u -> v (w: 가중치)
        table[u].append((w, v))

    min_dists = dijkstra(table, V, K)
    for i in range(1, V + 1):
        print("INF" if min_dists[i] == INF else min_dists[i])
