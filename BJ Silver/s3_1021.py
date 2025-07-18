# 1021 회전하는 큐
from collections import deque
import sys
INPUT = sys.stdin.readline

N, M = map(int, INPUT().split())
targets = list(map(int, INPUT().split()))
deq = deque([n + 1 for n in range(N)])
count = 0
for t in targets:
    while True:
        if deq[0] == t:  # 1. 첫 번째 원소를 뽑아냄
            deq.popleft()
            break
        if deq.index(t) <= len(deq) // 2:  # 2. 왼쪽으로 한 칸 이동
            deq.append(deq.popleft())
            count += 1
        else:  # 3. 오른쪽으로 한 칸 이동
            deq.appendleft(deq.pop())
            count += 1
print(count)