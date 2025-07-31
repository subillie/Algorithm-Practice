# 10157 자리배정
import sys
INPUT = sys.stdin.readline

C, R = map(int, INPUT().split())  # 가로, 세로
K = int(INPUT())
if K > C * R:
    print(0)
    exit()

# 방향 순서: 오른쪽, 아래, 왼쪽, 위
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

mat = [[0] * R for _ in range(C)]
x = y = direction = 0
i = 1
mat[x][y] = i
while i < K:
    i += 1
    nx = x + dx[direction]
    ny = y + dy[direction]
    if 0 <= nx < R and 0 <= ny < C and mat[ny][nx] == 0:
        x, y = nx, ny
        mat[y][x] = i
    else:
        direction = (direction + 1) % 4
        i -= 1
print(y + 1, x + 1)