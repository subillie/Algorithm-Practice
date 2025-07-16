# 3986 좋은 단어
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
count = 0
for _ in range(N):
    word = INPUT().rstrip()
    stack = []
    for c in word:
        if stack and c == stack[-1]:
            stack.pop()
        else:
            stack.append(c)
    if not stack:
        count += 1
print(count)