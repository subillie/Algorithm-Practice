# 1463 1로 만들기
import sys
INPUT = sys.stdin.readline

num = int(INPUT())
dp = [0] * (num + 1)  # dp[n]: n을 1로 만드는 최소 연산 횟수

# dp[1] = 0 -> 1은 이미 1이므로 연산이 필요 없음
# dp[2], dp[3], ...,  dp[num]을 계산해 나감 (bottom-up 방식)
for n in range(2, num + 1):
    dp[n] = dp[n - 1] + 1  # (n - 1)에서 n으로 오려면 한 번의 연산 필요
    if n % 3 == 0:  # n이 3의 배수라면
        dp[n] = min(dp[n], dp[n // 3] + 1)  # n//3에서 한 번의 연산으로 올 수 있음 -> "dp[n // 3] + 1"
    if n % 2 == 0:  # n이 2의 배수라면
        dp[n] = min(dp[n], dp[n // 2] + 1)  # n//2에서 한 번의 연산으로 올 수 있음 -> "dp[n // 2] + 1"

print(dp[num])