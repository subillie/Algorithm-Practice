# 4828 min max
T = int(input())
for t in range(1, T + 1):
    N = int(input())
    arr = list(map(int, input().split()))
    print(f"#{t}", max(arr) - min(arr))