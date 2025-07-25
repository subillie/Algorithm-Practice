# 2635 수 이어가기
import sys
INPUT = sys.stdin.readline

def rule(lst):
    while True:
        new_num = lst[-2] - lst[-1]
        if new_num < 0:
            break
        lst.append(new_num)

N = int(INPUT())
max_len = 0
max_lst = []
for n in range(1, N + 1):
    lst = [N, n]
    rule(lst)
    if max_len < len(lst):
        max_len = len(lst)
        max_lst = lst
print(max_len)
print(*max_lst)