import sys

INPUT = sys.stdin.readline

### 방법1 set 이용하기

# N = int(input())
# A = set(map(int, input().split()))
# M = int(input())
# targets = list(map(int, input().split()))
# for t in targets:
#     print(1) if t in A else print(0)

### 방법2 binary search

N = int(INPUT())
A = list(map(int, INPUT().split()))
A.sort()
M = int(INPUT())
targets = list(map(int, INPUT().split()))

for t in targets:
  flag = 0
  start = 0
  end = len(A) - 1
  while start <= end:
    mid = (start + end) // 2
    if A[mid] == t:
      flag = 1
      break
    elif A[mid] > t:
      end = mid - 1
    else:
      start = mid + 1
  print(flag)
