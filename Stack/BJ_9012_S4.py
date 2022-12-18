import sys
INPUT = sys.stdin.readline

num = int(INPUT())

for i in range(num):
  stack = []
  flag = 1
  tmp = INPUT().rstrip()
  lenTmp = len(tmp)
  for j in range(lenTmp):
    if tmp[lenTmp - j - 1] == ')': stack.append(1)
    else:
      if len(stack) == 0:
        flag = 0
        break
      else: stack.pop()
  if flag == 1 and len(stack) == 0: print("YES")
  else: print("NO")
