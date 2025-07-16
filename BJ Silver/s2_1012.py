# 1012 유기농 배추
from collections import deque
import sys
INPUT = sys.stdin.readline

T = int(INPUT())
for _ in range(T):
    M, N, K = map(int, INPUT().split())
    visited = []  # 배추 좌표
    count = 0  # 배추흰지렁이 수
    for __ in range(K):
        x, y = map(int, INPUT().split())
        visited.append((x, y))
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    queue = deque()
    while visited:
        queue.append(visited[0])
        del visited[0]
        count += 1
        while queue:
            x, y = queue.popleft()
            for move in range(4):
                nx = x + dx[move]
                ny = y + dy[move]
                if (nx, ny) in visited:
                    visited.remove((nx, ny))
                    queue.append((nx, ny))
    print(count)