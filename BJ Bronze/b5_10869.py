import sys

INPUT = sys.stdin.readline

a, b =  INPUT().split()
A, B = int(a), int(b)

print(A + B)
print(A - B)
print(A * B)
print(A // B) # 몫
print(A % B)  # 나머지