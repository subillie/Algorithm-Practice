from math import floor
import sys

input = sys.stdin.readline
X, Y = map(float, input().split())
Z = floor(100 * Y / X)
low, high = 0, 1000000000
if Z >= 99: print(-1)
else:
    while low <= high:
        mid = (low + high)//2
        tmpX, tmpY = X + mid, Y + mid
        if floor(100 * tmpY / tmpX) > Z: high = mid - 1
        else: low = mid + 1
    print(high + 1)
