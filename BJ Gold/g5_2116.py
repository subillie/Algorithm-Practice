# 2116 주사위 쌓기
from enum import IntEnum
import sys
INPUT = sys.stdin.readline

class Dice(IntEnum):
    A = 0
    B = 1
    C = 2
    D = 3
    E = 4
    F = 5

def get_next_index(lst: list, val: int) -> int:
    idx = lst.index(val)
    if idx == Dice.A:
        return Dice.F
    elif idx == Dice.B:
        return Dice.D
    elif idx == Dice.C:
        return Dice.E
    elif idx == Dice.D:
        return Dice.B
    elif idx == Dice.E:
        return Dice.C
    else:
        return Dice.A


N = int(INPUT())
dices = [list(map(int, INPUT().split())) for _ in range(N)]

max_result = 0
for dice in dices[0]:
    val = dice
    result = 0
    for i in range(N):
        next_idx = get_next_index(dices[i], val)
        next_val = dices[i][next_idx]
        nums = [1, 2, 3, 4, 5, 6]
        nums.remove(val)
        nums.remove(next_val)
        result += max(nums)
        val = next_val
    max_result = max(max_result, result)
print(max_result)