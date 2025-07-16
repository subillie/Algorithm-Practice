# 1325 효율적인 해킹
from collections import deque
import sys
INPUT = sys.stdin.readline

N, M = map(int, INPUT().split())
graph = [[] for _ in range(N + 1)]
for _ in range(M):
    A, B = map(int, INPUT().split())
    graph[B].append(A)

count = [0 for _ in range(N + 1)]
max_count = 0
for n in range(1, N + 1):
    visited = [False for _ in range(N + 1)]
    visited[n] = True
    queue = deque([n])
    while queue:  # BFS
        node = queue.popleft()
        for next_node in graph[node]:
            if not visited[next_node]:
                visited[next_node] = True
                queue.append(next_node)
                count[n] += 1
    max_count = max(max_count, count[n])
for i in range(1, N + 1):
    if count[i] == max_count:
        print(i, end = ' ')