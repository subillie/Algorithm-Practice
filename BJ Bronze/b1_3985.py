# 3985 롤 케이크
import sys
INPUT = sys.stdin.readline

L = int(INPUT())
N = int(INPUT())
wish = []
cake = [0] * L
for i in range(1, N + 1):
    P, K = map(int, INPUT().split())
    wish.append(K - P)
    for j in range(P - 1, K):
        if cake[j] == 0:
            cake[j] = i
print(wish.index(max(wish)) + 1)

max_count = max_i = 0
for i in range(1, N + 1):
    if max_count < cake.count(i):
        max_count = cake.count(i)
        max_i = i
print(max_i)
