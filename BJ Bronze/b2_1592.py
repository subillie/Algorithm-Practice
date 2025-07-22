# 1592 영식이와 친구들
import sys
INPUT = sys.stdin.readline

N, M, L = map(int, INPUT().split())
ball_count = [0] * N  # 던진 횟수 저장
turn = 0
ball_count[turn] += 1
while ball_count[turn] != M:
    if ball_count[turn] % 2 == 0:
        turn = (turn - L) % N
    else:
        turn = (turn + L) % N
    ball_count[turn] += 1
print(sum(ball_count) - 1)  # 받은 횟수 출력