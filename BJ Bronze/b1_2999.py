# 2999 비밀 이메일
from math import sqrt
import sys
INPUT = sys.stdin.readline

msg = INPUT().rstrip()
msg_len = len(msg)
for r in range(int(sqrt(msg_len)), 0, -1):
    if msg_len % r == 0:
        c = msg_len // r
        break
matrix = [[msg[row * c + col] for col in range(c)] for row in range(r)]
for col in range(c):
    for row in range(r):
        print(matrix[row][col], end="")
print()