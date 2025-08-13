# 2115 벌꿀채취
from itertools import combinations

T = int(input())
for t in range(1, T + 1):
    N, M, C = map(int, input().split())
    mat = [list(map(int, input().split())) for _ in range(N)]
    profit = [[0] * (N - M + 1) for _ in range(N)]

    for i in range(N):
        for j in range(N - M + 1):
            max_sum = 0
            for m in range(1, M + 1):
                for comb in combinations(mat[i][j:j + M], m):
                    if sum(comb) <= C:
                        max_sum = max(max_sum, sum(x * x for x in comb))
            profit[i][j] = max_sum

    answer = 0
    for i1 in range(N):
        for j1 in range(N - M + 1):
            for i2 in range(N):
                for j2 in range(N - M + 1):
                    # 행이 다르거나, 같은 행이어도 서로 겹치지 않는 경우
                    if i1 != i2 or (j1 + M <= j2 or j2 + M <= j1):
                        answer = max(answer, profit[i1][j1] + profit[i2][j2])

    print(f"#{t} {answer}")