# 1158 요세푸스 문제
from collections import deque
import sys
INPUT = sys.stdin.readline

N, K = map(int, INPUT().split())
arr = [n + 1 for n in range(N)]
ans = []

target = 0
for n in range(N):
    target += K - 1  # K가 아니라 K - 1을 더해줌
    arr_len = len(arr)
    if target >= arr_len:
        target %= arr_len
    ans.append(str(arr.pop(target)))  # pop하면서 index가 밀리기 때문
print("<", ", ".join(ans), ">", sep='')