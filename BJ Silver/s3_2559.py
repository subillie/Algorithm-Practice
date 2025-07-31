# 2559 수열
import sys
INPUT = sys.stdin.readline

N, K = map(int, INPUT().split())
arr = list(map(int, INPUT().split()))

prev = max_sum = sum(arr[0:K])
for i in range(1, N - K + 1):
    cur_sum = prev - arr[i - 1] + arr[i + K - 1]
    max_sum = max(max_sum, cur_sum)
    prev = cur_sum
print(max_sum)