# 2567 색종이 - 2
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
mat = [[False] * 101 for _ in range(101)]
for _ in range(N):
    X, Y = map(int, INPUT().split())
    for x in range(X, X + 10):
        mat[x][Y:Y + 10] = [True] * 10

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

circumference = 0
for x in range(101):
    for y in range(101):
        if mat[x][y]:
            for move in range(4):
                nx = x + dx[move]
                ny = y + dy[move]
                if 0 <= nx <= 100 and 0 <= ny <= 100:
                    if not mat[nx][ny]:
                        circumference += 1
print(circumference)