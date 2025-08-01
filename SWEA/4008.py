# 4008 숫자 만들기
from math import floor
from itertools import permutations

T = int(input())
for t in range(1, T + 1):
    N = int(input())
    # operator index : 0(+), 1(-), 2(*), 3(/)
    operators = list(map(int, input().split()))
    operands = list(map(int, input().split()))

    min_res = float("inf")
    max_res = -float("inf")
    for perm in permutations(operators, N - 1):
        perm = list(perm)
        result = operands[0]
        for i in range(1, N - 1):
            a = operands[i]
            operator = perm[i - 1]
            if operator == 0:
                result += a
            elif operator == 1:
                result -= a
            elif operator == 2:
                result *= a
            else:
                result /= a
                result = floor(result)
        min_res = min(min_res, result)
        max_res = max(max_res, result)

    print(f"#{t}", max_res - min_res)