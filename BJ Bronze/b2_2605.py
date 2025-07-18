# 2605 줄 세우기
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
wish_number = list(map(int, INPUT().split()))
wait_list = []
for n in range(N):
    wait_list.insert(wish_number[n], n + 1)
print(*wait_list[::-1])