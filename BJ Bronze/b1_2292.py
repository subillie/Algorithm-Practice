# 2292 벌집
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
count = 1
num = 1
while N > num:
    num += 6 * count
    count += 1
print(count)