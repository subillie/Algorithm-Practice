# 10163 색종이
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coordinate_system = [[0] * 1001 for _ in range(1001)]

# 색종이 쌓기
for n in range(1, N + 1):
    x, y, width, height = map(int, INPUT().split())
    for x_pos in range(x, x + width):
        coordinate_system[x_pos][y:(y + height)] = [n] * height

# 면적 구하기
for n in range(1, N + 1):
    count = 0
    for i in range(1001):
        count += coordinate_system[i].count(n)
    print(count)