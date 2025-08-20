# 2178 미로 탐색
from collections import deque
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
mat = [list(input().rstrip()) for _ in range(N)]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

distance = [[0] * M for _ in range(N)]
distance[0][0] = 1
queue = deque([(0, 0)])
while queue:
  y, x = queue.popleft()
  if y == N - 1 and x == M - 1:
    break

  for move in range(4):
    nx = x + dx[move]
    ny = y + dy[move]
    if 0 <= ny < N and 0 <= nx < M and mat[ny][nx] == '1':
      mat[ny][nx] = '0'  # 방문 처리
      distance[ny][nx] = distance[y][x] + 1  # 최소 칸 수
      queue.append((ny, nx))

print(distance[N - 1][M - 1])