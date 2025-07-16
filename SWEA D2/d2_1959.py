# 1959 두 개의 숫자열
T = int(input())
for t in range(T):
    N, M = map(int, input().split())
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    if N >= M:
        A, B = B, A

    max_sum = -float("inf")
    for i in range(len(B) - len(A) + 1):
        cur_sum = 0
        for j in range(len(A)):
            cur_sum += A[j] * B[i + j]
        max_sum = max(max_sum, cur_sum)

    print(f"#{t + 1} {max_sum}")