# 1009 분산처리
import sys
INPUT = sys.stdin.readline

T = int(INPUT())
for _ in range(T):
  a, b = map(int, INPUT().split())
  # print(str(a ** b)[-1])  # 시간 초과

  a %= 10
  if a == 0:  # 패턴 1개
    print(10)
  elif a == 1 or a == 5 or a == 6:  # 패턴 1개
    print(a)
  elif a == 4 or a == 9:  # 패턴 2개
    if b % 2 == 0:
      print((a * a) % 10)
    else:
      print(a)
  else:  # 패턴 3개
    if b % 4 == 0:
      print((a ** 4) % 10)
    else:
      print((a ** b) % 10)