# 10163 색종이
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coordinate_system = [[0] * 1001 for _ in range(1001)]
for n in range(1, N + 1):
    x, y, width, height = map(int, INPUT().split())
    for y_pos in range(y, y + height):
        coordinate_system[y_pos][x:(x + width)] = [n] * width

for n in range(1, N + 1):
    count = 0
    for i in range(1001):
        count += coordinate_system[i].count(n)
    print(count)