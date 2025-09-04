# 1916 최소비용 구하기
import sys, heapq

input = sys.stdin.readline
INF = float('inf')


def dijkstra(table: list, src: int, dest: int) -> int:
    min_costs = [INF] *(N + 1)
    min_costs[src] = 0
    pq = [(0, src)]

    while pq:
        cost, node = heapq.heappop(pq)

        if cost > min_costs[node]:
            continue

        for next_cost, next_hop in table[node]:
            new_cost = cost + next_cost
            if new_cost < min_costs[next_hop]:
                min_costs[next_hop] = new_cost
                heapq.heappush(pq, (new_cost, next_hop))
    
    return min_costs[dest]


if __name__ == '__main__':
    N = int(input())
    M = int(input())
    table = [[] for _ in range(N + 1)]
    for _ in range(M):
        src, dest, cost = map(int, input().split())
        table[src].append((cost, dest))
    src, dest = map(int, input().split())
    print(dijkstra(table, src, dest))