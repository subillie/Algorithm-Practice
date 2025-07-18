# 13300 방 배정
import sys
INPUT = sys.stdin.readline

N, K = map(int, INPUT().split())
arr = [[0 for _ in range(6)] for _ in range(2)]
for _ in range(N):
    sex, age = map(int, INPUT().split())
    arr[sex][age - 1] += 1

count = 0
for i in range(2):
    for j in range(6):
        count += (arr[i][j] + (K - 1)) // K  # 올림 나눗셈: (a+b-1)//b
print(count)