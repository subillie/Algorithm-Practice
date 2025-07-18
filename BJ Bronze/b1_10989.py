# 10989 수 정렬하기 3
## Counting Sort (계수 정렬)
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
count = [0] * 10001

for _ in range(N):
    count[int(INPUT())] += 1
for i in range(10001):
    if count[i]:
        for _ in range(count[i]):
            print(i)