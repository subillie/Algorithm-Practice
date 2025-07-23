# 5432 쇠막대기 자르기
T = int(input())
for t in range(1, T + 1):
    count = 0
    stack = []
    for p in input():
        if p == "(":
            stack.append(p)
            is_laser = True
        else:
            stack.pop()
            if is_laser:
                count += len(stack)
            else:
                count += 1
            is_laser = False
    print(f"#{t}", count)