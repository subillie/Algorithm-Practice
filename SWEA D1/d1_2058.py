# 2058 자릿수 더하기
from functools import reduce

print(reduce(lambda x, y: int(x) + int(y), list(input())))