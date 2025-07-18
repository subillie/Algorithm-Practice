# 10163 색종이
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coordinate_system = [[0] * 1001 for _ in range(1001)]
for n in range(N):
    start_x, start_y, width, height = map(int, INPUT().split())
    for x in range(start_x, start_x + width):
        for y in range(start_y, start_y + height):
            coordinate_system[x][y] = n + 1

count = [0] * (N + 1)
for x in range(1001):
    for y in range(1001):
        count[coordinate_system[x][y]] += 1
for n in range(1, N + 1):
    print(count[n])