# 24379 거듭제곱 후 나누기
from decimal import Decimal
from math import floor

T = int(input())
for _ in range(T):
    X, Y, Z = map(int, input().split())
    num = (Decimal(X) ** Decimal(Y)) / Decimal(Z)

    integer_part = floor(num) % 1000
    if floor(num) // 1000 > 0:
        integer_part = "{:03d}".format(integer_part)
    decimal_part = floor(num * 1000) % 1000
    if floor(num * 1000) // 1000 > 0:
        decimal_part = "{:03d}".format(decimal_part)
    print(integer_part, ".", decimal_part, sep="")

    # num_sep = str(num).split(".")
    # if len(num_sep) == 1:
    #     num_sep.append("000")
    # print(num_sep[0][-3:], ".", num_sep[1][:3], sep="")