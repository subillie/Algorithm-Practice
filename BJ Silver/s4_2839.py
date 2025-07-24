# 2839 설탕 배달
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
for i in range(N // 5, -1, -1):
    rest = N - i * 5
    if rest % 3 == 0:
        j = rest // 3
        print(i + j)
        break
else:
    print(-1)