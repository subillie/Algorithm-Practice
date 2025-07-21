# 2063 중간값 찾기
N = int(input())
nums = sorted(list(map(int, input().split())))
print(nums[N // 2])