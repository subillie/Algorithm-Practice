# 조건절 연산자 우선순위 (not > and > or)
x = 1
y = -1
if not x > 0 and y > 0:
    print("HI")  # HI
if (not x > 0) and y > 0:
    print("hi")  # hi
if not (x > 0 and y > 0):
    print("hello")  # 출력X
