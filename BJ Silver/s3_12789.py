# 12789 도키도키 간식드리미
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
wait_queue = list(map(int, INPUT().split()))
stack = []
turn = 1

while wait_queue or stack:
    if wait_queue and wait_queue[0] == turn:
        wait_queue.pop(0)
        turn += 1
    elif stack and stack[-1] == turn:
        stack.pop()
        turn += 1
    elif wait_queue:
        stack.append(wait_queue.pop(0))
    else:  # 순서대로 배급이 끝났는데 stack에 학생들이 남아있는 경우
        break
print("Nice" if not stack else "Sad")