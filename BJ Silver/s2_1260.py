#1260 DFS와 BFS
from collections import deque
import sys
INPUT = sys.stdin.readline

def dfs(graph: list, v: int, visited: list) -> None:
    visited[v] = True
    print(v, end=' ')
    for next_node in sorted(graph[v]):
        if not visited[next_node]:
            dfs(graph, next_node, visited)

def bfs(graph: list, v: int) -> None:
    queue = deque()
    queue.append(v)
    visited = [False for _ in len(graph)]
    visited[v] = True
    while queue:
        node = queue.popleft()
        print(node, end = ' ')
        for next_node in sorted(graph[node]):
            if not visited[next_node]:
                queue.append(next_node)
                visited[next_node] = True

if __name__ == "__main__":
    N, M, V = map(int, INPUT().split())
    graph = [list() for _ in range(N + 1)]
    for m in range(M):
        n1, n2 = map(int, INPUT().split())
        graph[n1].append(n2)
        graph[n2].append(n1)

    visited = [False for _ in range(N + 1)]
    dfs(graph, V, visited)
    print()
    bfs(graph, V)