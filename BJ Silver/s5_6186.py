from collections import deque
import sys
INPUT = sys.stdin.readline

R, C = map(int, INPUT().split())
matrix = [list(INPUT().rstrip()) for _ in range(R)]
not_visited = []
for r in range(R):
  for c in range(C):
    if matrix[r][c] == '#':
      not_visited.append((r, c))

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

queue = deque()
count = 0
for v in not_visited[:]:  # 꼬일 수 있으니 복사본으로 순회
  if v not in not_visited:
      continue
  queue.append(v)
  not_visited.remove(v)
  count += 1
  while queue:
    x, y = queue.popleft()
    for move in range(4):
      nx = x + dx[move]
      ny = y + dy[move]
      if (0 <= nx < R and 0 <= ny < C) and ((nx, ny) in not_visited):
        queue.append((nx, ny))
        not_visited.remove((nx, ny))
print(count)