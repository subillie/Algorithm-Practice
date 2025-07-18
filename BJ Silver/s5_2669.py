# 2669 직사각형 네개의 합집합의 면적 구하기
import sys
INPUT = sys.stdin.readline

coordinate_system = [[False] * 101 for _ in range(101)]
area = 0
for _ in range(4):
    bottom_x, bottom_y, top_x, top_y = map(int, INPUT().split())
    for x in range(bottom_x, top_x):
        for y in range(bottom_y, top_y):
            if not coordinate_system[x][y]:
                coordinate_system[x][y] = True
                area += 1
print(area)