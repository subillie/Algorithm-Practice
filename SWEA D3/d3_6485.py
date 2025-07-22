# 6485 삼성시의 버스 노선
T = int(input())
for t in range(T):
    print(f"#{t + 1}", end=" ")
    N = int(input())
    bus = [tuple(map(int, input().split())) for _ in range(N)]
    P = int(input())
    for _ in range(P):
        C = int(input())
        count = 0
        for n in range(N):
            A, B = bus[n]
            if A <= C <= B:
                count += 1
        print(count, end=" ")
    print()