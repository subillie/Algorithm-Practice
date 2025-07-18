# 2309 일곱 난쟁이
from itertools import permutations
import sys
INPUT = sys.stdin.readline

dwarves = sorted([int(INPUT()) for _ in range(9)])
for cb in permutations(dwarves, 7):
    if sum(cb) == 100:
        print(*cb, sep="\n")
        break