# 2606 바이러스
from collections import deque
import sys
INPUT = sys.stdin.readline

node_num = int(INPUT().rstrip())
edge_num = int(INPUT().rstrip())
graph = [[] for _ in range(node_num + 1)]
for _ in range(edge_num):
    node_1, node_2 = map(int, INPUT().split())
    graph[node_1].append(node_2)
    graph[node_2].append(node_1)

queue = deque()
visited = [False for _ in range(node_num + 1)]

queue.append(1)
visited[1] = True
count = 0
while(queue):
    node = queue.popleft()
    for next_node in graph[node]:
        if visited[next_node] == False:
            queue.append(next_node)
            visited[next_node] = True
            count += 1
print(count)