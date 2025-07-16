# 15815 천재 수학자 성필
import sys
INPUT = sys.stdin.readline

operand = "0123456789"
operator = "+-*/"
expression = INPUT().rstrip()
stack = []
for exp in expression:
    if exp in operand:
        stack.append(int(exp))
    elif exp in operator:
        b = stack.pop()
        a = stack.pop()
        if exp == '+':
            stack.append(a + b)
        elif exp == '-':
            stack.append(a - b)
        elif exp == '*':
            stack.append(a * b)
        elif exp == '/':
            stack.append(a // b)
print(stack.pop())