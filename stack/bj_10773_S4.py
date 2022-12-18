import sys
INPUT = sys.stdin.readline

stack = []
sum = 0
K = int(INPUT())

for _ in range(K):
  num = int(INPUT())
  if num == 0:
    if len(stack) == 0: continue
    else: stack.pop()
  else:
    stack.append(num)

for i in stack:
  sum += i
print(sum)
