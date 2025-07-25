# 2491 수열
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
nums = list(map(int, INPUT().split()))

max_len = 1
# 증가하는 순열
length = 1
prev = nums[0]
for num in nums[1:]:
    if prev <= num:
        length += 1
        max_len = max(max_len, length)
    else:
        length = 1
    prev = num
# 감소하는 순열
length = 1
prev = nums[0]
for num in nums[1:]:
    if prev >= num:
        length += 1
        max_len = max(max_len, length)
    else:
        length = 1
    prev = num

print(max_len)