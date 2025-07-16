# 2164 카드2
from collections import deque
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
queue = deque([n + 1 for n in range(N)])

while len(queue) > 1:
    queue.popleft()
    queue.append(queue.popleft())
print(queue.popleft())