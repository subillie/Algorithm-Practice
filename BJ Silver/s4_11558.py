# 11558 The Game Of Death
import sys
INPUT = sys.stdin.readline

T = int(INPUT())
for _ in range(T):
  N = int(INPUT())
  players = [(int(INPUT()) - 1) for __ in range(N)]
  now = 0  # 희현이부터 시작
  count = 0
  able = False
  while players[now] >= 0:
    next = players[now]  # 다음 사람 지목
    count += 1
    if next == N - 1:  # 주경이가 걸리면 끝
      able = True
      break
    players[now] = -1  # 방문 표시
    now = next
  if not able:
    count = 0
  print(count)