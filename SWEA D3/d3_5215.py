# 5215 햄버거 다이어트
from itertools import combinations

T = int(input())
for t in range(1, T + 1):
    N, L = map(int, input().split())
    ingredients = [list(map(int, input().split())) for _ in range(N)]
    ingredients.sort(key=lambda x: -x[1])  # 칼로리 기준 내림차순 정렬

    max_score = 0
    for n in range(1, N + 1):
        for ingredient in combinations(ingredients, n):
            lst = list(zip(*ingredient))
            score = sum(lst[0])
            calories = sum(lst[1])
            if calories <= L:  # 기준 칼로리 이하일 때 점수 갱신
                max_score = max(max_score, score)

    print(f"#{t}", max_score)
