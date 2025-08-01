# 4963 섬의 개수
from collections import deque
import sys
INPUT = sys.stdin.readline

while True:
    w, h = map(int, INPUT().split())
    if w == h == 0:
        break
    mat = [list(map(int, INPUT().split())) for _ in range(h)]

    # 상하좌우/대각선 이동 가능
    dx = [1, -1, 0, 0, 1, -1, 1, -1]
    dy = [0, 0, 1, -1, 1, -1, -1, 1]

    count = 0
    for i in range(h):
        for j in range(w):
            if not mat[i][j]:  # Land가 아니면 pass
                continue
            queue = deque([(i, j)])
            count += 1
            while queue:
                y, x = queue.pop()
                for move in range(8):
                    ny = y + dy[move]
                    nx = x + dx[move]
                    if 0 <= ny < h and 0 <= nx < w and mat[ny][nx]:
                        mat[ny][nx] = 0
                        queue.append((ny, nx))
    print(count)