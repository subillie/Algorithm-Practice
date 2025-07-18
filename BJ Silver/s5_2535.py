# 2535 아시아 정보올림피아드
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
arr = [list(map(int, INPUT().split())) for _ in range(N)]
arr = sorted(arr, reverse=True, key=lambda x: x[2])

print(*arr[0][:2])  # gold medal
print(*arr[1][:2])  # silver medal
bronze_medal = 2
if arr[0][0] == arr[1][0]:
    for i in range(2, N):
        if arr[i][0] != arr[0][0]:
            bronze_medal = i
            break
print(*arr[bronze_medal][:2])