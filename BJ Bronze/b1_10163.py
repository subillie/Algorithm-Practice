# 10163 색종이
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
coordinate_system = [[0] * 1001 for _ in range(1001)]

# 색종이 쌓기
for n in range(1, N + 1):
    x, y, width, height = map(int, INPUT().split())
    for y_pos in range(y, y + height):
        coordinate_system[y_pos][x:(x + width)] = [n] * width
# for n in range(N):
#     start_x, start_y, width, height = map(int, INPUT().split())
#     for x in range(start_x, start_x + width):
#         for y in range(start_y, start_y + height):
#             coordinate_system[x][y] = n + 1

# 면적 구하기
for n in range(1, N + 1):
    count = 0
    for i in range(1001):
        count += coordinate_system[i].count(n)
    print(count)
# count = [0] * (N + 1)
# for x in range(1002):
#     for y in range(1002):
#         count[coordinate_system[x][y]] += 1
# for n in range(1, N + 1):
#     print(count[n])