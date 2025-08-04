# 4835 구간합
T = int(input())

for t in range(1, T + 1):
    N, M = map(int, input().split())
    arr = list(map(int, input().split()))

    max_chunk = -float("inf")
    min_chunk = float("inf")
    for i in range(N - M + 1):
        chunk_sum = sum(arr[i:i + M])
        max_chunk = max(max_chunk, chunk_sum)
        min_chunk = min(min_chunk, chunk_sum)
    print(f"#{t}", max_chunk - min_chunk)