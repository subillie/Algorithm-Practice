# 3052 나머지
import sys
INPUT = sys.stdin.readline

print(len(set([int(INPUT()) % 42 for _ in range(10)])))