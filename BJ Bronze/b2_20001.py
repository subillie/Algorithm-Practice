# 20001 고무오리 디버깅
from collections import deque
import sys
INPUT = sys.stdin.readline

INPUT()
duck = deque()
while True:
    command = INPUT().rstrip()
    if command == "문제":
        duck.append("problem")
    elif command == "고무오리":
        try:
            duck.popleft()
        except:
            duck.append("problem")
            duck.append("problem")
    elif command == "고무오리 디버깅 끝":
        break
if len(duck) == 0:
    print("고무오리야 사랑해")
else:
    print("힝구")