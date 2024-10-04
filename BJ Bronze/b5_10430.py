import sys

INPUT = sys.stdin.readline

num = list(map(int, INPUT().split()))
A, B, C = num[0], num[1], num[2]

print((A + B) % C)
print(((A % C) + (B % C)) % C)
print((A * B) % C)
print(((A % C) * (B % C)) % C)