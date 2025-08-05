# 17471 게리맨더링
from itertools import combinations
from collections import deque
import sys
INPUT = sys.stdin.readline

def bfs(area: list) -> int:
    """
    Return:
        - 모두 연결되어 있으면, 해당 선거구의 인구 수의 합
        - 그렇지 않으면, 0
    """
    queue = deque([area[0]])
    visited = [True] * (N + 1)
    for i in area[1:]:
        visited[i] = False

    total = 0
    while queue:
        curr = queue.popleft()
        total += population[curr]
        for next in graph[curr]:
            if not visited[next]:
                queue.append(next)
                visited[next] = True
    if all(visited):
        return total
    return 0
    

if __name__ == "__main__":
    N = int(INPUT())
    population = [0] + list(map(int, INPUT().split()))
    graph = [[] for _ in range(N + 1)]
    for i in range(1, N + 1):
        graph[i] = list(map(int, INPUT().split()))[1:]

    diff = float("inf")
    area_nums = list(range(1, N + 1))
    for n in range(1, N // 2 + 1):
        for comb in combinations(area_nums, n):
            area_1 = list(comb)
            area_2 = list(set(area_nums) - set(area_1))

            total_1 = bfs(area_1)
            if total_1:
                total_2 = bfs(area_2)
                if total_2:
                    diff = min(diff, abs(total_1 - total_2))
      
    print(diff if diff != float("inf") else -1)