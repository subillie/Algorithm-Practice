# 14696 딱지놀이
import sys
INPUT = sys.stdin.readline

N = int(INPUT())
for _ in range(N):
  A = list(map(int, INPUT().split()))[1:]
  B = list(map(int, INPUT().split()))[1:]
  for i in range(4, 0, -1):
    if A.count(i) > B.count(i):
      print("A")
      break
    elif A.count(i) < B.count(i):
      print("B")
      break
    elif i == 1:
      print("D")