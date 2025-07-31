# 2527 직사각형
import sys
INPUT = sys.stdin.readline

for _ in range(4):
    x1, y1, x2, y2, x3, y3, x4, y4 = map(int, INPUT().split())

    # d: 아예 겹치지 않음
    if x2 < x3 or x4 < x1 or y2 < y3 or y4 < y1:
        print("d")

    # c: 꼭짓점에서 만남
    elif (x2 == x3 and y2 == y3) or (x2 == x3 and y1 == y4) or \
         (x1 == x4 and y2 == y3) or (x1 == x4 and y1 == y4):
        print("c")

    # b: 선분으로 만남 (x나 y가 겹침)
    elif x2 == x3 or x1 == x4 or y2 == y3 or y1 == y4:
        print("b")

    # a: 면적으로 겹침
    else:
        print("a")