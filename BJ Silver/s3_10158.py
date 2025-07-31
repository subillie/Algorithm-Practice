# 10158 개미
import sys
INPUT = sys.stdin.readline

w, h = map(int, INPUT().split())
p, q = map(int, INPUT().split())
t = int(INPUT())

# 처음에 주어진 개미의 위치가
dx = (p + t) // w  # 증가하는 부분인지 감소하는 부분인지 확인
dy = (q + t) // h  # 증가하는 부분인지 감소하는 부분인지 확인

if dx % 2 == 0:  # 증가하는 부분인 경우
    x = (p + t) % w
else:  # 감소하는 부분인 경우
    x = w - (p + t) % w

if dy % 2 == 0:  # 증가하는 부분인 경우
    y = (q + t) % h
else:  # 감소하는 부분인 경우
    y = h - (q + t) % h

print(x, y)

# 시간 초과
# x, y = p, q
# dx, dy = 1, -1  # 오른쪽 아래
# for _ in range(t):
#     if not 0 <= x + dx <= w:
#         dx *= -1
#     if not 0 <= y + dy <= h:
#         dy *= -1
#     x += dx
#     y += dy
# print(x, y)