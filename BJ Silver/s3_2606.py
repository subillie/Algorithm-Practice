# 2606 바이러스
from collections import deque
import sys
input = sys.stdin.readline

def bfs(n: int) -> None:
  global count
  queue = deque()
  queue.append(n)
  visited[1] = True

  while(queue):
      node = queue.popleft()
      for next_node in graph[node]:
          if not visited[next_node]:
              queue.append(next_node)
              visited[next_node] = True
              count += 1

def dfs(n: int) -> None:
  global count
  visited[n] = True
  for next_node in graph[n]:
      if not visited[next_node]:
          dfs(next_node)
          count += 1

if __name__ == "__main__":
  node_num = int(input())
  edge_num = int(input())
  graph = [[] for _ in range(node_num + 1)]
  for _ in range(edge_num):
      node1, node2 = map(int, input().split())
      graph[node1].append(node2)
      graph[node2].append(node1)

  count = 0
  visited = [False for _ in range(node_num + 1)]

  # bfs(1)
  dfs(1)

  print(count)