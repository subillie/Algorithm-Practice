# 1038 감소하는 수
from itertools import combinations
import sys
INPUT = sys.stdin.readline

N = int(INPUT())

result = []
for i in range(1, 11):  # INT_MAX = 2,147,483,647 (10자리)
    for j in combinations(range(10), i):  # 1자리부터 10자리 수까지 조합 생성
        num = ''.join(list(map(str, reversed(list(j)))))  # descending order가 되도록 reverse
        result.append(int(num))
result.sort()

if N >= len(result):
    print(-1)
else:
    print(result[N])