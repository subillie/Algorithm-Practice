# 18258 큐 2
from collections import deque
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
queue = deque()
for n in range(N):
    cmd = INPUT().rstrip()
    if cmd == "pop":
        try:
            print(queue.popleft())
        except:
            print(-1)
    elif cmd == "size":
        print(len(queue))
    elif cmd == "empty":
        print(0) if queue else print(1)
    elif cmd == "front":
        print(queue[0]) if queue else print(-1)
    elif cmd == "back":
        print(queue[-1]) if queue else print(-1)
    else:  # cmd == "push"
        param = cmd.split()[1]
        queue.append(param)