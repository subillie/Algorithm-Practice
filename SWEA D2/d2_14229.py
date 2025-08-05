# 14229 백만 개의 정수 정렬
MAX_VAL = 1000000
TARGET_IDX = 500000

data = list(map(int, input().split()))
counts = [0] * (MAX_VAL + 1)
for num in data:
    counts[num] += 1

for i in range(1, MAX_VAL + 1):
    counts[i] += counts[i - 1]

tmp = [0] * MAX_VAL
for num in reversed(data):
    counts[num] -= 1
    tmp[counts[num]] = num

print(tmp[TARGET_IDX])