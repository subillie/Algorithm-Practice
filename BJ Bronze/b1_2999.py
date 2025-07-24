# 2999 비밀 이메일
from math import sqrt
import sys
INPUT = sys.stdin.readline

msg = INPUT().rstrip()
length = len(msg)

for R in range(int(sqrt(length)), 0, -1):
    if length % R == 0:
        C = length // R
        break

for r in range(R):
    for c in range(C):
        print(msg[c * R + r], end="")
print()