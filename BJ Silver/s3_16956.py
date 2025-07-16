# 16956 늑대와 양
import sys
INPUT = sys.stdin.readline

R, C = map(int, INPUT().split())
matrix = []
for r in range(R):
    matrix.append(list(INPUT().rstrip().replace('.', 'D')))
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]
flag = True
for r in range(R):
    for c in range(C):
        if matrix[r][c] == 'W':
            for move in range(4):
                x = r + dx[move]
                y = c + dy[move]
                if (0 <= x < R and 0 <= y < C and matrix[x][y] == 'S'):
                    flag = False
                    break
if flag == True:
    print(1)
    for col in matrix:
        print("".join(col))
else:
    print(0)