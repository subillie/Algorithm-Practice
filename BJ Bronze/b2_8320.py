# 8320 직사각형을 만드는 방법
from math import sqrt
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
count = 0
for n in range(1, N + 1):
    for i in range(1, int(sqrt(n)) + 1):
        if n % i == 0:
            count += 1
print(count)