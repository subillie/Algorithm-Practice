# 2304 창고 다각형
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coord = [0 for _ in range(1001)]
max_height = max_index = 0
for i in range(N):
    L, H = map(int, INPUT().split())
    coord[L] = H
    if H > max_height:
        max_height = H
        max_index = L

area = 0
height = 0
for i in range(max_index + 1):
    height = max(height, coord[i])
    area += height
height = 0
for i in range(1000, max_index, -1):
    height = max(height, coord[i])
    area += height
print(area)