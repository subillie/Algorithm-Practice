# 1003 피보나치 함수
import sys
input = sys.stdin.readline

T = int(input())
for _ in range(T):
    N = int(input())
    zero, one = 1, 0
    for _ in range(N):
        zero, one = one, zero + one
    print(zero, one)