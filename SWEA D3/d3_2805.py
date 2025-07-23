# 2805 농작물 수확하기
T = int(input())
for t in range(1, T + 1):
    N = int(input())
    farm = [list(map(int, list(input()))) for _ in range(N)]
    center = N // 2
    revenue = 0
    for i in range(N):
        for j in range(N):
            if abs(center - i) + abs(center - j) <= center:
                revenue += farm[i][j]
    print(f"#{t}", revenue)