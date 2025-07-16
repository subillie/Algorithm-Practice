# 17608 막대기
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
sticks = [int(INPUT()) for _ in range(N)][::-1]
tallest = sticks[0]
count = 1
for n in range(1, N):
    if (sticks[n] > tallest):
        count += 1
        tallest = sticks[n]
print(count)