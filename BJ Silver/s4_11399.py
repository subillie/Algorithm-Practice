# 11399 ATM
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
wait = sorted(list(map(int, INPUT().split())))
print(sum([sum(wait[0:i + 1]) for i in range(len(wait))]))