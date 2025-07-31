# 2477 참외밭
import sys
INPUT = sys.stdin.readline

K = int(INPUT())
farm = [-1 for _ in range(5)]
moves = [tuple(map(int, INPUT().split())) for _ in range(6)]

# 최대 길이 변 구하기
max_w = max_h = 0
max_w_i = max_h_i = 0
for i in range(6):
    direction, length = moves[i]
    if direction == 1 or direction == 2:
        if max_w < length:
            max_w = length
            max_w_i = i
    else:
        if max_h < length:
            max_h = length
            max_h_i = i

# 최대 길이 변과 인접하지 않은 변 구하기
small_w = abs(moves[(max_h_i - 1) % 6][1] - moves[(max_h_i + 1) % 6][1])
small_h = abs(moves[(max_w_i - 1) % 6][1] - moves[(max_w_i + 1) % 6][1])

print((max_w * max_h - small_w * small_h) * K)