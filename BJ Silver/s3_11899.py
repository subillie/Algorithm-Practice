# 11899 괄호 끼워넣기
import sys
INPUT = sys.stdin.readline

parentheses = INPUT().rstrip()
count = 0
stack = []
for p in parentheses:
    if p == '(':
        stack.append('(')
    elif p == ')':
        if stack:
            stack.pop()
        else:
            count += 1
count += len(stack)
print(count)