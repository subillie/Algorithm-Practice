# 3190 뱀
from collections import deque
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
K = int(INPUT())
board = [[''] * N for _ in range(N)]
for _ in range(K):
    row, col = map(int, INPUT().split())
    board[row - 1][col - 1] = 'apple'

L = int(INPUT())
instruction = []
for _ in range(L):
    X, C = INPUT().split()
    direction = 1 if C == 'D' else -1
    instruction.append((int(X), direction))

# 0 동, 1 남, 2 서, 3 북
dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]
direction = 0  # 뱀은 처음에 board의 오른쪽을 보고 있음

snake = deque()
snake.append((0, 0))
board[0][0] = 'snake'

time = 0
turn_head = 0

while True:
    time += 1
    head_x, head_y = snake[-1]
    nx = head_x + dx[direction]
    ny = head_y + dy[direction]

    # 벽이나 자기 자신의 몸과 부딪힌 경우
    if not (0 <= nx < N and 0 <= ny < N) or board[ny][nx] == 'snake':  
        print(time)
        break

    if board[ny][nx] == 'apple':  # 사과 냠
        board[ny][nx] = 'snake'
        snake.append((nx, ny))
    else:  # 아무 것도 없는 칸
        board[ny][nx] = 'snake'
        snake.append((nx, ny))
        tail_x, tail_y = snake.popleft()
        board[tail_y][tail_x] = ''
    
    # 지시에 따라 방향 전환
    if turn_head < L and time == instruction[turn_head][0]:
        direction = (direction + instruction[turn_head][1]) % 4
        turn_head += 1
