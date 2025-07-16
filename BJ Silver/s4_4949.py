# 4949 균형잡힌 세상
import sys
INPUT = sys.stdin.readline

while True:
    line = INPUT().rstrip()
    if line == '.':
        break

    stack = []
    balanced = True
    for c in line:
        if c in "([":
            stack.append(c)
        elif c in ")]":
            if stack and stack[-1] == '(' and c == ')':
                stack.pop()
            elif stack and stack[-1] == '[' and c == ']':
                stack.pop()
            else:
                balanced = False
                break
    print("yes") if balanced and not stack else print("no")