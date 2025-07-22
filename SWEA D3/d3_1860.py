# 1860 진기의 최고급 붕어빵
T = int(input())
for t in range(T):
    N, M, K = map(int, input().split())
    customers = sorted(list(map(int, input().split())))
    answer = "Possible"
    for n in range(N):
        count = customers[n] // M * K - (n + 1)
        if count < 0:
            answer = "Impossible"
            break
    print(f"#{t + 1}", answer)